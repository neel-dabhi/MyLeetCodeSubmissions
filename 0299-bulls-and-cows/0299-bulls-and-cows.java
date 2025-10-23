class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        HashMap<Integer, Integer> secretMap = new HashMap<>();
        HashMap<Integer, Integer> guessMap = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {

            Integer sec = secret.charAt(i) - '0';
            Integer gue = guess.charAt(i) - '0';

            if (sec == gue) {
                bulls++;
            } else {
                secretMap.put(sec, secretMap.getOrDefault(sec, 0) + 1);
                guessMap.put(gue, guessMap.getOrDefault(gue, 0) + 1);
            }
        }

        for (Integer gue : guessMap.keySet()) {
            cows = cows + Math.min(secretMap.getOrDefault(gue, 0), guessMap.getOrDefault(gue, 0));
        }

        return bulls + "A" + cows + "B";
    }
}