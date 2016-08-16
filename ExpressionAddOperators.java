package August15th;
import java.util.*;

public class ExpressionAddOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> addOperators(String num, int target) {
        List<String> express = new ArrayList<>();
        
        findExpre(num, target, "", 0, 0, 0, express);
        
        return express;
    }
    
    private void findExpre(String num, int target, String prefix, int pos, long res, long last, List<String> express) {
        int len = num.length();
        if(pos == len) {
            if(res == target) {
                express.add(prefix);
            }
            return;
        }
        
        for(int i = pos + 1; i <= len; i++) {
            if(num.charAt(pos) == '0' && i != pos + 1) break;
            
            long cur = Long.parseLong(num.substring(pos, i));
            if(pos == 0) {
                findExpre(num, target, prefix + cur, i, res + cur, cur, express);   
            } else {
                findExpre(num, target, prefix + "+" + cur, i, res + cur, cur, express);
                findExpre(num, target, prefix + "-" + cur, i, res - cur, -cur, express);
                findExpre(num, target, prefix + "*" + cur, i, res - last + last * cur, last * cur, express);
            }
        }
    }

}
