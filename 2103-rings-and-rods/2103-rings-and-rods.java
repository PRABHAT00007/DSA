class Solution {
    public int countPoints(String rings) {
        Boolean red;Boolean green;Boolean blue;
        int count=0;
        for(char i='0';i<='9';i++)
        {
            red=false;
            green=false;
            blue=false;

            for(int j=0;j<rings.length();j++)
            {
                if(rings.charAt(j)==i)
                {
                    if(rings.charAt(j-1)=='R')
                    red=true;

                    if(rings.charAt(j-1)=='B')
                    blue=true;

                    if(rings.charAt(j-1)=='G')
                    green=true;
                }
            }

                if(red==true && blue==true && green==true)
                count++;
        }
    return count;}
}