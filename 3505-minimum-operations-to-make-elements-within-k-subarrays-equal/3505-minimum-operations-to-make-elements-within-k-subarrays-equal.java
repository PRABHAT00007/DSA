class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        long sumLeft = 0, sumRight = 0;
        int sizeLeft = 0, sizeRight = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            if (sizeLeft == 0 || val <= left.lastKey()) {
                left.put(val, left.getOrDefault(val, 0) + 1);
                sumLeft += val;
                sizeLeft++;
            } else {
                right.put(val, right.getOrDefault(val, 0) + 1);
                sumRight += val;
                sizeRight++;
            }

            while (sizeLeft > sizeRight + 1) {
                int v = left.lastKey();
                left.put(v, left.get(v) - 1);
                if (left.get(v) == 0) left.remove(v);
                sumLeft -= v;
                sizeLeft--;

                right.put(v, right.getOrDefault(v, 0) + 1);
                sumRight += v;
                sizeRight++;
            }

            while (sizeLeft < sizeRight) {
                int v = right.firstKey();
                right.put(v, right.get(v) - 1);
                if (right.get(v) == 0) right.remove(v);
                sumRight -= v;
                sizeRight--;

                left.put(v, left.getOrDefault(v, 0) + 1);
                sumLeft += v;
                sizeLeft++;
            }

            if (i >= x) {
                int v = nums[i - x];

                if (left.containsKey(v)) {
                    left.put(v, left.get(v) - 1);
                    if (left.get(v) == 0) left.remove(v);
                    sumLeft -= v;
                    sizeLeft--;
                } else {
                    right.put(v, right.get(v) - 1);
                    if (right.get(v) == 0) right.remove(v);
                    sumRight -= v;
                    sizeRight--;
                }

                while (sizeLeft > sizeRight + 1) {
                    int a = left.lastKey();
                    left.put(a, left.get(a) - 1);
                    if (left.get(a) == 0) left.remove(a);
                    sumLeft -= a;
                    sizeLeft--;

                    right.put(a, right.getOrDefault(a, 0) + 1);
                    sumRight += a;
                    sizeRight++;
                }

                while (sizeLeft < sizeRight) {
                    int a = right.firstKey();
                    right.put(a, right.get(a) - 1);
                    if (right.get(a) == 0) right.remove(a);
                    sumRight -= a;
                    sizeRight--;

                    left.put(a, left.getOrDefault(a, 0) + 1);
                    sumLeft += a;
                    sizeLeft++;
                }
            }

            if (i >= x - 1) {
                long median = left.lastKey();
                cost[i - x + 1] =
                    median * sizeLeft - sumLeft + sumRight - median * sizeRight;
            }
        }

        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) Arrays.fill(row, INF);

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;

            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];

                if (i >= x && dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}