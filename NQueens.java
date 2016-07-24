package July22th;
import java.util.*;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        //boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        boolean[] dig = new boolean[2 * n];
        boolean[] rdig = new boolean[2 * n];
        
        findSol(0, col, dig, rdig, new ArrayList<String>(), solutions);
        
        return solutions;
    }
    
    private void findSol(int row, boolean[] col, boolean[] dig, boolean[] rdig, List<String> prefix, List<List<String>> solutions) {
        int n = col.length;
        if(row == n) {
            solutions.add(new ArrayList<String>(prefix));
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!col[i] && !dig[row + i] && !rdig[row - i + n]) {
                prefix.add(getQueens(i, n));
                col[i] = true;
                dig[i + row] = true;
                rdig[row - i + n] = true;
                findSol(row + 1, col, dig, rdig, prefix, solutions);
                col[i] = false;
                dig[i + row] = false;
                rdig[row - i + n] = false;
                prefix.remove(prefix.size() - 1);
            }
        }
    }
    
    private String getQueens(int idx, int n) {
        String queen = "";
        for(int i = 0; i < n; i++) {
            if(idx == i)
                queen += "Q";
            else
                queen += ".";
        }
        return queen;
    }

}
