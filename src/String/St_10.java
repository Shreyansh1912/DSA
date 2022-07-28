class Solution {
    public String addStrings(String nums1, String nums2) {
        String res = "";
        
        int i = nums1.length() - 1;
        int j = nums2.length() - 1;
        
        int carry = 0;
        
        while(i >= 0 || j >= 0 || carry != 0){
            int ival = i >= 0 ? nums1.charAt(i)-'0':0;
            int jval = j >= 0 ? nums2.charAt(j)-'0':0;
            
            i--;
            j--;
            
            int sum = ival + jval + carry;
            res = (sum % 10) + res;
            carry = sum / 10;
        }
        return res;
    }
}
