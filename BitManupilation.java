public class BitManupilation {
    //  0, 1, 10, 11, 100, 101, 110, 111, 1000, 1001, and 1010.
    static boolean isPowerOf2(int n) {
        if((n&1) == 0) {
            return true;
        }

        return false;
    }

    static int toggleBitAt(int pos, int n) {
        int bitMask = 1 << pos;

        if((bitMask & n) == 0) {
            return  bitMask | n;
        }

        return (~bitMask & n);
    }

    static int countOf1s(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    static int decimal2Binary(int n) {
        StringBuilder sb = new StringBuilder("");

        while(n > 0) {
            sb.append((n&1) == 0 ? '0' : '1');
            n = n >> 1;
        }

        return Integer.parseInt(sb.reverse().toString());
    }


    public static void main(String[] args) {
        int n = 5; //101
        int pos = 2;

        int result = toggleBitAt(pos, n);
        System.out.println("result : " + result);

        int total1s = countOf1s(n);
        System.out.println("Total 1s : " + total1s);

        int binaryVal = decimal2Binary(n);
        System.out.println("Binary value  : " + binaryVal);

        int decimalVal = binary2Decimal(binaryVal);
        System.out.println("Decimal value : " + decimalVal);
    }
}
