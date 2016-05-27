
public class findMissNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMiss("12131516"));
	}
	
	
	static String findMiss(String str) {
		int len = str.length();
		
		for(int i = 1; i <= len / 2; i++) {
			String miss = find(str, i);
			if(!miss.equals("")) {
				return miss;
			}
		}
		
		return "";
	}


	private static String find(String str, int n) {
		// TODO Auto-generated method stub
		int bits = n;
		int p = n;
		int len = str.length();
		int cur = Integer.parseInt(str.substring(0,bits));
		int next = 0;
		String miss = "";
		
		while(p < len) {
			int now = cur + 1;
			bits = (cur + "").length();
			next = Integer.parseInt(str.substring(p, Math.min(p + bits, len)));
			//System.out.println(now + " " + next);
			p += bits;
			if(now != next) {
				if(miss.equals("")) {
					miss += now;
				} else {
					return "";
				}
			}
			cur = next;
			
		}
		return miss;
	}
	
	

}
