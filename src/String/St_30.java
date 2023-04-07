class Solution {
    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length()+1];

        int low = 0;
        int high = s.length();
        int k = 0;
        for(int i=0; i<s.length(); i++){
           if(s.charAt(i) == 'D'){
                 ans[k++] = high--;
           } else{
               ans[k++] = low++;
           }
        }
        ans[k++] = high;
        return ans;
    }
}
