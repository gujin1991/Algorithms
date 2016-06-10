package June7th;

import java.util.Arrays;

public class SortStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sort("VBA7425IWC"));
	}
	
	
	static String sort(String str) {
		int len = str.length();
		if(len <= 1) return str;
		
		boolean isNum = true;
		int idx = 0;
		String newStr = "";
		
		if(!Character.isDigit(str.charAt(0))) isNum = false;
		
		while(idx < len) {
			int lastIdx = idx;
			while(idx < len && Character.isDigit(str.charAt(idx)) == isNum) idx++;
			
			newStr += sortStr(str.substring(lastIdx, idx), isNum);
			isNum = !isNum;
		}
		
		return newStr;
	}


	private static String sortStr(String str, boolean isNum) {
		// TODO Auto-generated method stub
		int len = str.length();
		if(len <= 1) return str;
		
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		
		return new String(chars);
	}
}
