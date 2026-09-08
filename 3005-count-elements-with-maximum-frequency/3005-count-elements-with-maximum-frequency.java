class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];int total=0;
        int maxFreq=0;

        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]]++;
            if(arr[nums[i]]>maxFreq)
            maxFreq=arr[nums[i]];

        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==maxFreq)
            total+=maxFreq;
        }
    return total;}
}