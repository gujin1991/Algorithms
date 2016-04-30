import java.util.Arrays;

public class 猴子吃桃 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int cur = 1;
		for(int i = 2; i <= n; i++) {
			cur = 2 * cur + 2;
		}
		
		int cur2 = (int) (3 * Math.pow(2, n - 1) - 2);
		System.out.println(cur);
		System.out.println(cur2);
	}
	
	
	
	
}
