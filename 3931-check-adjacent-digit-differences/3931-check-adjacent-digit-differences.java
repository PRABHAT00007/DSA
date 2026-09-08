class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {

        for (int i = 1; i < s.length(); i++) {

            int current = s.charAt(i) - '0';
            int previous = s.charAt(i - 1) - '0';

            if (Math.abs(current - previous) > 2) {
                return false;
            }
        }

        return true;
    }
}