
public class dollarfor100chickens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		optimal();
	}
	
	public static void brute() {
		int rooster = 1;
		int hen = 1;
		int poult = 0;
		
		for(; rooster < 20; rooster++) {
			for(; hen < 33; hen++) {
				poult = 100 - rooster - hen;
				if((poult % 3 == 0) && (rooster * 5 + hen * 3 + poult / 3) == 100) 
					System.out.println("Rooster:" + rooster + " Hen:" + hen
							+ " Poult:" + poult );
			}
			hen = 1;
		}
	}
	
	//可推导出y ＝ 25 － （7/4）x； 所以x是4的倍数，y是按7递减，z是按3递增。
	public static void optimal() { 
		
		for(int i = 1; i <=3; i++) {
			int rooster = 4 * i;
			int hen = 25 - 7 * i;
			int poult = 75 + 3 * i;
			
			System.out.println("Rooster:" + rooster + " Hen:" + hen
					+ " Poult:" + poult );
		}
	}

}
