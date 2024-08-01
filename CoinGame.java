public class CoinGame {
    public static String getWinner(int x, int y) {
        int count = 0;
        int val1  = x*75;
        int val2 = y*10;

        while(val1 >= 0 || val2 >= 0) {
            if(val1 % 75 == 0 && val2 % 10 == 0) {
                val1 -= 75;
                if(val2 > 40) {
                    val2 -= 40;
                    count++;
                } else {
                    break;
                }
            }
        }
        System.out.println("count : " + count);
        if(count % 2 == 0) {
            return "Bob";
        } 
        return "Alice";
    }

    public static void main(String[] args) {
        String winner = getWinner(2, 7);
        System.out.println("Winner is : " + winner);
    }
}
