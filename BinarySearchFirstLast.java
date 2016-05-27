import java.util.Arrays;

public class BinarySearchFirstLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 3,3,5,7};
		System.out.println(Search(arr, 1, true));
		System.out.println(Arrays.binarySearch(arr, 6));
	
	}
	
	static int Search(int[]arr, int target, boolean first) {
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
