class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int c=0;
        for(int i = 0; i < n; i++){
               int ch = word.charAt(i);
            if(ch >= 65 && ch < 91)
                c++;
        }
        if(c == 0) return true;
        if(c == n) return true;
        if(c == 1 && word.charAt(0) >= 65 && word.charAt(0) < 91) return true;
        
        return false;
    }
}
