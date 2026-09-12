class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            int requiredDays = 1;
            int currentWeight = 0;

            for (int w : weights) {
                if (currentWeight + w > mid) {
                    requiredDays++;
                    currentWeight = 0;
                }

                currentWeight += w;
            }

            if (requiredDays <= days) {              
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}