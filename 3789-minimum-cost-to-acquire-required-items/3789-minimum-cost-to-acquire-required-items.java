class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long answer = (long) need1 * cost1 + (long) need2 * cost2;

        long minimum = Math.min(need1, need2);
        long maximum = Math.max(need1, need2);

        long option1 = minimum * costBoth
                + (long)(need1 - minimum) * cost1
                + (long)(need2 - minimum) * cost2;

        long option2 = maximum * costBoth;

        return Math.min(answer, Math.min(option1, option2));
    }
}