package July27th;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isNumber(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0) return false;
        
        boolean hasFirst, hasDot, hasDigit, hasE;
        hasE = hasFirst = hasDot = hasDigit = false;
        
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                hasFirst = hasDigit = true;
                continue;
            }
            
            switch(c) {
                case 'e':
                    if(hasE || !hasDigit) return false;
                    
                    hasE = true;
                    hasDot = true;
                    hasFirst = false;
                    hasDigit = false;
                    break;
                case '+':
                    if(hasFirst) return false;
                    break;
                case '-':
                    if(hasFirst) return false;
                    hasFirst = true;
                    
                    break;
                case '.':
                    if(hasDot) {
                        return false;
                    }
                    
                    hasDot = true;
                    hasFirst = true;
                    
                    break;
                default:
                    return false;
            }
            
            
        }
        System.out.println("last");

        return hasDigit;
    }

}
