package July31th;

public class IntegertoEnglishWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        String word = "";
        int idx = 0;
        while(num > 0) {
            if((num % 1000) != 0) {
                word = helper(num % 1000) + thousands[idx] + " " + word;
            }
            num /= 1000;
            idx++;
        }
        
        return word.trim();
    }
    
    private String helper(int num) {
        if(num == 0) {
            return "";
        } else if(num < 20) {
            return lessThan20[num] + " ";
        } else if(num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return lessThan20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

}
