
public class PrintInScreen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Count("I like Google", 20, 15));
	}
	
	public static int Count(String str, int row, int col) {
		int cnt = 0;
		int next = 0;
		//int len = str.length() + 1;
		String[] words = str.split(" ");
		int len = words.length;
		
		for(int i = 0; i < row; i++) {
			int used = 0;
			while(used + words[next].length() <= col) {
				System.out.print(words[next] + " ");
				used += words[next].length() + 1;
				if(next == len - 1) {
					cnt++;
				}
				next = (next + 1) % len;
			}
			
			System.out.println("");
		}
		
		return cnt;
	}

}
