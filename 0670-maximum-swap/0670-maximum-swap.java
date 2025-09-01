class Solution {
    public int maximumSwap(int num) {

        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder number = new StringBuilder(String.valueOf(num));

        for (int i = 0; i < number.length(); i++) {
            map.put(number.charAt(i) - '0', i);
        }

        for (int i = 0; i < number.length(); i++) {
            int curr = number.charAt(i) - '0';

            for (int j = 9; j > curr; j--) {
                if (map.containsKey(j)) {

                    if (map.get(j) > i) {
                        int swapIndex = map.get(j);
                        char temp = number.charAt(i);

                        number.setCharAt(i, number.charAt(swapIndex));
                        number.setCharAt(swapIndex, temp);
                        return Integer.valueOf(number.toString());
                    }
                }
            }
        }

        return Integer.valueOf(number.toString());
    }
}