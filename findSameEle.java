
public class findSameEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2,3,4};
		int[] arr2 = {1,2,3,4,5};
		findEle(arr1, arr2);
	}
	
	public static void findEle(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		
		int idx1 = 0;
		int idx2 = 0;
		while(idx1 < len1 && idx2 < len2) {
			if(arr1[idx1] == arr2[idx2]) {
				System.out.println(arr1[idx1]);
				idx1++;
				idx2++;
			} else if(arr1[idx1] < arr2[idx2]) {
				idx1++;
			} else {
				idx2++;
			}
		}
	}

}
