class Solution {
    public int dayOfYear(String date) {
        String s[]=date.split("-");
        int y=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        int d=Integer.parseInt(s[2]);
        int l=0,x=0;
        if(y%400==0 || (y%100!=0 && y%4==0))
        l=1;
        
        int a[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int b[]={0,31,29,31,30,31,30,31,31,30,31,30,31};
        if(l==1)
        {
            for(int i=0;i<m;i++)
            x+=b[i];
            x+=d;
            
        }
        else
        {
            for(int i=0;i<m;i++)
            x+=a[i];
            x+=d;
        }
        return x;
    }
}
