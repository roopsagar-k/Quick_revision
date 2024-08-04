import java.util.LinkedHashSet;

public class Recursion {

    static void printSumOfN(int i, int n, int sum) {
        if(i == n) {
            sum += i;
            System.out.println(sum);
            return;
        }

        sum += i;
        printSumOfN(i+1, n, sum);
    }

    static void printNumbers(int n) {
        if(n == 0) {
            return;
        }
        printNumbers(n-1);
        System.out.println(n);                 
    }

    static int factorial(int n) {
        if(n == 1) {
            return 1;
        }

        return n * factorial(n-1);
    }

    static void fibo(int a, int b, int n) {
        if(n == 0) {
            return;
        }
       int c = a+b;
       n -= 1;
       System.out.println(a);
       fibo(b, c, n);
    }

    static int xPower(int x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * xPower(x, n-1);
    }

    //Intermediate questions

    static void towerOfHanoi(int n, String source, String helper, String dest) {
        if(n == 1) {
            System.out.println("Transfer disk " + n + " from " + source + " to " + dest);
            return;

        }
        towerOfHanoi(n-1, source, dest, helper);
        System.out.println("Transfer disk " + n + " from " + source + " to " + dest);
        towerOfHanoi(n-1, helper, source, dest);
    }

    //print a string in reverse
    static void StringReverse(String str, int length) {
        if(length == 1) {
            System.out.println(str.charAt(length-1));
            return;
        }
        System.out.print(str.charAt(length-1));
        StringReverse(str, length-1);
    }

    static void Occurences(String str, int length, char c, int f, int l) {
        if(length == 0) {
            return;
        }

        if(str.charAt(length-1) == c) {
            if(l == -1) {
                 System.out.println("Last occurrence of " + c + " is found @ " + (length - 1));
                 l = length-1;
            }
            f = length-1;
        }
        Occurences(str, length-1, c, f, l);

        if(length == 1 && f != -1)
        System.out.println("First occurrence of " + c + " is found @ " + f);
    }

    //check the array is sorted or not
    static void checkSorted(int arr[], int f, int s, boolean isSorted) {
        if(s == arr.length-1) {
            if(isSorted) {
                System.out.println("Array is sorted");
            } else {
                System.out.println("Array is not sorted");
            }
            return;
        }
        if(arr[f] > arr[s]) {
            isSorted = false;
        }
        checkSorted(arr, f+1, s+1, isSorted);
    }


    //Move all the 'x' to the end
    static void moveAllX(StringBuilder str, char x, StringBuilder result, int length, int xCount) {
        if((length) == 0) {
            while(xCount != 0) {
                result.insert(0, x);
                xCount--;   
            }
            System.out.println("Result : " + result.reverse());
            return;
        }

        if(str.charAt(length-1) == x) {
            xCount += 1;
        } else {
            result.append(str.charAt(length-1));
        }
        moveAllX(str, x, result, length-1, xCount);
    }

    //remove duplicate from the string
    static void removeDuplicate(StringBuilder sb, int indx, int mapArray[], StringBuilder result) {
        if(indx == sb.length()) {
            System.out.println("After removing duplicates : " + result.toString());
            return;
        }
        int charIndex = sb.charAt(indx) - 'a';
        if(mapArray[charIndex] == 0) {
            mapArray[charIndex] = 1;
            result.append(sb.charAt(indx));
        }
        removeDuplicate(sb, indx+1, mapArray, result);
    }

    //print all the subsequences of the string
    static void printSubsequences(String str, int idx, String newString) {
        if(idx == str.length()) {
            System.out.println(newString);
            return;
        }   
        char currChar = str.charAt(idx);
        printSubsequences(str, idx+1, newString + currChar);
        printSubsequences(str, idx+1, newString);
    }

    //print all the unique subsequences
    static void printUniqueSubsequences(String str, int idx, String newString, LinkedHashSet<String> set) {
        if(idx == str.length()) {
            if(set.contains(newString)){
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currChar = str.charAt(idx);
        printUniqueSubsequences(str, idx+1, newString + currChar, set);
        printUniqueSubsequences(str, idx+1, newString, set);
    }

    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "uv", "wxyz"};
    static void printCombinations(String str, int idx, String combination) {
        char currChar = str.charAt(idx);
        String val = keypad[Integer.parseInt(Character.toString(currChar))];
        
    }

    public static void main(String[] args) {
        String str = "aaa";
        printUniqueSubsequences(str, 0, "", new LinkedHashSet<String>());
    }
}
