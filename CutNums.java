import java.util.*;

public class CutNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,15,20,25,30};
		System.out.println(finCutNums(arr, 56));
		//写的很乱，如何优化
	}
	
	private static int finCutNums(int[] arr, int curNum) {
		int cnt = 0;
		Arrays.sort(arr);
		LinkedList<Integer> list = new LinkedList<>();
		
		int len = arr.length;
		for(int i = 0; i < len; i++) {
			if(arr[i] <= 10) continue;
			else {
				if(arr[i] % 10 == 0) {
					int cutNum = arr[i] / 10 - 1;
					if(cutNum > curNum) {
						cnt += curNum;
						return cnt;
					} else {
						cnt += cutNum + 1;
						curNum -= cutNum;
					}
				} else {
					list.add(arr[i]);
				}
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			int val = list.get(i);
			if(curNum <= 0) {
				return cnt;
			} else {
				cnt += Math.min(val / 10, curNum);
				curNum -= Math.min(val / 10, curNum);
			}
		}
		
		return cnt;
		 
		
	}

}
