/**
 * This class creates rectangles from known dimensions.
 * @author Brandon Fifield, Student ID: 201238730
 */
public class Rectangle implements Polygon {

	private double length;
	private double width;

	/**
	 * Constructs a rectangle object.
	 * @param length - the length of the rectangle.
	 * @param width - the width of the rectangle.
	 */
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	/**
	 * Finds the area of a rectangle.
	 * @return the area of the rectangle.
	 */
	public double area() {
		return length*width;
	}

	/**
	 * Finds the perimeter of a rectangle.
	 * @return the perimeter of the rectangle.
	 */
	public double perimeter() {
		return 2*length + 2*width;
	}

}
