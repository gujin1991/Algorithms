package August14th;
import java.util.*;

public class PrintMatches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//print(10);
		char[] chars = "abaxx".toCharArray();
		char c = 0;
		for(char cr : chars) {
			c ^= cr;
		}
		
		System.out.println(c);
		
	}
	
	public static void print(int n) {
		if(n <= 1 || n %  2 != 0) return;
		
		int[] teams = new int[n];
		for(int i = 0; i < n; i++) {
			teams[i] = i + 1;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n / 2; j++) {
				System.out.print(teams[j] + " vs " + teams[n - 1 - j] + "   ");
			}
			
			int temp = teams[n - 1];
			for(int j = n - 1; j > 1; j--) {
				teams[j] = teams[j - 1];
			}
			teams[1] = temp;
			System.out.println();
		}
		
		
				
		
	}

}
