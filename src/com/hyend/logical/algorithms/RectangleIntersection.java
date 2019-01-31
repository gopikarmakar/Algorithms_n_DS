package com.hyend.logical.algorithms;

/**
 * The time complexity is O(1).
 * Since since the number of operations is constant.
 * @author gopi_karmakar
 *
 */
public class RectangleIntersection {
	
	public RectangleIntersection(Rectangle r1, Rectangle r2) {}
	
	class Rectangle {
		
		int x, y, width, height;
		
		public Rectangle(int x, int y, int width, int height) {
			
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
	}
	
	public Rectangle intersectRectangle(Rectangle r1, Rectangle r2) {
		
		if(!isIntersect(r1, r2)) {
			return new Rectangle(0, 0, -1, -1);
		}
		
		return new Rectangle(Math.max(r1.x, r2.x), Math.max(r1.y, r2.y),
				(Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x)),
				(Math.min(r1.y + r1.height, r2.y + r2.height) - Math.max(r1.y, r2.y)));
	}
	
	private boolean isIntersect(Rectangle r1, Rectangle r2) {
		
		return ((r1.x <= r2.x + r2.width && r1.x + r1.width >= r2.x) &&
				(r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y));		
	}
}
