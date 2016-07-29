package Elementum;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        int pstart = -1;
        int sstart = -1;
        int sidx = 0;
        int pidx = 0;
        
        while(sidx < slen) {
            if(pidx < plen && (p.charAt(pidx) == '?' || p.charAt(pidx) == s.charAt(sidx))) {
                pidx++;
                sidx++;
            } else if(pidx < plen && p.charAt(pidx) == '*') {
                pstart = pidx;
                pidx++;
                sstart = sidx;
                //sidx++;
            } else if(pstart != -1) {
                pidx = pstart + 1;
                sidx = ++sstart;    
            } else {
                return false;
            }
            //System.out.println(pidx);
        }
        
        System.out.println(pidx);
        while(pidx < plen && p.charAt(pidx) == '*') {
            pidx++;
        }
        
        return pidx == plen;
        
        
    }

}
