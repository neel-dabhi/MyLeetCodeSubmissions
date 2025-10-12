class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];

        // a --> [b, valueOf(a/b)];
        HashMap<String, HashMap<String, Double>> adj = buildGraph(equations, values);

        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            result[i] = evaluateWithBFS(q.get(0), q.get(1), adj);
        }

        return result;
    }

    private double evaluateWithBFS(String start, String end, HashMap<String, HashMap<String, Double>> adj) {

        if (!adj.containsKey(start) || !adj.containsKey(end)) {
            return -1.0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> nodeBfs = new LinkedList<>();
        Queue<Double> evalBfs = new LinkedList<>();

        // prune bfs with startNodes neighbours
        for (Map.Entry<String, Double> val : adj.get(start).entrySet()) {

            nodeBfs.add(val.getKey());
            evalBfs.add(val.getValue());

            visited.add(val.getKey());

        }

        while (!nodeBfs.isEmpty()) {
            String currNode = nodeBfs.poll();
            Double currEval = evalBfs.poll();

            Map<String, Double> nbrs = adj.get(currNode);
            // found end
            if (nbrs.containsKey(end)) {
                return currEval * nbrs.get(end);
            }

            for (String key : nbrs.keySet()) {
                if (!visited.contains(key)) {
                    nodeBfs.add(key);
                    evalBfs.add(currEval * nbrs.get(key));

                    visited.add(key);
                }
            }
        }
        return -1.0;
    }

    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {

        HashMap<String, HashMap<String, Double>> adj = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);

            // a/b
            adj.putIfAbsent(eq.get(1), new HashMap<>());
            adj.get(eq.get(1)).put(eq.get(0), 1 / values[i]);
            // b/a
            adj.putIfAbsent(eq.get(0), new HashMap<>());
            adj.get(eq.get(0)).put(eq.get(1), values[i]);

        }

        return adj;
    }
}