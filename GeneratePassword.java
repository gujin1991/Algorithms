import java.util.*;

public class GeneratePassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//not quite understand
		System.out.println(generate());
	}
	
	private static String generate() {
		Set<Integer> set = new HashSet<>();
		int num = 9999;
		String result = "999";
		
		while(set.size() < 10000) {
			result += (num % 10);
			set.add(num);
			num *= 10;
			num %= 10000;
			
			boolean flag = false;
			
			for(int i = 0; i < 10; i++) {
				if(!set.contains(num + i)) {
					num += i;
					flag = true;
					break;
				}
			}
			
			if(!flag) break;
			
		}
		
		return result;
	}

}
