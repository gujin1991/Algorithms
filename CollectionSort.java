package August1st;
import java.util.*;

public class CollectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee("John", 1));
		list.add(new Employee("John", 2));
		list.add(new Employee("Bob", 3));
		list.add(new Employee("Amy", 4));
		
		//Collections.sort(list, (a, b) -> (a.name - b.name));
		
		System.out.println(list);
		
	}
	
	static class Employee {
		String name;
		int id;
		
		public Employee(String n, int i) {
			this.name = n;
			this.id = i;
		}
	}

}
