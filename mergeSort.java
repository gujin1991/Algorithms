
public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,41,4,2,5,73,9};
		sort(0, arr.length - 1, arr);
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
	
	private static void sort(int lo, int hi, int[] arr) {
		if(lo >= hi) return;
		
		int mid = lo + (hi - lo) / 2;
		sort(lo, mid, arr);
		sort(mid + 1, hi, arr);
		merge(lo, hi, arr);
	}

	private static void merge(int lo, int hi, int[] arr) {
		// TODO Auto-generated method stub
		int left = lo;
		
		int mid = lo + (hi - lo) / 2;
		int right = mid + 1;
		int[] temp = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		
		for(int i = lo; i <= hi; i++) {
			if(left > mid) 
				arr[i] = temp[right++];
			else if(right > hi)
				arr[i] = temp[left++];
			else if(temp[left] < temp[right])
				arr[i] = temp[left++];
			else
				arr[i] = temp[right++];
			
		}

	}
	
	

}
