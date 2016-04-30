import java.util.*;
public class 字符串相似度 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please input two strings.");
		String str1 = input.nextLine();
		String str2 = input.nextLine();
		
		System.out.println("The Distance between str1 and str2 is: " + LD(str1, str2));
	}

	private static int LD(String str1, String str2) {
		// TODO Auto-generated method stub
		
		if(str1 == null || str1.length() == 0)
			return str2 == null ? null : str2.length();
		
		if(str2 == null || str2.length() == 0)
			return str1 == null ? null : str1.length();
		
		
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] matrix = new int[len1 + 1][len2 + 1];
		
		for(int i = 0; i <= len1; i++) {
			matrix[i][0] = i;
		}
		for(int i = 0; i <= len2; i++) {
			matrix[0][i] = i;
		}
		
		for(int i = 1; i<= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(str1.charAt(i- 1) == str2.charAt(j - 1))
					matrix[i][j] = matrix[i - 1][j - 1];
				else
					matrix[i][j] = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + 1;
			}
		}
		return matrix[len1][len2];
	}

}
