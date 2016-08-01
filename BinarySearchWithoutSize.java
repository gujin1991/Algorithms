package July31th;

public class BinarySearchWithoutSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 3, 5, 7, 9, 11, 13, 15};
		System.out.println("binfind(a, -1) should be -1: " + (binfind(a, -1) == -1));
		System.out.println("binfind(a, 1) should be 0: " + (binfind(a, 1) == 0));
		System.out.println("binfind(a, 8) should be -1: " + (binfind(a, 8) == -1));
		System.out.println("binfind(a, 11) should be 5: " + (binfind(a, 11) == 5 ));
		System.out.println("binfind(a, 15) should be 7: " + (binfind(a, 15) == 7));
		System.out.println("binfind(a, 16) should be -1: " + (binfind(a, 16) == -1));

	}
	
	
	private static int binfind(int[] arr, int target) {
		int lo = 0;
		int hi = 0;
		
		while(true) {
			try {
				if(arr[hi] == target) {
					return hi;
				} else if(arr[hi] > target) {
					if(hi == 0) return -1;
					if(lo == hi - 1) return -1;
					hi = lo + (hi - lo) / 2;
				} else {
					lo = hi;
					hi = (hi + 1) * 2;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				if(hi == 0) return -1;
				if(lo != 0 && hi == lo - 1) return -1;
				hi = lo + (hi - lo) / 2;				
			}
		}
	}
}
