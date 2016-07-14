import java.util.*;

public class Shuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6};
		perfectShuffle2(nums, 0, 3);
		for(int val : nums) {
			System.out.print(val);	
		}
	}
	
	private void shuffle(int[] nums) {
		int len = nums.length;
		if(len <= 1) return;
		
		Random random = new Random();
		for(int i = len - 1; i >= 0; i--) {
			int j = random.nextInt(i + 1);
			swap(nums, i, j);
		}
	}

	private void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private void perfectShuffle1(int[] nums) {
		int len = nums.length;
		if (len <= 1) return;
		
		int[] temp = new int[len];
		for(int i = 0; i < len; i++) {
			temp[(i / 2) % (len + 1)] = nums[i];
		}
		
		for(int i = 0; i < len; i++) {
			nums[i] = temp[i];
		}
	}
	
	private static void perfectShuffle2(int[] nums, int start, int n) {
		if (n == 0) return;
		
		int n2 = n * 2;
		int half = n / 2;
		
		if (n % 2 == 1) {
			int temp = nums[start + n - 1];
			
			for(int i = start + n  - 1; i < start + n2 - 1; i++) {
				nums[i] = nums[i + 1];
			}
			
			nums[start + n2 - 1] = temp;
			n--;
		}
		
		for(int i = start + half; i < start + n; i++) {
			int temp = nums[i];
			nums[i] = nums[i + half];
			nums[i + half] = temp;
		}
		
		for(int val : nums) {
			System.out.print(val);	
		}
		System.out.println("start = " + start);	
		
		perfectShuffle2(nums, start, half);
		perfectShuffle2(nums, start + n, half);

	}

}
