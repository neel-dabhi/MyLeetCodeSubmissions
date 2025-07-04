class Solution {
    class Point {
        int x = 0;
        int y = 0;
        int dist = 0;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a, b) -> b.dist - a.dist);

        for (int i = 0; i < points.length; i++) {
            int X = points[i][0];
            int Y = points[i][1];

            int distFromOrigin = ((0 - X) * (0 - X) + (0 - Y) * (0 - Y));
            pq.add(new Point(X, Y, distFromOrigin));

            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        int size = pq.size();
        for(int i=0; i< size; i++){
            Point point = pq.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;
    }

}