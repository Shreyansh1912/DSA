class Solution {
    public boolean isMonotonic(int[] arr) {
        boolean increasing = true;
        boolean decreasing = true;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]) increasing = false;
            if(arr[i] < arr[i+1]) decreasing = false;
        }
        return increasing || decreasing;
    }
}
