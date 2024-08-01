import java.util.Scanner;
import java.util.Arrays;

public class TwoPointers {
    //sort the same binary array using two pointer approach
    //helper function swap
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void sortArrayUsing2pointer(int arr[]) {
        int start = 0;
        int end = arr.length-1;

        while(start < end) {
            if(arr[start] == 1 && arr[end] == 0) {
                swap(arr, start, end);
                start++;
                end--;
            } 
            if(arr[start] == 0) {
                start++;
            }
            if(arr[end] == 1) {
                end--;
            }
        }
    }
    //sort an array consisting of only 0s and 1s
    static void sortArray(int arr[]) {
        System.out.println("Before sorting : " + Arrays.toString(arr));
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                count++;
            }
        }
        int[] newArr = new int[arr.length];
        for(int i = count; i < arr.length; i++) {
            newArr[i] = 1;
        }
        System.out.println("Sorted array : " + Arrays.toString(newArr));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements : ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sortArrayUsing2pointer(arr);
        System.out.println("After the sorting : " + Arrays.toString(arr));
    }
}
