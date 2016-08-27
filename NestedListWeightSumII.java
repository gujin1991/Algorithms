package August27th;

import java.util.*;

import August27th.NestedListWeightSum.NestedInteger;

public class NestedListWeightSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweight = 0;
        int weight = 0;
        while(!nestedList.isEmpty()) {
            List<NestedInteger> next = new ArrayList<>();
            for(int i = 0; i < nestedList.size(); i++) {
                if(nestedList.get(i).isInteger()) {
                    unweight += nestedList.get(i).getInteger();
                } else {
                    next.addAll(nestedList.get(i).getList());
                }
            }
            weight += unweight;
            nestedList = next;
        }
        
        return weight;
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
