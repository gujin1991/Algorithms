import java.util.*;
public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String[] lens = input.nextLine().split(" ");               
        String s1 = input.nextLine();
        String s2 = input.nextLine();
		System.out.println(longestLength(s1, s2));
	}
	
	public static String longestLength(String s1, String s2) {
		
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 == 0 || len2 == 0)
			return "";
		int[][] C = new int[len1 + 1][len2 + 1];
		int[][] flag = new int[len1 + 1][len2 + 1];
		
		for(int i = 1; i < C.length; i++) {
			for(int j = 1; j < C[0].length; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					C[i][j] = C[i - 1][j - 1] + 1;
					flag[i][j] = 2; //left up
				} else if(C[i - 1][j] > C[i][j - 1]){
					C[i][j] = C[i - 1][j]; //up
					flag[i][j] = 1;
				} else {
					C[i][j] = C[i][j - 1];
					flag[i][j] = 3; //left
				}
			}
		}
		
		return subSequence(len1, len2, flag, s1);
		
	}

	private static String subSequence(int len1, int len2, int[][] flag, String s1) {
		// TODO Auto-generated method stub
		String result ="";
			
		while(len1 > 0 && len2 > 0) {
			if(flag[len1][len2] == 3) {
				len2--;
			} else if(flag[len1][len2] == 1) {
				len1--;
			} else {
				len1--;
				len2--;
				result = s1.charAt(len1) + " " + result;;

			}
		}
		
		return result.substring(0,result.length() - 1);
	}
	
	

}
