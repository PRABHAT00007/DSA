class Solution {
    public boolean isBalanced(String num) {
        int oddValues=0;
        int evenValues=0;
        int a=0;

        for(int i=0;i<num.length();i++)
        {
            a=num.charAt(i)-'0';
            if(i%2==0)
            evenValues+=a;
            else
            oddValues+=a;
        }
        if(evenValues==oddValues)
        return true;
        else
        return false;
    }
}