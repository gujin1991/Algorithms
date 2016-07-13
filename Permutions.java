package July12th;
import java.util.*;

public class Permutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> coms = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        
        findComs(nums, new ArrayList<Integer>(), visited, coms);
        
        return coms;
    }
    
    private void findComs(int[] nums, List<Integer> prefix, boolean[] visited, List<List<Integer>> coms) {
        if(prefix.size() == nums.length) {
            coms.add(new ArrayList<Integer>(prefix));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                prefix.add(nums[i]);
                visited[i] = true;
                findComs(nums, prefix, visited, coms);
                visited[i] = false;
                prefix.remove(prefix.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> coms = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        findComs(nums, visited, new ArrayList<Integer>(), coms);
        
        return coms;
    }
    
    private void findComs(int[] nums, boolean[] visited, List<Integer> prefix, List<List<Integer>> coms) {
        if(prefix.size() == nums.length) {
            coms.add(new ArrayList<Integer>(prefix));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i] && (i == 0 || (nums[i - 1] != nums[i]) || visited[i - 1])) {
                prefix.add(nums[i]);
                visited[i] = true;
                findComs(nums, visited, prefix, coms);
                visited[i] = false;
                prefix.remove(prefix.size() - 1);
            }
        }
    }

}
