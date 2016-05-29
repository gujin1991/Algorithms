
public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        if(num == 0)    return bits;
        int idx = 2;
        int step = 1;
        
        bits[1] = 1;
        
        while(idx <= num) {
            for(int i = 0; i < step && idx <= num; i++) {
                bits[idx] = bits[idx++ - step];
                
            }
            
            for(int i = 0; i < step && idx <= num; i++) {
                bits[idx] = bits[idx++ - step] + 1;
            }
        
            step *= 2;
        }
        
        return bits;
    }

}
