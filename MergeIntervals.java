import java.util.*;
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        int len = intervals.size();
        if(len == 0) {
            return res;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval ob1, Interval ob2) {
                return ob1.start - ob2.start;
            }
            
        });
        //Collections.sort(intervals, ((a,b) -> (a.start - b.start)));
        Interval prev = intervals.get(0);
        
        for(int i = 1; i < len; i++) {
            Interval cur = intervals.get(i);
            if(cur.start <= prev.end) {
                if(cur.end >= prev.end) {
                    prev.end = cur.end;
                }
            } else {
                res.add(prev);
                prev = cur;
            }
        }
        
        res.add(prev);
        
        return res;
        
    }

	
	private class Interval {
		
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

}
