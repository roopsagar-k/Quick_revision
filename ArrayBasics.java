import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayBasics {
    //Create frequency array for the given array
    static int[] makeFrequencyArray(int arr[]) {
        int [] freq = new int[100000];
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            freq[val-1] += 1;
        }
        return freq;
    }
    //rotate an array to k-steps right
        //helper function fot rotate 
        static void reverse(int start, int end, int arr[]) {
            while(start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        static void rotate(int arr[], int k) {
            k = k % arr.length;
            System.out.println("Before rotation: " + Arrays.toString(arr));
            reverse(0, arr.length-1, arr);
            reverse(0, k-1, arr);
            reverse(k, arr.length-1, arr);
            System.out.println("After rotation: " + Arrays.toString(arr));
        }

    //reverse an array with integer values
    static void reverseArray(int arr[]) {
        int i = 0;
        int j = arr.length-1;
        System.out.println("Array before reverse : " + Arrays.toString(arr));
        while(i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println("Array after reverse : " + Arrays.toString(arr));
    }

    
    //swap without using temp variable
    static void swapWithoutTemp(int a, int b) {
        a = (a+b);
        b = a-b;
        a = a-b;
        System.out.println("After swapping the values of a and b are without using the third variable : " + a + " " + b);
    }

    //swap using temp variable
    static void swap(int a, int b) {
        int c = a;
        a = b;
        b = c;
        System.out.println("After swapping values of a and b are : " + a + " " + b);
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
    //    System.out.println("Enter the first number : ");
    //    int x = sc.nextInt();
    //    System.out.println("Enter the second number : ");
    //    int y = sc.nextInt();
    //     swap(x, y);
    //     swapWithoutTemp(x, y);


     System.out.println("Enter the size of the array : ");
     int n = sc.nextInt();
       int arr[] = new int[n];
       System.out.println("Enter the values of the array : ");
       for(int i=0; i<arr.length; i++) {
        arr[i] = sc.nextInt();
       }
        int freq[] = makeFrequencyArray(arr);
        System.out.println("Enter the number of queries: ");
        int q = sc.nextInt();
        System.out.println("Enter the query elements: ");
        for(int i=0; i<q; i++) {
            System.out.println("Enter the " + (i+1) + "th element : ");
            int val = sc.nextInt();
            if(freq[val-1] > 0) {
                System.out.println(val + " EXISTS IN THE ARRAY");
            } else {
                System.out.println(val + " DOESNOT EXISTS IN THE ARRAY");
            }
        }
    }
}
