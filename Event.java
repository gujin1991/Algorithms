package June7th;
import java.util.*;

public class Event {
	private String type;
	private Date date;
	private int guestNo;
	private final int cost = 40;
	private int eventNo;
	
	public Event(String name) {
		this.type = name;
	}
	
	public Event(String name, Date d) {
		this.type = name;
		this.date = d;
	}

	public Event(String name, Date d, int gnum) {
		this.type = name;
		this.date = d;
		this.guestNo = gnum;
	}
	
	public int total(int num) {
		return num * this.cost;
	}
	
	
	public void print() {
		System.out.println(this.type);
	}
	
	
	
}
