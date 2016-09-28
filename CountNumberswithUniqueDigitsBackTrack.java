package September28th;

public class CountNumberswithUniqueDigitsBackTrack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int countNumbersWithUniqueDigits(int n) {
        if(n > 10) 
            n = 10;
        
        int count = 1;
        long max = (long)Math.pow(10, n);
        boolean[] visited = new boolean[10];
        
        
        for(int i = 1; i < 10; i++) {
            visited[i] = true;
            count += search(i, max, visited);
            visited[i] = false;
        }
        
        return count;
    }
    
    private int search(long cur, long max, boolean[] visited) {
        if(cur >= max) return 0;
        int count = 1;
        
        for(int i = 0; i < 10; i++) {
            if(!visited[i]) {
                long newNum = cur * 10 + i;
                visited[i] = true;
                count += search(newNum, max, visited);
                visited[i] = false;
            }
        }
        
        return count;
    }
}
