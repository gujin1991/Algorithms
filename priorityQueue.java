import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class priorityQueue {
	private List<heapNode> nodeList = new ArrayList<heapNode>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		priorityQueue test = new priorityQueue();
		// TODO Auto-generated method stub
		for(int i = 1; i < 5 ; i++) {
			//Random ran = new Random();
			//int val = ran.nextInt(20);
			test.enqueue(i, i);
		}
		
		for(int i = 0; i < test.nodeList.size(); i++) {
			System.out.println(test.nodeList.get(i).val + " level" + test.nodeList.get(i).level);
		}
		while(true) {
			heapNode out = test.dequeue();
			if(out == null) {
				break;
			}
			
			System.out.println("Data: " + out.val + "Level: " +  out.level);
		
		}
	}

	
	public void enqueue(int value, int level) {
		nodeList.add(new heapNode(value, level));
		if(nodeList.size() == 1) 
			return;
		int parent = nodeList.size() / 2 - 1;
		upHeapAdjust(parent);
				
	}

	private void upHeapAdjust(int parent) {
		// TODO Auto-generated method stub
		while(parent >= 0) {
			int left = 2 * parent + 1;
			int right = left + 1;
			
			int max = left;
			if(right < nodeList.size()) {
				max = nodeList.get(right).level < nodeList.get(left).level ? left : right;
			}
			
			if(nodeList.get(parent).level < nodeList.get(max).level) {
				heapNode temp = nodeList.get(parent);
				nodeList.set(parent, nodeList.get(max));
				nodeList.set(max, temp);
				
				
				parent =  ((int)Math.ceil((float)parent / 2) - 1); 
				//System.out.println(parent+"good");
			} else {
				break;
			}
		}
		
		
	}
	
	public heapNode dequeue() {
		if(nodeList.size() == 0) {
			return null;
		}
		
		heapNode out = nodeList.get(0);
		nodeList.set(0, nodeList.get(nodeList.size() - 1));
		nodeList.remove(nodeList.size() - 1);
		
		downHeapAdjust(0);
		return out;
	}

	private void downHeapAdjust(int parent) {
		// TODO Auto-generated method stub
		int size = nodeList.size();
		while(2 * parent + 1 < size) {
			int left = 2 * parent + 1;
			int right = left + 1;
			
			int max = left;
			if(right < nodeList.size()) {
				max = nodeList.get(right).level < nodeList.get(left).level ? left : right;
			}
			
			if(nodeList.get(parent).level < nodeList.get(max).level) {
				heapNode temp = nodeList.get(parent);
				nodeList.set(parent, nodeList.get(max));
				nodeList.set(max, temp);
				parent = max; 
			} else {
				break;
			}
		}
	}
	
	public heapNode getAndDownPriority(int level) {
		if(nodeList.size() == 0) {
			return null;
		}
		
		//heapNode out = nodeList.get(0);
		
		nodeList.get(0).level = level == Integer.MIN_VALUE ? --nodeList.get(0).level : level;
		downHeapAdjust(0);
		return nodeList.get(0);
	}
	
	 public heapNode GetAndDownPriority() {
            //下降一个优先级
            return getAndDownPriority(Integer.MIN_VALUE);
     }
	
	
}
