class Solution {
    public String removeTrailingZeros(String num) {
        StringBuilder sb=new StringBuilder(num);

        sb.reverse();int currIndex=0;
        for(int i=0;i<sb.length();i++)
        {
            if(sb.charAt(i)=='0')
            currIndex++;
            else
            break;
        }
        sb.delete(0,currIndex);
    return sb.reverse().toString();}
}