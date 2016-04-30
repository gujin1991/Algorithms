import java.util.*;
public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMP test = new KMP();
		Scanner input = new Scanner(System.in);
		String T = input.nextLine();
		String P = input.nextLine();
		System.out.println(test.kmp(T, P));
	}
	
	public void getNext(String P, int[] next) {
		next[0] = 0;
		for(int i = 1, k = 0; i < P.length(); i++) {
			while(k > 0 && P.charAt(i) != P.charAt(k)) {
				k = next[k - 1];
			}
			
			if(P.charAt(i) == P.charAt(k)) {
				k++;
			}
			
			next[i] = k;
		}
	}
	
	public String kmp(String T, String P) {
		if(T == null || T.length() == 0 || P == null || P.length() == 0) {
			return "Wrong input";
		}
		
		int tLen = T.length();
		int pLen = P.length();
		int[] next = new int[pLen];
		getNext(P, next);
		
		for(int tidx = 0, pidx = 0; tidx < tLen; tidx++) {
			while(pidx > 0 && T.charAt(tidx) != P.charAt(pidx)) {
				pidx = next[pidx - 1];
			}
			
			if(T.charAt(tidx) == P.charAt(pidx)) {
				pidx++;
			}
			if(pidx == pLen) {
				return "The index is :" + (tidx - pLen + 1);
			}
			
		}
		
		return "No result found.";
	}

}
