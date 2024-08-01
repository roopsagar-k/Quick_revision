import java.util.Scanner;

public class Strings {
    static String lengthOfLongestSubstring(String s) {
        String resultString = "";
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            String str = "";
            for(int j=0; j<s.length(); j++) {
                if(str.contains(Character.toString(s.charAt(j)))) {
                    break;
                } else {
                    str += s.charAt(j);
                    if(str.length() > max) {
                        max = str.length();
                        resultString = str;
                    }
                }
            }
        }

        return resultString;
    }


    public static void main(String[] args) {
        // System.out.println(lengthOfLongestSubstring("null"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.next();
        StringBuilder sb = new StringBuilder(str);
        int i=0, j=sb.length()-1;

        while(i <= j) {
            char val1 = sb.charAt(i);
            char val2 = sb.charAt(j);

            sb.setCharAt(i, val2);
            sb.setCharAt(j, val1);
            
            i++;
            j--;
        }

        System.out.println("Reversed String : " + sb);
        
       
    }   
}