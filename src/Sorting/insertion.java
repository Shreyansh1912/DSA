package Sorting;

import java.util.*;
import java.lang.Math;

class insertion
{
    static void printArray(int arr[],int size)
    {
        int i;
        for(i=0;i<size;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];

            for(int i=0;i<n;i++)
                a[i]= sc.nextInt();

            new Solution99 ().insertionSort(a,n);
            printArray(a,n);

            t--;
        }

    }
}
class Solution99
{
    static void insert(int arr[],int i) {
        // Your code here
    }
    public void insertionSort(int arr[], int n)
    {
        for(int i=1;i<n;i++){
            int j=i-1, temp=arr[i];
            while(j>=0 && arr[j] > temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
