import java.util.*;
public class Flatten2DVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 5;
		System.out.println(Arrays.binarySearch(arr, 0));
		
	}
	
	public class Vector2D {
	    Iterator<List<Integer>> layer = null;
	    Iterator<Integer> col = null;
	    
	    public Vector2D(List<List<Integer>> vec2d) {
	        layer = vec2d.iterator();    
	    }

	    public int next() {
	        hasNext();
	        return col.next();   
	    }

	    public boolean hasNext() {
	        while((col == null || !col.hasNext()) && layer.hasNext()) {
	            col = layer.next().iterator();
	        }
	        return col != null && col.hasNext();    
	    }
	}

}
