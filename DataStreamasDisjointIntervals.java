package August15th;
import java.util.*;

public class DataStreamasDisjointIntervals {
	TreeMap<Integer, Interval> treemap;

    public DataStreamasDisjointIntervals() {
        treemap = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(treemap.containsKey(val)) return;
        Integer l = treemap.lowerKey(val);
        Integer h = treemap.higherKey(val);
        
        if(l != null && h != null && treemap.get(l).end + 1 == val && h - 1 == val) {
            treemap.get(l).end = treemap.get(h).end;
            treemap.remove(h);
        } else if(l != null && treemap.get(l).end + 1 >= val) {
            treemap.get(l).end = Math.max(treemap.get(l).end, val);
        } else if(h != null && h == val + 1) {
            Interval cur = treemap.get(h);
            cur.start = val;
            treemap.remove(h);
            treemap.put(val, cur);
        } else {
            treemap.put(val, new Interval(val, val));
        }

        
    }
    
    public List<Interval> getIntervals() {
        
        return new ArrayList<>(treemap.values());
    }
}

class Interval {
	int start;
	int end;
	Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}