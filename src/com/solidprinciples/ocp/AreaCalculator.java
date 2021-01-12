package com.solidprinciples.ocp;

/**
 * Open/Closed Principle example
 * 
 * @author prashanth
 *
 */
public class AreaCalculator {

	/**
	 * Very bad design. Whenever we need a new shape this method needs to be
	 * updated. That means it is open for modification. It need to be re-designed to
	 * follow open for extension and closed for modification
	 * 
	 * @param shapes
	 * @return
	 */
	public double area(Shape[] shapes) {
		double sum = 0;
		for (Shape shape : shapes) {
			if (shape instanceof Circle) {
				sum += 3.14 * Math.pow(((Circle) shape).getRadius(), 2);
			} else if (shape instanceof RectAngle) {
				RectAngle r = (RectAngle) shape;
				sum += r.getWidth() * r.getHight();
			}
		}
		return sum;

	}

	/**
	 * Open for extension and closed for modification. No changes needed when the
	 * new shape is added.
	 * 
	 * @param shapes
	 * @return
	 */
	public double areaPerfect(Shape[] shapes) {
		double sum = 0;
		for (Shape shape : shapes) {
			sum += shape.area();
		}
		return sum;
	}
}
