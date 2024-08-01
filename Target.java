import java.util.Scanner;
import java.util.Arrays;

public class Target {
    //return the first value that is repeating in the array
    static int firstRepeatingValueOf(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }


    //find the second largest element in a array
    static int secondLargestOf(int arr[]) {
        // Arrays.sort(arr);
        // return arr[arr.length-2];

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest != Integer.MIN_VALUE ? secondLargest : -1;

    }

    //find the unique number where all the number being repeated twice and with one number being unique;
    static int findUnique(int arr[]) {
        boolean hasPair = false;
        for(int i=0; i<arr.length-1; i++) {
            hasPair = false;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    hasPair = true;
                }
            }
            if(hasPair == false) {
                return arr[i];
            }
        }
        return -1;
    }

    //count the number of triplets whose sum is equal to the target
    static int tripletCount(int arr[], int target) {
        int count = 0;
        for(int i=0; i<arr.length-2; i++) {
            for(int j=i+1; j<arr.length-1; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    if(arr[i] + arr[j] + arr[k] == target) {
                        count++;
                    }
                }
            }
        }
        return count != 0 ? count : -1;
    }

    //return the indicies of the pair whose sum is equal to the target
    static int[] pairSum(int arr[], int target) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    static void changeValue(int a) {
        a *= 100;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array values:  ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the target: ");
        int target = sc.nextInt();

        int pairSum[] = pairSum(arr, target);
        System.out.println("Pair indices: " + Arrays.toString(pairSum));

        int tripletCount = tripletCount(arr, target);
        System.out.println("Triplet count: " + tripletCount);

        int uniqueValue = findUnique(arr);
        System.out.println("Unique value: " + uniqueValue);

        int secondLargest = secondLargestOf(arr);
        System.out.println("Seconde largest element: " + secondLargest);

        int firstRepeatingValue = firstRepeatingValueOf(arr);
        System.out.println("First repeating value if the array:         " + firstRepeatingValue);
    }
}