package August2nd;

public class CreateMaximumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len = Math.min(nums1.length, k);
        int[] max = new int[k];
        
        for(int i = 0; i <= len; i++) {
            if(k - i <= nums2.length) {
                int[] first = findLargest(nums1, i);
                int[] second = findLargest(nums2, k - i);
                int[] newArr = merge(first, second);
                
                if(compare(newArr, max, 0, 0)) {
                    max = newArr;
                }
            }
        }
        
        return max;
    }
    
    private boolean compare(int[] nums1, int[] nums2, int start1, int start2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mark = 0;
        
        for(;start1 < len1 && start2 < len2; start1++, start2++) {
            if(nums1[start1] > nums2[start2]) {
                return true;
            } else if(nums1[start1] < nums2[start2]){
                return false;
            }
        }
        
        return start1 != len1;
        
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] newArr = new int[len1 + len2];
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        
        while(idx1 < len1 && idx2 < len2) {
            if(compare(nums1, nums2, idx1, idx2)) {
                newArr[idx3++] = nums1[idx1++];   
            } else {
                newArr[idx3++] = nums2[idx2++];
            }
        }
        
        while(idx1 < len1) {
            newArr[idx3++] = nums1[idx1++];
        }
        
        while(idx2 < len2) {
            newArr[idx3++] = nums2[idx2++];
        }
        
        return newArr;
    }
    
    private int[] findLargest(int[] nums, int k) {
        int[] largest = new int[k];
        int len = nums.length;
        int pos = 0;
        
        for(int i = 0; i < len; i++) {
            while(pos > 0 && pos + len - i > k && largest[pos - 1] < nums[i]) {
                pos--;
            }
            
            if(pos < k) {
                largest[pos++] = nums[i];
            }
        }
        
        return largest;
    }

}
