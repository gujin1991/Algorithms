import java.util.*;
public class quickSort {
    public int findKthLargest(int[] nums, int k) {
        suffle(nums);
        return quickSelect(nums, 0, nums.length - 1, k);
        
    }
    
    private int quickSelect(int[] nums, int low, int high, int k) {
        
        int idx = partition(low, high, nums);
        int len = nums.length;
        if(idx == len - k) {
            return nums[idx];
        } else if(idx < len - k) {
            return quickSelect(nums, idx + 1, high, k);    
        } else {
            return quickSelect(nums, low, idx - 1, k);
        }
        
    }
    
    private int partition(int low, int high, int[] arr) {
        int pviot = arr[low];
        int left = low;
        int right = high;
        while(left < right) {
            while(left < right && arr[right] >= pviot) {
                right--;
            }    
            
            if(left < right) {
                arr[left] = arr[right];
            }
            
            while(left < right && arr[left] <= pviot) {
                left++;
            }
            
            if(left < right) {
                arr[right] = arr[left];
            }
        }
        
        arr[left] = pviot;
        return left;
    }
    
    private void suffle(int[] nums) {
        Random random = new Random();
        for(int i = 1; i < nums.length; i++) {
            int j = random.nextInt(i + 1);
            swap(i, j, nums);
        }
    }
    
    private void swap(int i, int j, int[] arrs) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}