class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < letters.length; i++) {

            int diff = letters[i] - target;

            if (diff > 0 && diff < min) {
                min = diff;
                minIndex = i;
            }
        }

        if (min == Integer.MAX_VALUE) {
            return letters[0];
        }

        return letters[minIndex];
    }
}