
public class SelfCrossing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSelfCrossing(int[] x) {
        int len = x.length;
        if(len <= 3) return false;
        
        for(int i = 3; i < len; i++) {
            if(x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
            if(i >= 4) {
                if(x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) return true;
            }
            if(i >= 5) {
                boolean temp = true;
                temp = temp && (x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2]);
                temp = temp && (x[i - 3] >= x[i - 1] && x[i - 1] + x[i - 5] >= x[i - 3]);
                if(temp)    return true;    
            } 
        }
        
        return false;
        
        
        
    }

}
