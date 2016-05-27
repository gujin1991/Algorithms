
public class Mirrors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Point p = new Point(1, 2);
	}
	
	int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
	
	public Point findOutputPoints(Point input, int dir, char[][] board) {
		dir = update(dir, input, board);
		
		input.x += dirs[dir][0];
		input.y += dirs[dir][1];
		
		if(input.x < 0 || input.x >= board.length || input.y < 0 || input.y >= board[0].length)
			return input;
		else {
			return findOutputPoints(input, dir, board);
		}
	}
	
	
	
	private int update(int dir, Point input, char[][] board) {
		// TODO Auto-generated method stub
		if((dir % 2 == 0 && board[input.x][input.y] == '\\') && 
				(dir % 2 != 0 && board[input.x][input.y] == '/'))
			dir = (dir + 1) % 4;
		else
			dir = (dir + 3) % 4;
		return dir;
	}



	private class Point {
		int x;
		int y;
		
		public Point() {
			this.x = 0;
			this.y = 0;
		}
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		
	}

}
