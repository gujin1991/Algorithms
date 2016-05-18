
public class RemoveDuplications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplications(11223));
	}
	
	public static int removeDuplications(int val) {
		int sign = 0;
		if(val < 0) {
			sign = 1;
			val = - val;
		}
		
		String strVal = String.valueOf(val);
		int len = strVal.length();
		char prev = strVal.charAt(0);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < len - 1; i++) {
			char c = strVal.charAt(i);
			if(c == prev) {
				max = Math.max(max, Integer.parseInt(strVal.substring(0,i) + strVal.substring(i + 1)));
				min = Math.min(min, Integer.parseInt(strVal.substring(0,i) + strVal.substring(i + 1)));
				while(i < len - 1 && strVal.charAt(i) == strVal.charAt(i + 1)) {
					i++;
				}
				
			}
			prev = strVal.charAt(i);
		}
		
		return sign == 0 ? max : -min;
		
	}

}
