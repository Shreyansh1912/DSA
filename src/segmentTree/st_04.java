package segmentTree;

public class segmentTree {
    int[] nums;
    int[] segmentTree;
    int n;

    segmentTree(int[] nums){
        this.nums = nums;
        n = nums.length;
        segmentTree = new int[4*n];
        Arrays.fill(segmentTree, 0);
        constructSegmentTree(0, n-1, 0);
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

        segmentTree[currentIndex] = segmentTree[2*currentIndex+1] ^ segmentTree[2*currentIndex+2];

        return;
    }
    public int maxQuery(int left, int right) {
        return getMaxQuery(0, n-1, left, right, 0);
    }
    private int getMaxQuery(int start, int end, int left, int right, int currentIndex){
        if(end < left || start > right)
            return 0;

        if(start >= left && right >= end)
            return segmentTree[currentIndex];

        int mid = start + (end - start) / 2;

        int leftCall =  getMaxQuery(start, mid,  left, right, 2*currentIndex + 1);
        int rightCall = getMaxQuery(mid+1, end, left, right,  2*currentIndex + 2);

        return (leftCall ^ rightCall);
    }
    public void updateIndex(int index, int val) {
        nums[index] = val;
        updateSegmentTree(0, n-1, index, val , 0);
    }
    private void updateSegmentTree(int start, int end, int index, int val, int currentIndex){
        if(start > end)
            return;

        if(start == end){
            segmentTree[currentIndex] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;

        if(index <= mid)
            updateSegmentTree(start, mid, index, val, 2*currentIndex+1);
        else
            updateSegmentTree(mid+1, end, index, val, 2*currentIndex+2);

        segmentTree[currentIndex] = segmentTree[2*currentIndex+1] ^ segmentTree[2*currentIndex+2]);
        return;
    }
}

