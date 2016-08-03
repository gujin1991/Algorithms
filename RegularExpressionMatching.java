package August2nd;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        
        int slen = s.length();
        int plen = p.length();
        int sstart = 0;
        int pstart = 0;
        
        while(pstart < plen) {
            if(pstart == plen - 1 || p.charAt(pstart + 1) != '*') {
                if(sstart == slen || (p.charAt(pstart) != '.' && p.charAt(pstart) != s.charAt(sstart))) {
                    return false;
                } else {
                    pstart++;
                    sstart++;
                }
            } else {
                while(sstart < slen && (p.charAt(pstart) == '.' || p.charAt(pstart) == s.charAt(sstart))) {
                    if(isMatch(s.substring(sstart), p.substring(pstart + 2))) {
                        return true;    
                    }
                    sstart++;
                }   
                
                pstart += 2;
            }
        }
        
        return sstart == slen;
    }
}
