
public class PalindromeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPalindrome(1254));
	}
	
	public static int getPalindrome(int num) {
		int count = (num + "").length();
		
		int prefix = num / (int)Math.pow(10, (count+1) / 2); 
		int result = num / (int)Math.pow(10, count / 2);
		int rev = 0;
		while (prefix > 0) {
		        result *= 10;
		        rev = rev * 10 + prefix % 10;
		        prefix /= 10;
		}
		 
		System.out.println(result);
		System.out.println(rev);

		return result + rev;	
	}

}
