import java.util.*;
public class StrobogrammaticNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> findStrobogrammatic(int n) {
        //["101","111","181","609","619","689","808","818","888","906","916","986"] 12
        //["1001","1111","1691","1881","1961","6009","6119","6699","6889","6969","8008","8118","8698","8888","8968","9006","9116","9696","9886","9966"] 20
        
        
        return findStrobogrammaticRec(n, n);
    }
    
    private List<String>  findStrobogrammaticRec(int left, int n) {
        //System.out.println(++count);
        if(left == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if(left == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        }
        
        List<String> last = findStrobogrammaticRec(left - 2, n);
        List<String> strNums = new ArrayList<String>();
        for(String str : last) {
            if(left != n) strNums.add(0 + str + 0);
            strNums.add(1 + str + 1);
            strNums.add(6 + str + 9);
            strNums.add(8 + str + 8);
            strNums.add(9 + str + 6);
        }
        
        return strNums;
        
    }

}
