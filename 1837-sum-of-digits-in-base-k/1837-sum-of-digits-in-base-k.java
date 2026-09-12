class Solution {
    public int sumBase(int n, int k) {
        StringBuilder sb=new StringBuilder();int digitSum=0;
        while(n>=k)
        {
            sb.append(n%k);
            n/=k;
        }
        sb.append(n);
        int number=Integer.parseInt(sb.reverse().toString());

        while(number>0)
        {
            digitSum+=number%10;
            number/=10;
        }
   return digitSum; }
}