class Solution {
    public String firstPalindrome(String[] words) {
        StringBuilder sb = new StringBuilder();String temp="";

        for(int i=0;i<words.length;i++)
        {
            sb.append(words[i]);
            temp+=sb.reverse().toString();
            if(temp.equals(words[i]))
            return temp;
            sb.delete(0,temp.length());
            temp="";
        }
    return "";}
}