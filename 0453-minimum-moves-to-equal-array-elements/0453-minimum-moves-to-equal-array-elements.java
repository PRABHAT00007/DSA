class Solution {
    public int minMoves(int[] nums) {
        int minimum=Integer.MAX_VALUE;
        int total=0;
        for (int num : nums) {
            minimum = Math.min(minimum, num);
            total+= num;
        }
    return total - minimum * nums.length;
    }
}