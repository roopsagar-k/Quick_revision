import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
public class Test {
    //Get the query parameters from the given url
    static String getQueryParams(String url, String inputKey) {
        StringBuilder sb = new StringBuilder(url.substring(url.indexOf("?") + 1));
        String str[] = sb.toString().split("&");
        
        for(int i=0; i<str.length; i++) {
            String key = str[i].split("=")[0];
            if(key.equals(inputKey)) {
                return str[i].split("=")[1];
            }
        }
        return null;
    }

    //get total of all the posibble unique combiantions of the pieces that sumup to k
    static int combiantions(ArrayList<Integer> list, int idx, int k, int sum) {
        if(idx == list.size()) {
            if(sum == k) {
                return 1;
            } else {
                return 0;
            }
        }

        int currNumber = list.get(idx);
        int countWithCurr = combiantions(list, idx+1, k, sum+currNumber);
        int countWithoutCurr = combiantions(list, idx+1, k, sum);
        return countWithCurr + countWithoutCurr;
    }

    //helper function
    static boolean checkIsDigit(String numbers) {
        boolean isDigits = true;
        for(int i=0; i<numbers.length(); i++) {
            if(!Character.isDigit(numbers.charAt(i))) {
                isDigits = false;
            }
        }

        return isDigits;
    }

    //Check wether the phone number is valid or not
    //{"+91", "0", "7", "8", "9"};
    static boolean isValid(String phone) {
        if(phone.contains(" ")) {
            String[] format = phone.split(" ");
            char firstChar = format[1].charAt(0);
            if(format.length == 3 && format[0].equals("+91") && format[1].length() == 5 && format[2].length() == 5 && (firstChar == '7' || firstChar == '8' || firstChar == '9')) {
               return checkIsDigit(format[1]) && checkIsDigit(format[2]);
            }
            if(format.length == 2 && format[0].charAt(0) == '0' && (firstChar == '7' || firstChar == '8' || firstChar == '9') && format[0].substring(1).length() == 5 && format[1].length() == 5) {
                return checkIsDigit(format[0].substring(1)) && checkIsDigit(format[1]);
            }
            return false;
        } else {
            if(phone.length() > 10) {
                boolean isValid = checkIsDigit(phone.substring(phone.length()-10));
                char firstChar = phone.substring(phone.length()-10).charAt(0);
                String code = phone.substring(0, phone.length()-10);
                System.out.println("code = " + code + " number = " + (phone.substring(phone.length()-10)) + " isDigits = " + isValid);
                if(isValid && (code.equals("+91") || code.equals("0")) && (firstChar == '7' || firstChar == '8' || firstChar == '9') ) {
                    return true;
                }
            } else if(phone.length() == 10) {
                boolean isValid = checkIsDigit(phone);
                char firstChar = phone.charAt(0);
                if(isValid && (firstChar == '7' || firstChar == '8' || firstChar == '9')) {
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the url : ");
        // String url = sc.next();
        // System.out.println("Enter the number of queries : ");
        // int n = sc.nextInt();
        // String inputKeys[] = new String[n];
        // System.out.println("Enter the keys : ");
        // for(int i=0; i<n; i++) {
        //     inputKeys[i] = sc.next();
        // }

        // System.out.println("Values : ");
        // for(int i=0; i<n; i++) {
        //     String val = getQueryParams(url, inputKeys[i]);
        //     if(val == null) {
        //         System.out.print(-1 + " ");
        //     } else {
        //         System.out.print(val + " ");
        //     }
        // }

    //     int totalCombinations = combiantions(new ArrayList<Integer>(Arrays.asList(10, 1, 2, 7, 6, 1, 5)), 0, 8, 0);
    //     System.out.println("totalCombinations = " + totalCombinations);


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of phone number you have : ");
        int n  = sc.nextInt();
        sc.nextLine();
        String phoneNumbers[] = new String[n];
        System.out.println("Enter the phone numbers : ");
        for(int i=0; i<n; i++) {
            phoneNumbers[i] = sc.nextLine();
        }

        for(int i=0; i<n; i++) {
            if(isValid(phoneNumbers[i])) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }

        
    }
}