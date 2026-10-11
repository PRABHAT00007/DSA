class Solution {
    public int sumOfSquares(int[] nums) {
        int sumSquares=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums.length%(i+1)==0)
            sumSquares+=nums[i]*nums[i];
        }
        return sumSquares;
    }
}