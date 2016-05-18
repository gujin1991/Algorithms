
public class StrobogrammaticNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isStrobogrammatic(String num) {
        if(num.length() == 0 || num.charAt(0) == '-') {
            return false;
        }    
        
        int len = num.length();
        int[] rotate = new int[10];
        String rotateStr = "";;
        
        for(int i = 1; i < 10; i++) {
            rotate[i] = -1;    
        }
        rotate[1] = 1;
        rotate[6] = 9;
        rotate[8] = 8;
        rotate[9] = 6;
        
        for(int i = 0; i < len; i++) {
            int val = num.charAt(i) - '0';
            if(rotate[val] == -1) {
                return false;
            }
            
            rotateStr = rotate[val] + rotateStr;
        }
        
        return num.equals(rotateStr);
        
    }

}
