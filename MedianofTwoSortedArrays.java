package July17th;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if((len1 + len2) % 2 == 1)
            return findkth(nums1, 0, nums2, 0, (len1 + len2) / 2  + 1);
        else {
            return (findkth(nums1, 0, nums2, 0, (len1 + len2) / 2 ) + findkth(nums1, 0, nums2, 0, (len1 + len2) / 2 + 1)) / 2.0;
        }
    }
    
    private double findkth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if(start1  >= len1) {
            return nums2[start2 + k - 1];
        }
        
        if(start2 >= len2) {
            return nums1[start1 + k - 1];
        }
        
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);
        
        int akey = start1 + k / 2  > len1 ? Integer.MAX_VALUE : nums1[start1 + k / 2 - 1];
        int bkey = start2 + k / 2  > len2 ? Integer.MAX_VALUE : nums2[start2 + k / 2 - 1];
        
        if(akey < bkey) {
            return findkth(nums1, start1 + k / 2, nums2, start2, k - k/2);
        } else {
            return findkth(nums1, start1, nums2, start2 + k / 2, k - k/2);

        }
        
        
    }

}
