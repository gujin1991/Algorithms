package August8th;

public class ReadNCharactersGivenRead4II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int buffCnt = 0;
    private int buffPtr = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int cnt = 0;
        while(cnt < n) {
            if(buffPtr == 0)
                buffCnt = read4(buff);
            if(buffCnt == 0) break;
            while(cnt < n && buffPtr < buffCnt) {
                buf[cnt++] = buff[buffPtr++];
            }
            
            if(buffPtr >= buffCnt) buffPtr = 0;
        }
        
        
        return cnt;
    }
    
    private int read4(char[] buff) {
    	return 4;
    }

}
