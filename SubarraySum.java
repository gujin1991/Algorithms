package July20th;
import java.util.*;

public class SubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        ArrayList<Integer> idx = new ArrayList<>();
        
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += nums[i];
            
            if(map.containsKey(sum)) {
                idx.add(map.get(sum) + 1);
                idx.add(i);
                return idx;
            }
            
            map.put(sum, i);
            
        }
        
        return idx;
        
    }

}
