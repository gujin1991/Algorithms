package August23th;

public class BombEnemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxKilledEnemies(char[][] grid) {
        int row = grid.length;
        int max = 0;
        if(row == 0) return max;
        int col = grid[0].length;
        
        int[] cval = new int[col];
        
        for(int i = 0; i < row; i++) {
            int rval = 0;
            for(int j = 0; j < col; j++) {
                if(j == 0 || grid[i][j - 1] == 'W') {
                    rval = 0;
                    for(int k = j; k < col && grid[i][k] != 'W'; k++) {
                        if(grid[i][k] == 'E') rval++;
                    }
                    
                }
                
                if(i == 0 || grid[i - 1][j] == 'W') {
                    cval[j] = 0;
                    for(int k = i; k < row && grid[k][j] != 'W'; k++) {
                        if(grid[k][j] == 'E') cval[j]++;
                    }
                }
                
                if(grid[i][j] == '0') {
                    max = Math.max(max, rval + cval[j]);
                }
            }
        }
        
        return max;
    }
}
