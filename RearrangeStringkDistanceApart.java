package August19th;

public class RearrangeStringkDistanceApart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String rearrangeString(String str, int k) {
        int len = str.length();
        int[] count = new int[26];
        int[] validPos = new int[26];
        
        for(char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            int pos = findNext(count, validPos, i);
            if(pos == -1) {
                return "";
            }
            
            count[pos]--;
            validPos[pos] = i + k;
            sb.append((char)('a' + pos));
        }
        
        return sb.toString();
    }
    
    private int findNext(int[] count, int[] valid, int index) {
        int pos = -1;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0 && count[i] > max && valid[i] <= index) {
                max = count[i];
                pos = i;
            }
        }
        
        return pos;
    }

}
