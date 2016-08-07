package August7th;

public class StringtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int myAtoi(String str) {
        int res = 0;
        int sign = 1;
        int idx = 0;
        str = str.trim();
        int len = str.length();
        if(len <= 0) return 0;
        

            if(str.charAt(0) == '-') {
                sign = -1;
                idx++;
            } else if(str.charAt(0) == '+') {
                idx++;    
            }
            
        
        while(idx < len) {
            if(!Character.isDigit(str.charAt(idx))) break;
            int val = (str.charAt(idx) - '0');
            if(Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < val)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + val;
            idx++;
        }
        
        return res * sign;
        
        
    }

}
