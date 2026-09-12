class Solution {
    public char repeatedCharacter(String s) {
     int[] freq=new int[127];

     for(int i=0;i<s.length();i++)
     {
        if(freq[s.charAt(i)]==1)
        return s.charAt(i);
        freq[s.charAt(i)]++;
     }   
    return 'A';}
}