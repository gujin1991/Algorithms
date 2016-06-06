
public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if(len <= 2) return false;
        
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;
        
        for(int num : nums) {
            if(num <= first) {
                first = num;
            } else if(num <= second) {
                second = num;
            } else {
                third = num;
            }
        }
        
        return third != Integer.MAX_VALUE;
    }

}
