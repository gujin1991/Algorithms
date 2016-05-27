import java.util.Collections;
import java.util.Random;

public class loadBalance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//what about input is a steam		
		int[] arr = {1, 1, 2, 3};
		System.out.println(getServer(4, arr));
	}
	
	private static int getServer(int n, int[] weights) {
		
		Random random = new Random();
		int len = weights.length;
		int[] sum = new int[n];
		for(int i = 0; i < weights.length; i++) {
			weights[i] *= 10;
		}
		
		sum[0] = weights[0];
		for(int i = 1; i < len; i++) {
			sum[i] += sum[i - 1] + weights[i];
		}
		
		int target = random.nextInt(sum[len - 1]);
		System.out.println(target);
		return binarySearchFirstSmaller(sum, target) + 2;
	}

	private static int binarySearchFirstSmaller(int[] sum, int target) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = sum.length - 1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(sum[mid] < target) {
				left = mid + 1;
			} else if(sum[mid] > target){
				right = mid - 1;
			} else {
				return mid;
			}
		}
		
		//Collections.sort(list);
		return right;
	}

}
