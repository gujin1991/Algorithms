import java.awt.Point;
import java.util.*;

public class CanFromRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canForm(Rectangle target, Rectangle[] rects) {
		
		int sum = 0;
		Map<Point, Rectangle> map = new HashMap<>();
		Queue<Point> queue = new LinkedList<>();
		for(Rectangle rect : rects) {
			sum += rect.getArea();
			if(map.containsKey(rect.point)) return false;
			map.put(rect.point, rect);
		}
		
		Point upper = new Point(target.point.x, target.point.y + target.height);
		Point right = new Point(target.point.x + target.width, target.point.y);
		//map.put(upper, target);
		//map.put(right, target);

		
		if(sum != target.getArea()) {
			return false;
		}
		
		queue.offer(target.point);
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			if(map.containsKey(cur)) {
				if(cur != upper && cur != right) {
					queue.offer(new Point(cur.x, cur.y + map.get(cur).height));
					queue.offer(new Point(cur.x + map.get(cur).width, cur.y));
				}
				map.remove(cur);
			}
		}
		
		return map.size() == 0;
		
		
	}
	
	
	private class Rectangle{
		int height;
		int width;
		Point point;
		
		public Rectangle(int hei, int wid, int x, int y) {
			this.height = hei;
			this.width = wid;
			point.setLocation(x, y);
		}
		
		int getArea() {
			return height * width;
		}
		
	}
}
