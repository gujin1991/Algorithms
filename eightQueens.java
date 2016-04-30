import java.util.*;
public class eightQueens {
	final int queenNum = 8;
	int[] col = new int[queenNum + 1];
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eightQueens test = new eightQueens();
		test.backtrackingIter();
		System.out.println(count);
	}
	
	public boolean place(int k) {
		for(int i = 1; i < k; i++) {
			if(Math.abs(i - k) == Math.abs(col[i] - col[k]) || col[i] == col[k])
				return false;
		}
		
		return true;
	}

	public void backtracking(int k) {
		if(k > queenNum) {
			for(int i = 1; i <= queenNum; i++) {
				System.out.print(col[i]);
				
			}
			count++;
			System.out.println();
		} else {
			for(int i = 1; i <= queenNum; i++) {
				col[k] = i;
				if(place(k))
					backtracking(k + 1);
			}
		}
	}
	
	public void  backtrackingIter() {
		int t = 1;
		while(t >= 1) {
			col[t] = col[t] + 1;
			while(col[t] <= queenNum && !place(t)) {
				col[t] += 1;
			}
			
			if(t == queenNum && col[t] <= queenNum) {
				for(int i = 1; i <= queenNum; i++) {
					System.out.print(col[i]);
					
				}
				count++;
				System.out.println();
			} else if(t < queenNum && col[t] <= queenNum) {
				t = t + 1;
			} else {
				col[t] = 0;
				t = t - 1;
				
			}
		}
	}
}
