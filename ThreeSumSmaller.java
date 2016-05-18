import java.util.Arrays;

public class ThreeSumSmaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        int cnt = 0;
        
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            

            while(left < right) {
                int newT = target - (nums[i] + nums[left]);
                if(nums[right] >= newT) {
                    right--;
                } else {
                    cnt += right - left;
                    left++;
                }
            }
        }
        
        return cnt;
    }

}
