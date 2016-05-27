import java.util.*;
public class PrintString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void print(String[] strs, Date[] time) {
		int len = strs.length;
		if(len < 0) {
			return;
		}
		
		Map<String, Date> map = new HashMap<>();
		for(int i = 0; i < len; i++) {
			String str = strs[i];
			if(!map.containsKey(str)) {
				System.out.println(str);
				map.put(str, time[i]);
			} else {
				if(time[i].getTime() - map.get(str).getTime() > 10000) {
					System.out.println(str);
				}
				
				map.put(str, time[i]);
			}
		}
	}

}
