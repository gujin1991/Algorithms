package August2nd;

public class DungeonGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        
        int[][] health = new int[row][col];
        
        health[row - 1][col - 1] = 1 + (dungeon[row - 1][col - 1] > 0 ? 0 : -dungeon[row - 1][col - 1]);
        for(int i = row - 2; i >= 0; i--) {
            health[i][col - 1] = Math.max(health[i + 1][col - 1] - dungeon[i][col - 1], 1);
                            //System.out.println(health[i][col - 1]);

        }
        
        for(int j = col - 2; j >= 0; j--) {
            health[row - 1][j] = Math.max(health[row - 1][j + 1] - dungeon[row - 1][j], 1);
        }
        
        for(int i = row - 2; i >= 0; i--) {
            for(int j = col - 2; j >= 0; j--) {
                int left = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                
                health[i][j] = Math.min(left, down);
                //System.out.println(health[i][j]);
            }
        }
        
        
        return Math.max(1, health[0][0]);
    }

}
