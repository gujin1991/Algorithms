package June10th;
import java.util.*;

public class MovingAveragefromDataStream {
	private int idx;
	private double sum;
	private int size;
	private Queue<Integer> list;
    
    /** Initialize your data structure here. */
    public MovingAveragefromDataStream(int size) {
        this.idx = 0;
        this.sum = 0;
        this.size = size;
        this.list = new LinkedList<>();
    }
    
    public double next(int val) {
        this.sum += val;
        this.list.offer(val);
        if(this.idx >= this.size) {
            this.sum -= this.list.poll();
        }
        this.idx++;
        
        return this.sum / Math.min(this.idx, this. size);
    }
}
