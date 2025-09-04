class Solution {
    class Element {
        int number;
        int count;

        Element(int num, int count) {
            this.number = num;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Element> map = new HashMap();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new Element(num, 0));
            }
            Element el = map.get(num);
            el.count++;
            map.put(num, el);
        }

        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.count - b.count);

        for (int num : map.keySet()) {
            pq.add(map.get(num));

            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[] result = new int[pq.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll().number;
        }
        return result;
    }
}