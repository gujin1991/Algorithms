package August27th;
import java.util.*;

public class NestedListWeightSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        int sum = 0;
        int level = 1;
        Queue<List<NestedInteger>> queue = new LinkedList<>();
        queue.offer(nestedList);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                List<NestedInteger> list = queue.poll();
                for(int j = 0; j < list.size(); j++) {
                    NestedInteger cur = list.get(j);
                    if(cur.isInteger()) {
                        sum += cur.getInteger() * level;
                    } else {
                        queue.offer(cur.getList());
                    }
                }
            }
            level++;
        }
        
        return sum;
    }
	
	 public interface NestedInteger {
		 
		      // @return true if this NestedInteger holds a single integer, rather than a nested list.
		      public boolean isInteger();
		 
		      // @return the single integer that this NestedInteger holds, if it holds a single integer
		      // Return null if this NestedInteger holds a nested list
		      public Integer getInteger();
		 
		      // @return the nested list that this NestedInteger holds, if it holds a nested list
		      // Return null if this NestedInteger holds a single integer
		      public List<NestedInteger> getList();
	 }

}
