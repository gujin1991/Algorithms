
public class BullsandCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int len = secret.length();
        int[] map = new int[10];       
        for(char c : secret.toCharArray()) {
            int idx = c - '0';
            map[idx]++;
        }
        
        for(int i = 0; i < len; i++) {
            char gc = guess.charAt(i);
            int idx = gc - '0';
            if(gc == secret.charAt(i)) {
                if(map[idx] <= 0) cow--;
                bull++;
                map[idx]--;
            } else {
                if(map[idx] > 0) {
                    cow++;
                    map[idx]--;
                }
            }
        }
        

        
        return bull + "A" + cow + "B";
    }

}
