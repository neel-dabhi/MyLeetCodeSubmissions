class Solution {
    public String predictPartyVictory(String senate) {
        char[] senateArr = senate.toCharArray();
        int offset = senateArr.length;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();

        for (int i = 0; i < senateArr.length; i++) {
            if (senateArr[i] == 'R') {
                rq.add(i);
            } else {
                dq.add(i);
            }
        }

        while (!rq.isEmpty() && !dq.isEmpty()) {

            int r = rq.poll();
            int d = dq.poll();

            if (r < d) {
                rq.add(r + offset);
            } else {
                dq.add(d + offset);
            }
        }

        if (rq.isEmpty()) {
            return "Dire";
        }

        return "Radiant";
    }
}