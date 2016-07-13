package July12th;
import java.util.*;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> coms = new ArrayList<>();
        findComs(nums, 0, new ArrayList<Integer>(), coms);
        
        return coms;
        
    }
    
    private void findComs(int[] nums, int pos, List<Integer> prefix, List<List<Integer>> coms) {
        coms.add(new ArrayList<Integer>(prefix));
        
        for (int i = pos; i < nums.length; i++) {
            if (i == pos || nums[i] != nums[i - 1]) {
               prefix.add(nums[i]);
               findComs(nums, i + 1, prefix, coms);
               prefix.remove(prefix.size() - 1);
            }
        }
    }

}
