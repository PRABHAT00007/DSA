class Solution {
    public int[] findEvenNumbers(int[] digits) {
        boolean[] present = new boolean[1000];

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {

                    if (i == j || j == k || i == k)
                        continue;

                    if (digits[i] == 0)
                        continue;

                    if (digits[k] % 2 != 0)
                        continue;

                    int num = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    present[num] = true;
                }
            }
        }

        int count = 0;

        for (int i = 100; i < 1000; i++) {
            if (present[i])
                count++;
        }

        int[] result = new int[count];
        int index = 0;

        for (int i = 100; i < 1000; i++) {
            if (present[i])
                result[index++] = i;
        }

        return result;
    }
}