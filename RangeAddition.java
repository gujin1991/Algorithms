package August15th;

public class RangeAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        int row = updates.length;
        if(row == 0) return arr;
        
        for(int i = 0; i < row; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            
            arr[start] += val;
            if(end < length - 1) {
                arr[end + 1] -= val;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += arr[i];
            arr[i] = sum;
        }
        
        return arr;
    }

}
