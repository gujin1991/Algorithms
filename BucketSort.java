package June7th;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,7,9,2,6,8,1,10,7,5,1};
		
		sort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void sort(int[] nums) {
		int len = nums.length;
		if(len <= 1) return;
		
		int[] sum = new int[11];
		
		for(int num : nums) {
			sum[num]++;
		}
		
		for(int i = 2; i <= 10; i++) {
			sum[i] += sum[i - 1];
		}
		
		int val = 1;
		int idx = 1;
		for(int i = 0; i < len; i++) {
			while(i >= sum[idx]) idx++;
			nums[i] = idx;
		}
	}

}
