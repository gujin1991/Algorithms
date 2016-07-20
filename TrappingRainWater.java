package July19th;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int trap(int[] height) {
        int len = height.length;
        int start = 0;
        int prev = start;
        int end = len - 1;
        if(len == 0) return 0;
        int water = 0;
        
        while(start < len - 1 && height[start] <= height[start + 1]) {
            start++;
        }
        
        while(end >= 1 && height[end] <= height[end - 1]) {
            end--;
        }
        
        //System.out.println(height[start]);
        //System.out.println(height[end])
        while(start < end) {
            if(height[start] <= height[end]) {
                int cur = start + 1;
                while(cur < end && height[start] >= height[cur]) {
                    water -= height[cur++];
                }
                
                water += (cur - start - 1) * Math.min(height[cur], height[start]);
                //System.out.println(water);
                start = cur;
            } else {
                int cur = end - 1;
                while(cur > start && height[end] >= height[cur]) {
                    water -= height[cur--];
                }
                
                water += (end - cur - 1) * Math.min(height[cur], height[end]);
                //System.out.println(water);
                end = cur;
            }
        }
        
        return water;
    }
}
