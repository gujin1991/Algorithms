package June7th;
import java.util.*;

public class Blend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		ArrayList<Integer> list = getReversedList(arr);
		for(int val : list) {
			//System.out.println(val);
		}
		
		System.out.println(guess(null));
	}
	
	static ArrayList<Integer> getReversedList(int[] arr) {
		ArrayList<Integer> resList = new ArrayList<>();
		int len = arr.length;
		
		for(int i = len - 1; i >= 0; i--) {
			resList.add(arr[i]);
		}
		
		return resList;	
	}
	
	static long getSum(int[] arr) {
		long sum = 0;
		for(int val : arr) {
			sum += val;
		}
		
		return sum;

	}
	
	
	static int guess(String str) {
		if(str == null) return 3;
		Set<String> color = new HashSet<>();
		color.add("green");
		color.add("red");
		color.add("yellow");
		color.add("purple");
		color.add("orange");
		color.add("pink");
		color.add("turquoise");
		color.add("blue");
		
		if(color.contains(str)) return 1;
		else if(str.length() >= 9) return 2;
		else return 3;
		
		
	}

}
