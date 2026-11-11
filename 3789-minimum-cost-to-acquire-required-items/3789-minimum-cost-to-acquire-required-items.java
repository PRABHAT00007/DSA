
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long ans = (long) need1 * cost1 + (long) need2 * cost2;

        long min = Math.min(need1, need2);
        long max = Math.max(need1, need2);

        long option1 = min * costBoth
                + (long)(need1 - min) * cost1
                + (long)(need2 - min) * cost2;

        long option2 = max * costBoth;

        return Math.min(ans, Math.min(option1, option2));
    }
}
