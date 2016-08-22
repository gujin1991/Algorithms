package August21th;

public class SortTransformedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int lo = 0;
        int hi = nums.length - 1;
        int[] res = new int[nums.length];
        int index = a >= 0 ? nums.length - 1 : 0;
        while(lo <= hi) {
    
            
            if(a >= 0) {
                if(getRes(nums[lo], a, b, c) <= getRes(nums[hi], a, b, c)) {
                    res[index--] = getRes(nums[hi--], a, b, c);
                    
                } else {
                    res[index--] = getRes(nums[lo++], a, b, c);
                }
            } else {
                if(getRes(nums[lo], a, b, c) <= getRes(nums[hi], a, b, c)) {
                    res[index++] = getRes(nums[lo++], a, b, c);
                    
                } else {
                    res[index++] = getRes(nums[hi--], a, b, c);
                }
            }
        }
        
        
        return res;
    }
    
    private int getRes(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
    

}
