/**
 * This class creates tests the rectangle and triangle classes by first creating objects and then finding their areas and perimeters.
 * @author Brandon Fifield, Student ID: 201238730
 */
public class PolygonTester {
	public static void main(String[] args) {

		// Constructs a right triangle.
		Triangle triangle = new Triangle(3, 4);
		// Constructs a non-right triangle.
		Triangle triangleTwo = new Triangle(3,4,5,4.5); 
		Rectangle rectangle = new Rectangle(5, 7);

		//Find area and perimeter of right triangle.
		double areaT = triangle.area();
		double perimeterT = triangle.perimeter();

		//Find area and perimeter of a non-right triangle.
		double areaTwo = triangleTwo.area();
		double perimeterTwo = triangleTwo.perimeter();

		//Find area and perimeter of rectangle.
		double areaR = rectangle.area();
		double perimeterR = rectangle.perimeter();

		//Output the area and perimeter of each object.
		System.out.printf("Triangle:%nArea = %1.2f%nPerimeter = %1.2f%n%nNon-Right Triangle:%nArea = %1.2f%nPerimeter = %1.2f%n%nRectangle:%nArea = %1.2f%nPerimeter = %1.2f%n", areaT, perimeterT, areaTwo, perimeterTwo, areaR, perimeterR);  
	}
}
