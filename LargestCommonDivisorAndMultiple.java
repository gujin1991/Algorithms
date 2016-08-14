package August13th;

public class LargestCommonDivisorAndMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int LCD(int m, int n) {
		if(m < n) {
			m ^= n;
			n ^= m;
			m ^= n;
		}
		
		while(m % n != 0) {
			int temp = m % n;
			m = n;
			n = temp;
		}
		
		return n;
	}
	
	public int SCM(int m, int n) {
		return (m * n) / LCD(m, n);
	}
}
