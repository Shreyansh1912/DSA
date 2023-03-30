package segmentTree;

class NumArray {
    int[] nums;
    int[] segmentTree;
    int n;

    public NumArray(int[] nums){
        this.nums = nums;
        n = nums.length;
        segmentTree = new int[4*n];
        constructSegmentTree(0, n-1, 0);
    }

    public void update(int index, int val) {
        nums[index] = val;
        updateSegmentTree(0, n-1, index, val , 0);
    }

    public int sumRange(int left, int right) {
        return getSumRange(left, right, 0, n-1, 0);
    }

    private void updateSegmentTree(int start, int end, int index, int val, int currentIndex){
        if(start > end)
            return;

        if(start == end){
            segmentTree[currentIndex] = val;
            return;
        }
        int mid = start + (end - start) / 2;

        if(index <= mid)
            updateSegmentTree(start, mid, index, val, 2*currentIndex+1);
        else
            updateSegmentTree(mid+1, end, index, val, 2*currentIndex+2);

        segmentTree[currentIndex] = segmentTree[2*currentIndex+1] + segmentTree[2*currentIndex+2];
        return;
    }
    private int getSumRange(int left, int right, int start, int end, int currentIndex){
        if(end < left || start > right)
            return 0;

        if(start >= left && right >= end)
            return segmentTree[currentIndex];

        int mid = start + (end - start) / 2;

        int leftCall =  getSumRange(left, right, start, mid,  2*currentIndex + 1);
        int rightCall = getSumRange(left, right, mid+1, end,  2*currentIndex + 2);

        return leftCall + rightCall;

    }
    private void constructSegmentTree(int start, int end, int currentIndex){
        if(start > end)
            return;

        if(start == end){
            segmentTree[currentIndex] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;

        constructSegmentTree(start, mid, 2*currentIndex+1);
        constructSegmentTree(mid+1, end, 2*currentIndex+2);

        segmentTree[currentIndex] = segmentTree[2*currentIndex+1] + segmentTree[2*currentIndex+2];

        return;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
