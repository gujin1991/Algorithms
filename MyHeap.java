package August11th;

public class MyHeap {
	private int[] heap;
	private int maxSize;
	private int currentSize;
	
	public MyHeap(int size) {
		this.maxSize = size;
		this.currentSize = 0;
		this.heap = new int[size + 1];
	}
	
	private int leftChildren(int pos) {
		return 2 * pos;
	}
	
	private int rightChildren(int pos) {
		return 2 * pos + 1;
	}
	
	private int parent(int pos) {
		return pos / 2;
	}
		
	private void swap(int[] nums, int a, int b) {
		nums[a] ^= nums[b];
		nums[b] ^= nums[a];
		nums[a] ^= nums[b];
	}
	
	public void insert(int val) {
		if(this.currentSize == this.maxSize) {
			if(val > heap[0]) {
				swap(heap, 1, this.maxSize);
				this.currentSize--;
				shiftDown(1);
				this.currentSize++;
				heap[this.currentSize] = val;
				shiftUp(this.currentSize);
			} else {
				this.currentSize++;
				heap[this.currentSize] = val;
				shiftUp(this.currentSize);
			}
		}
	}
	
	public void shiftDown(int pos) {
		int left = this.leftChildren(pos);
		int right = this.rightChildren(pos);
		if(this.leftChildren(pos) > this.currentSize && this.rightChildren(pos) > pos) {
			return;
		} else if(heap[left] >= heap[pos] && heap[right] > heap[pos]) {
			return;
		} else {
			if(heap[left] >= heap[right]) {
				swap(heap, pos, right);
				shiftDown(right);
			} else {
				swap(heap, pos, left);
				shiftDown(left);
			}
		}
	}
	
	public void shiftUp(int pos) {
		int parent = this.parent(pos);
		if(parent >= 1 && heap[parent] > heap[pos]) {
			swap(heap, parent, pos);
			shiftUp(parent);
		}
	}
	
	public int poll() {
		int val = heap[1];
		swap(heap, 1, this.currentSize);
		this.currentSize--;
		shiftDown(1);
		return val;
	}
	
	
}
