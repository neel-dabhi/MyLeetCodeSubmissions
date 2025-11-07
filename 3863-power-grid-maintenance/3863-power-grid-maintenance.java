class Solution {
    HashMap<Integer, List<Integer>> adjMap;
    HashMap<Integer, PriorityQueue<Integer>> pqMap = new HashMap<>();
    Set<Integer> online;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        online = new HashSet<>();
        adjMap = new HashMap<>();
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            if (!adjMap.containsKey(u)) {
                adjMap.put(u, new ArrayList<>());
            }
            if (!adjMap.containsKey(v)) {
                adjMap.put(v, new ArrayList<>());
            }

            adjMap.get(u).add(v);
            adjMap.get(v).add(u);
        }

        for (int i = 1; i <= c; i++) {
            if (!online.contains(i)) {
                dfs(i, new PriorityQueue<>());
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int op = query[0];
            int node = query[1];

            if (op == 2) {
                online.remove(node);
            } else if (op == 1) {

                if (online.contains(node)) {
                    result.add(node);
                } else {
                    PriorityQueue<Integer> pq = pqMap.get(node);

                    while (!pq.isEmpty() && !online.contains(pq.peek())) {
                        pq.poll();
                    }

                    if (pq.isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(pq.peek());
                    }
                }
            }
        }

        int[] res = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    private void dfs(int i, PriorityQueue<Integer> pq) {
        if (online.contains(i)) {
            return;
        }

        online.add(i);
        pq.add(i);
        pqMap.put(i, pq);

        if (adjMap.get(i) != null) {
            for (int node : adjMap.get(i)) {
                dfs(node, pq);
            }
        }

    }
}