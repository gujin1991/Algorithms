
public class MovingAverage {
	private int ageSum;
	private int peopleNum;
	
	public MovingAverage() {
		this.ageSum = 0;
		this.peopleNum = 0;
	}
	
	public void inHouse(int age) {
		this.ageSum += age;
		this.peopleNum++;
	}
	
	public void outHouse(int age) {
		this.ageSum -= age;
		this.peopleNum--;
	}
	
	public int getAverage() {
		if(isEmpty()) return 0;
		return this.ageSum / this.peopleNum;
	}
	
	public boolean isEmpty() {
		return this.peopleNum == 0;
	}
	
}
