class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        // room -> meeting count

        int[] meetingCount = new int[n];

        // lowest available room
        PriorityQueue<Integer> roomsAvailable = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            roomsAvailable.add(i);
        }

        // stores which meeting ends first [room, endtime]
        PriorityQueue<long[]> meetingEnds = new PriorityQueue<long[]>((a, b) -> {
            if (a[1] != b[1]) {
                return Long.compare(a[1], b[1]);
            } else {
                return Long.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < meetings.length; i++) {
            long start = meetings[i][0];
            long end = meetings[i][1];
            int room;
            long delay;

            // freeing room whoes meeting already ended 
            while (!meetingEnds.isEmpty() && meetingEnds.peek()[1] <= start) {
                roomsAvailable.add((int)meetingEnds.poll()[0]);
            }

            if (!roomsAvailable.isEmpty()) {
                // assign room
                room = roomsAvailable.poll();
                delay = 0;

            } else {
                // wait untill free
                long[] soonEndingMeeting = meetingEnds.poll();

                room = (int)soonEndingMeeting[0];
                delay = soonEndingMeeting[1] - start;

            }
            meetingEnds.add(new long[] { room, end + delay });
            meetingCount[room] = meetingCount[room] + 1;
        }

        int result = 0;

        for (int i = 1; i < n; i++) {
            if (meetingCount[i] > meetingCount[result]) {
                result = i;
            }
        }

        return result;
    }
}