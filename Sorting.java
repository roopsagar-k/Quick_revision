import java.util.Arrays;

public class Sorting {

    //bubble sort
    static void bubbleSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    //selection sort
    static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            int smallest = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];   
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    //insertion sort
   static void insertionSort(int arr[]) {
    for(int i=1; i<arr.length; i++) {
        int j = i-1;
        int current = arr[i];

        while( j >= 0 && current < arr[j]) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = current;
    }

    System.out.println(Arrays.toString(arr));
   }

    public static void main(String[] args) {
        int arr[] = {5, 3, 4, 2, 1};

        insertionSort(arr);

    }
}
