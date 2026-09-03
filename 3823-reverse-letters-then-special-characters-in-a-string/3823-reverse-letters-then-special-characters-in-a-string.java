class Solution {
    public String reverseByType(String s) {
        int i=0;
        int j=s.length()-1;
        char temp;
        char[] arr = s.toCharArray();
        
        while(i<j)
        {
            if(arr[i]>='a'&&arr[i]<='z')
            {
                if(arr[j]>='a'&&arr[j]<='z')
                {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                    i++;
                    j--;
                }
                else
                j--;
            }
            else
            i++;
        }

      int m=0;
        int n=s.length()-1;
        
        while(m<n)
        {
            if(arr[m]<'a'||arr[m]>'z')
            {
                if(arr[n]<'a'||arr[n]>'z')
                {
                    temp=arr[m];
                    arr[m]=arr[n];
                    arr[n]=temp;

                    m++;
                    n--;
                }
                else
                n--;
            }
            else
            m++;
        }
    return new String(arr);}
}