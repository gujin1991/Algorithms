
import java.util.*;
public class findComsInArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,61,7,8};
		findComs(arr, 4);
	}
	
	private static void findComs(int[] arr, int k) {
		int diff = arr.length / k;
		DFS(0, diff, "", arr);
		//如何memories，用hashtable value放链表？
	}
	
	
	private static void DFS(int start, int diff, String prefix, int[] arr) {
		// TODO Auto-generated method stub
		if(start >= arr.length) {
			System.out.println(prefix.trim());
			return;
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = start; i < Math.min(start + diff, arr.length); i++) {
			if(set.add(arr[i])) {
				String newPre = prefix + arr[i] + " ";
				DFS(start + diff, diff, newPre, arr);
			}
		}
	}

}
