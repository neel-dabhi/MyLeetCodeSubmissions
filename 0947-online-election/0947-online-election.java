// TC: O(n)
// SC: O(n)
class TopVotedCandidate {

    HashMap<Integer, Integer> leaderMap; // time: leader
    HashMap<Integer, Integer> countMap; // leader: count
    int[] timeArray;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.timeArray = times;
        this.leaderMap = new HashMap<>();
        this.countMap = new HashMap<>();

        int currntLeader = persons[0];

        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            int time = times[i];

            if (!countMap.containsKey(person)) {
                countMap.put(person, 0);
            }
            countMap.put(person, countMap.get(person) + 1);

            if (countMap.get(currntLeader) <= countMap.get(person)) {
                currntLeader = person;
            }

            leaderMap.put(time, currntLeader);
        }

    }

    public int q(int t) {

        if (leaderMap.containsKey(t)) {
            return leaderMap.get(t);
        }

        int low = 0;
        int high = timeArray.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (timeArray[mid] < t) {
                low = mid + 1;
            } else if (timeArray[mid] > t) {
                high = mid - 1;
            }
        }

        return leaderMap.get(timeArray[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */