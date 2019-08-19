package com.hyend.logical.algorithms.dp.geometry;

/**
 * The time complexity is O(1).
 * Since the number of operations are constant.
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
		
		if(!isIntersecting(r1, r2)) {
			return new Rectangle(0, 0, -1, -1);
		}
		
		return new Rectangle(getMaxX(r1, r2), getMaxY(r1, r2),
				getIntersectingWidth(r1, r2), getIntersectingHeight(r1, r2));
	}
	
	/**
	 * Helper Methods	
	 * @param r1
	 * @param r2
	 * @return
	 */
	private int getMaxX(Rectangle r1, Rectangle r2) {
		return Math.max(r1.x, r2.x);
	}

	private int getMaxY(Rectangle r1, Rectangle r2) {
		return Math.max(r1.y, r2.y);
	}

	private int getIntersectingWidth(Rectangle r1, Rectangle r2) {
		return Math.min(r1.x + r1.width, r2.x + r2.width) - getMaxX(r1, r2);
	}

	private int getIntersectingHeight(Rectangle r1, Rectangle r2) {
		return Math.min(r1.y + r1.height, r2.y + r2.height) - getMaxY(r1, r2);
	}

	private boolean isIntersecting(Rectangle r1, Rectangle r2) {
		return ((r1.x <= r2.x + r2.width && r1.x + r1.width >= r2.x) && 
				(r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y));		
	}
}
