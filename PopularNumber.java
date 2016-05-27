
public class PopularNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,3,3,3,4,4,4};
		findNum(arr);
	}
	
	public static void findNum(int[] arr) {
		int len = arr.length;
		int step = (int)Math.ceil(len / 4);
		System.out.println(step);
		
		for(int i = len / 4; i < len; i += step) {
			int val = arr[i];
			int lo = binarySearchFirstLast(arr, val, true);
			int hi = binarySearchFirstLast(arr, val, false);
			
			if(hi - lo + 1 > (len / 4)) {
				System.out.println("res=" + arr[i]);
			}
		}
	}
	
	private static int binarySearchFirstLast(int[] arr, int target, boolean first) {
		int left = 0;
		int right = arr.length - 1;
		int idx = -1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == target) {
				idx = mid;
				if(first) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if(arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return idx;
	}
	

}
