
public class AndroidUnlockPatterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean[] visited;
    int[][] jumps;
    
    public int numberOfPatterns(int m, int n) {
        visited = new boolean[10];
        jumps = new int[10][10];
        int count = 0;
        
        jumps[1][3] = jumps[3][1] = 2;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = jumps[4][6] = jumps[6][4] = jumps[2][8] = jumps[8][2] = 5;
        

        
        count += backtracking(1, 1, 0, m, n) * 4;
        count += backtracking(2, 1, 0, m, n) * 4;
        count += backtracking(5, 1, 0, m, n);
        
        return count;
    }
    
     
    
    private int backtracking(int start, int len, int count, int m, int n) {
        if(len >= m) count++;
        len++;
        if(len > n) return count;
        
        visited[start] = true;
        for(int next = 1; next <= 9; next++) {
            int jump = jumps[start][next];
            if(!visited[next] && (jump == 0 || visited[jump])) {
                count = backtracking(next, len, count, m, n);
            }
        }
        visited[start] = false;
        
        return count;
    }

}
