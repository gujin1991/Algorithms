
public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean isMatch(String s, String p) {
        int ssize = s.length();
        int psize = p.length();
        int sidx = 0;
        int pidx = 0;
        int mark = -1;
        int start = -1;
        
        while(sidx < ssize) {
            
            if(pidx < psize && ((p.charAt(pidx) == '?') || s.charAt(sidx) == p.charAt(pidx))) {
                pidx++;
                sidx++;
                //System.out.println(pidx + " " + sidx);
            } else if(pidx < psize && p.charAt(pidx) == '*') {
                start = pidx;
                pidx++;
                mark = sidx;
            } else if(start != -1) {
                pidx = start + 1;
                sidx = ++mark;
            } else {
                return false;
            }
        }
        
        while(pidx < psize && p.charAt(pidx) == '*') {
            pidx++;
        }
        
        return pidx == psize;
    }
}
