import java.util.*;
public class FindMaxGoal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{2,1,6}, {9,5,7}, {3,4,8}};
		int[] goals = {1, 4};
		System.out.println(findMax(board, goals));
	}
	
	public static int findMax(int[][] board, int[] goals) {
		int maxNum = Integer.MIN_VALUE;
		int row = board.length;
		int col = board[0].length;
		int goalNum = goals.length;
		int[][] record = new int[row][col];
		Set<Integer> set = new HashSet<>();
		
		for(int goal : goals) {
			set.add(goal);
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(set.contains(board[i][j])) {
					boolean[][] visited = new boolean[row][col];
					DFS(i, j, board, record, visited);
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(record[i][j] == goalNum) {
					maxNum = Math.max(maxNum, board[i][j]);
				}
			}
		}
		
		return maxNum;
	}
	
	private static void DFS(int ridx, int cidx, int[][] board, int[][] record, boolean[][] visited)
	{
		int row = board.length;
		int col = board[0].length;
		if(visited[ridx][cidx]) {
			return;
		}
		
		record[ridx][cidx]++;
		visited[ridx][cidx] = true;
		if(ridx - 1 >= 0 && board[ridx][cidx] <= board[ridx - 1][cidx]) {
			DFS(ridx - 1, cidx, board, record, visited);
		}
		if(ridx + 1 < row && board[ridx][cidx] <= board[ridx + 1][cidx]) {
			DFS(ridx + 1, cidx, board, record, visited);
		}

		if(cidx - 1 >= 0 && board[ridx][cidx] <= board[ridx][cidx - 1]) {
			DFS(ridx, cidx - 1, board, record, visited);
		}

		if(cidx + 1 < col && board[ridx][cidx] <= board[ridx][cidx + 1]) {
			DFS(ridx, cidx + 1, board, record, visited);
		}

		
		
	}
}
