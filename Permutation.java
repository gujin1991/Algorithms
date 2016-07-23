package July22th;
import java.util.*;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> coms = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        Stack<Integer> stack = new Stack<>();
        List<Integer> prefix = new ArrayList<>();
        stack.push(-1);

        boolean down = true;
        
        while(!stack.isEmpty()) {
            if(stack.peek() == -1) stack.pop();
            if(down) {
                for(int i = 0; i < len; i++) {
                    if(!visited[i]) {
                        visited[i] = true;
                        prefix.add(nums[i]);
                        stack.push(i);
                        
                        if(prefix.size() == len) {
                            coms.add(new ArrayList<>(prefix));
                            down = false;
                        }
                        
                        break;
                    }
                }
            } else {
                int idx = stack.pop();
                visited[idx] = false;
                prefix.remove(prefix.size() - 1);
                for(int i = 0; i < len; i++) {
                    if(!visited[i] && i > idx) {
                        down = true;
                        stack.push(i);
                        visited[i] = true;
                        prefix.add(nums[i]);
                        break;
                    }
                }
            }
        }
        
        
        
        return coms;
    }

}
