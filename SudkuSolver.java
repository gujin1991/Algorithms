import java.util.*;
public class SudkuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean[][] row;
    boolean[][] col;
    boolean[][] box;
    
    public void solveSudoku(char[][] board) {
        int rlen = board.length;
        int clen = board[0].length;
        int start = -1;
        int prev = -1;
        Map<Integer, Integer> map = new HashMap<>();
        row = new boolean[10][10];
        col = new boolean[10][10];
        box = new boolean[10][10];
        
        //record the next empty cell and mark the original cell visited.
        for(int i = 0; i < rlen; i++) {
            for(int j = 0; j < clen; j++) {
                if(board[i][j] == '.') {
                    int cur = i * clen + j;
                    if(start == -1) {
                        start = cur;
                        prev = start;
                    } else {
                        map.put(prev, cur);
                        prev = cur;
                    }
                } else {
                    int idx = board[i][j] - '0';
                    row[i][idx] = true;
                    col[j][idx] = true;
                    box[i / 3 * 3 + j / 3][idx] = true;
                }
            }
        }
        
        backtracking(start, board, map);
    }
    
    private boolean backtracking(int cur, char[][] board, Map<Integer, Integer> map) {
        int rlen = board.length;
        int clen = board[0].length;
        int ridx = cur / clen;
        int cidx = cur % clen;
        int bidx = ridx / 3 * 3 + cidx / 3;
        //next == -1 means it is the last empty cell.
        int next = map.containsKey(cur) ? map.get(cur) : -1;
        
        for(int i = 1; i <= 9; i++) {
            if(!row[ridx][i] && !col[cidx][i] && !box[bidx][i]) {
                row[ridx][i] = true;
                col[cidx][i] = true;
                box[bidx][i] = true;
                board[ridx][cidx] = (char)(i + '0');
                
                if(backtracking(next, board, map) || next == -1) return true; 
                
                row[ridx][i] = false;
                col[cidx][i] = false;
                box[bidx][i] = false;
                board[ridx][cidx] = '.';
            }
        }
        
        return false;
    }

}
