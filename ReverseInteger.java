package August1st;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        int sign = 0;
        if(x < 0) {
            sign = 1;
            x = -x;
        }
        
        long reverseNum = 0;
        while(x > 0) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        
        if(reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)(sign == 0 ? reverseNum : -reverseNum);
        }
    }

}
