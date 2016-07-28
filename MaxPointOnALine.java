package July27th;
import java.util.*;
import java.awt.Point;

public class MaxPointOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxPoints(Point[] points) {
        int len = points.length;
        if(len <= 2) return len;
        int max = 1;
        
        for(int i = 0; i < len; i++) {
            Point cur = points[i];
            int samex = 1;
            int samep = 0;
            Map<Double, Integer> map = new HashMap<>();
            for(int j = 0; j < len; j++) {
                if(i != j) {
                    if(cur.x == points[j].x && cur.y == points[j].y) {
                        samep++;
                    }
                    
                    if(cur.x == points[j].x) {
                        samex++;
                        continue;
                    }
                
                    double slope = (cur.y - points[j].y) / (double)(cur.x - points[j].x);
                    
                    if(!map.containsKey(slope)) {
                        map.put(slope, 2);
                    } else {
                        map.put(slope, map.get(slope) + 1);    
                    }
                    
                    max = Math.max(max, map.get(slope) + samep);
                }
            }
            
            max = Math.max(max, samex);
        }
        
        return max;
    }

}
