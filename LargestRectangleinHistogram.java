package July21th;
import java.util.*;

public class LargestRectangleinHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int max = 0;
        int start = 0;
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= len; i++) {
            int cur = (len == i) ? -1 : heights[i];
            while(!stack.isEmpty() && cur <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                //System.out.println(h * w);
                max = Math.max(max, h * w);
            }
            
            stack.push(i);
        }
        
        return max;
    }
	
}
