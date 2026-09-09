class Solution {
    public int numberOfSpecialChars(String word) {
        int freq[]=new int[127];int count=0;
        for(int i=0;i<word.length();i++)
        {
            freq[word.charAt(i)]++;
        }
        for(int i=65;i<=91;i++)
        {
            if(freq[i]>=1)
            {
                if(freq[i+32]>=1)
                count++;
            }
        }
   return count; }
}