// TC: O(n)
// SC: O(1)
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double taxPaid = 0;
        int prevBracket = 0;
        int i = 0;
        while (income > 0) {
            double percentage = brackets[i][1] / 100.0;
            int currentBracket = brackets[i][0];

            int currentIncome = Math.min(income, currentBracket - prevBracket);

            taxPaid = taxPaid + (currentIncome * percentage);
            income = income - currentIncome;
            prevBracket = currentBracket;
            i++;
        }

        return taxPaid;
    }
}