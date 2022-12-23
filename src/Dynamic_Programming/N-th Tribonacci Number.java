class Solution {
    public int tribonacci(int n) {
        return nthTribo(n, new HashMap<>());
    }
    private int nthTribo(int n, HashMap<Integer, Integer> memo){

        if(n <= 1) return n;

        if(n == 2) return 1;
        
        int currentKey = n;

        if(memo.containsKey(currentKey))
            return memo.get(currentKey);

        int a = nthTribo(n-1, memo);
        int b = nthTribo(n-2, memo);
        int c = nthTribo(n-3, memo);
        
        memo.put(currentKey, a+b+c);
        return memo.get(currentKey);
    }
}
