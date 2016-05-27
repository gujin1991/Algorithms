
public class GameOfLive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void gameOfLife(int[][] board) {
        int row = board.length;
        if(row == 0) {
            return;
        }
        int col = board[0].length;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int liveNum = countLives(i, j, board);
                if(board[i][j] == 1) {
                    if(liveNum == 2 || liveNum == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if(liveNum == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int countLives(int ridx, int cidx, int[][] board) {
        int cnt = 0;
        int rstart = Math.max(0, ridx - 1);
        int rend = Math.min(board.length - 1, ridx + 1);
        int cstart = Math.max(0, cidx - 1);
        int cend = Math.min(board[0].length - 1, cidx + 1);
        
        for(int i = rstart; i <= rend; i++) {
            for(int j = cstart; j <= cend; j++) {
                if(i == ridx && j == cidx) continue;
                cnt += (board[i][j] & 1);
            }
        }
        
        return cnt;
    }

}
