import java.util.*;
public class TopKFrequentNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> topKFrequentWithBucketSort(int[] nums, int k) {
        List<Integer> kEles = new ArrayList<>();
        int len = nums.length;
        List<Integer>[] bucket = new List[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        
        for(int key : map.keySet()) {
            int fre = map.get(key);
            if(bucket[fre] == null) {
                bucket[fre] = new ArrayList<Integer>();
                
            }
            bucket[fre].add(key);
        }
        
        for(int i = len; i >= 0 && kEles.size() < k; i--) {
            if(bucket[i] != null) {
                kEles.addAll(bucket[i]);
            }
        }
        
        return kEles;
        
    }
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> kEles = new ArrayList<>();
        int len = nums.length;
        PriorityQueue<Element> pq = new PriorityQueue<>(k, new Comparator<Element>() {
        	public int compare(Element ob1, Element ob2) {
        		return ob2.frequence - ob1.frequence;
        	}
        });
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        
        for(int key : map.keySet()) {
            pq.add(new Element(key, map.get(key)));
        }
        
        while(k > 0) {
            kEles.add(pq.poll().val);
            k--;
        }
        
        return kEles;
        
    }
    
    private class Element {
        int val;
        int frequence;
        
        public Element(int val, int frequence) {
            this.val = val;
            this.frequence = frequence;
        }
    }
}
