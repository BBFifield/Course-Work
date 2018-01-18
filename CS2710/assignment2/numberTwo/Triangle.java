/**
 * This class creates triangles from known dimensions.
 * @author Brandon Fifield, Student ID: 201238730
 */
public class Triangle implements Polygon {

	private double sideBase;
	private double sideHeight;
	private double sideTwo;
	private double sideThree;
	private boolean rightTriangle;

	/**
	 * Constructs a right triangle object.
	 * @param sideBase - the base of the triangle.
	 * @param sideHeight - the height of the triangle.
	 */
	public Triangle(double sideBase, double sideHeight) {
		this.sideBase = sideBase;
		this.sideHeight = sideHeight;
		this.rightTriangle = true;
	}

	/**
	 * Constructs a non-right triangle object.
	 * @param sideBase - the base of the non-right triangle.
	 * @param sideTwo - side two of the non-right triangle
	 * @param sideThree - side three of the non-right triangle
	 * @param sideHeight - the height of the non-right triangle.
	 */
	public Triangle(double sideBase, double sideTwo, double sideThree, double sideHeight) {
		this.sideBase = sideBase;
		this.sideTwo = sideTwo;
		this.sideThree = sideThree;
		this.sideHeight = sideHeight;
	}

	/**
	 * Finds the area of any triangle.
	 * The formula used to find the area of right triangles.
	 * @return the area of the triangle.
	 */
	public double area() {
		return sideBase*sideHeight/2;    
	}

	/**
	 * Find the perimeter of a triangle.
	 * For right triangle, first find the dimension of the longest side of the right triangle by pythagorean theorem, and then add the dimensions of each side up to find the perimeter.
	 *For any other triangle, just add up all the sides.
	 * @return the perimeter of the triangle.
	 */
	public double perimeter() {
		if (rightTriangle == true) {
			return Math.sqrt(Math.pow(sideBase, 2) + Math.pow(sideHeight, 2)) + sideBase + sideHeight;
		}
		else return sideBase + sideTwo + sideThree;
	}
}
