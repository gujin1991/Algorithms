package Elementum;
import java.util.*;

public class FindReporter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] name = {"Tom", "John", "Mary", "Tim", "Mike"};
		String[] reporter = {"John", "Mary", "null", "Mary", "Tom"};
		find(name, reporter, "Tim");
	}
	
	private static void find(String[] name, String[] reporter, String employee) {
		int len = name.length;
		Map<String, Set<String>> map = new HashMap<>();	
		
		for(int i = 0; i < len; i++) {
			if(!reporter[i].equals("null")) {
				if(!map.containsKey(reporter[i])) {
					map.put(reporter[i], new HashSet<String>());
				}
				
				map.get(reporter[i]).add(name[i]);
			}
			
		}
		
		
		if(map.containsKey(employee)) {
			Queue<String> queue = new LinkedList<>();
			for(String next : map.get(employee)) {
				queue.offer(next);
			}
			
			while(!queue.isEmpty()) {
				int size = queue.size();
				for(int i = 0; i < size; i++) {
					String cur = queue.poll();
					System.out.println(cur);
					if(map.containsKey(cur)) {
						
						for(String next : map.get(cur)) {
							queue.offer(next);
						}
					}
				}
			}
		} else {
			System.out.println("Null");
		}
		
				
		
	}

}
