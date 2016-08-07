package August7th;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int mySqrt(int x) {
        int lo = 1;
        int hi = x;
        if(x == 0) return 0;
        
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(x / mid == mid) {
                return mid;
            } else if(x / mid < mid){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return x / lo == lo ? lo : lo - 1;
    
    }

}
