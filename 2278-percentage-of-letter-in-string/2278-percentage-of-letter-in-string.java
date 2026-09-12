class Solution {
    public int percentageLetter(String s, char letter) {
        int frequency=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==letter)
            frequency++;
        }
        return (frequency*100)/s.length();
    }
}