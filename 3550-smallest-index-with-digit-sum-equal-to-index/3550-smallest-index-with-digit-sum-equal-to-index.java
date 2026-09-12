class Solution {
    public int smallestIndex(int[] nums) {
        int digiSum=0;
        for(int i=0;i<nums.length;i++)
        {
            int temp=nums[i];
            while(temp>0)
            {
                digiSum+=temp%10;
                temp=temp/10;
            }
            if(digiSum==i)
            return i;
            digiSum=0;
            temp=0;
        }
    return -1;}
}