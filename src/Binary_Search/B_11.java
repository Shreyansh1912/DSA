import java.io.; 
import java.util.;

class Demo {

public static void main(String args[]) {
    int arr[] = { 1, 2, 4, 6, 8, 9, 12, 14, 17, 21, 45 };
    int index = findPos(arr, 45);
    if (index == -1)
        System.out.println("Element not found!");
    else
        System.out.println("Element found! index = " + index);
}
  /* 1-Brute Force approach : Using linear Search
    2-Increment by a constant value and using binary search TC:O(N)
    3-Increment by an exponential order and using binary search TC: O(logN)
  */


static int findPos(int arr[], int value) {
    int start = 0, end = 1;
    while (arr[end] < value) {
        start = end;
        end = 2 * end;
        // we know it is infinite but if it has finite elements it will reduce the
        // overflow of legth to n-1 element other wise the code will fail has array
        // index out of bound exception
        if (end > arr.length) {
            end = arr.length - 1;
        }
    }
    return binarySearch(arr, start, end, value);
}

static int binarySearch(int arr[], int start, int end, int ele) {
    if (end >= start) {
        int mid = start + (end - start) / 2;
        if (arr[mid] == ele)
            return mid;
        if (arr[mid] > ele)
            return binarySearch(arr, start, mid - 1, ele);
        return binarySearch(arr, mid + 1, end, ele);
    }
    return -1;
}
}
