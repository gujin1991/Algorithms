package August18th;
import java.util.*;

public class LineReflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int num = points.length;
        
        for(int i = 0; i < num; i++) {
            max = Math.max(max, points[i][0]);
            min = Math.min(min, points[i][0]);
            set.add(points[i][0] + "a" + points[i][1]);
        }
        
        sum = (max + min);
        for(int[] p : points) {
            if(!set.contains(sum - p[0] + "a" + p[1])) return false;
        }
        
        return true;
        
    }

}
