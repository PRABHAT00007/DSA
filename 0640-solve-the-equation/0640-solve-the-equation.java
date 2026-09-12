class Solution {
    public String solveEquation(String equation) {

        String[] parts = equation.split("=");

        int[] left = calculate(parts[0]);
        int[] right = calculate(parts[1]);

        int x = left[0] - right[0];
        int constant = right[1] - left[1];

        if (x == 0 && constant == 0) {
            return "Infinite solutions";
        }

        if (x == 0) {
            return "No solution";
        }

        return "x=" + (constant / x);
    }

    private int[] calculate(String s) {

        int x = 0;
        int constant = 0;

        int sign = 1;
        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            } 
            else if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            boolean hasNumber = false;

            while (i < s.length() && 
                   Character.isDigit(s.charAt(i))) {

                num = num * 10 + (s.charAt(i) - '0');
                i++;
                hasNumber = true;
            }

            if (i < s.length() && s.charAt(i) == 'x') {

                if (!hasNumber) {
                    num = 1;
                }

                x += sign * num;
                i++;
            } 
            else {
                constant += sign * num;
            }
        }

        return new int[]{x, constant};
    }
}