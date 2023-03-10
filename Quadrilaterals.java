package ShapesJava;

import Coordinates.Distance;

/**
 * A class to handle quadrilaterals of most types
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 * @Reference https://mathsisfun.com/quadrilaterals.html
 */
public class Quadrilaterals {

	private static double top;
	private static double bottom;
	private static double left;
	private static double right;
	
	private static double height; // For use with opposite() and parallel()
	private static double width; // For use with opposite()
	
	private static double top_left_angle;
	private static double bottom_left_angle;
	private static double top_right_angle;
	private static double bottom_right_angle;

	private static double top_left_angle_x;
	private static double top_left_angle_y;
	private static double bottom_right_angle_x;
	private static double bottom_right_angle_y;
	private static double top_right_angle_x;
	private static double top_right_angle_y;
	private static double bottom_left_angle_x;
	

	private static double bottom_left_angle_y;
	/**
	 * Checks if the values entered match up to the rules of a quadrilateral
	 * @return
	 */
	public static boolean quadrilateral() {
		
		double sum = top_left_angle + bottom_left_angle + top_right_angle + bottom_right_angle;
		
		if (sum == 360 && top != 0 && bottom != 0 && left != 0 && right != 0 && top_left_angle != 0 && bottom_left_angle != 0 && top_right_angle != 0 && bottom_right_angle != 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Checks if all sides are equal
	 * @return
	 */
	public static boolean all_sides_equal() {
		
		if (top == bottom && bottom == left &&  left == right && right == top && right == bottom) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Checks if all angles are equal
	 * @return
	 */
	public static boolean all_angles_equal() {
		if(top_left_angle == bottom_left_angle && bottom_left_angle == bottom_right_angle && bottom_right_angle == top_right_angle) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if two angles are equal, DOES NOT tell you which ones
	 * @return
	 */
	public static boolean two_angles_equal() {
		if (top_left_angle == bottom_left_angle || top_right_angle == bottom_right_angle) {
			return true;
		} else if (bottom_left_angle == bottom_right_angle || top_left_angle == top_right_angle) {
			return true;
		} else if (top_left_angle == bottom_right_angle || bottom_left_angle == top_right_angle) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if the quadrilateral is a square
	 * @return
	 */
	public static boolean square() {
		
		if (quadrilateral() == true && all_sides_equal() == true && all_angles_equal() == true && opposite() == true && parallel() == true) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Checks if the quadrilateral is a rectangle
	 * @return
	 */
	public static boolean rectangle() {
		
		if (quadrilateral() == true && top == bottom && right == left &&  left != bottom && right != top && all_angles_equal() == true) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Checks if the quadrilateral is a rhombus
	 * @return
	 */
	public static boolean rhombus() {
		
		if (quadrilateral() == true && all_sides_equal() == true && top_left_angle > 90 && bottom_right_angle > 90 && top_right_angle < 90 && bottom_left_angle < 90) {
			return true;
		} else if (quadrilateral() == true && all_sides_equal() == true && top_left_angle < 90 && bottom_right_angle < 90 && top_right_angle > 90 && bottom_left_angle > 90) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * Checks if the quadrilateral is a parallelogram
	 * @return
	 */
	public static boolean parallelogram() {
		
		if (quadrilateral() == true && parallel() == true && top_left_angle < 90 && bottom_left_angle > 90 && top_right_angle > 90 && bottom_right_angle < 90) {
			return true;
		} else if (quadrilateral() == true && parallel() == true && top_left_angle > 90 && bottom_left_angle < 90 && top_right_angle < 90 && bottom_right_angle > 90) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Using height, creates a boolean of distance greater than 0 and 
	 * perpendicular to each other for top and bottom
	 * @return
	 */
	public static boolean parallel() {
		
		Distance.setPoint(top / 2);
		Distance.setPoint_b(height);
		
		if (height != 0 && Distance.distance() == height) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Using height, creates a boolean of distance greater than 0 and 
	 * perpendicular to each other for top and bottom
	 * @return
	 */
	public static boolean opposite() {
		
		Distance.setPoint(top / 2);
		Distance.setPoint_b(height);
		
		if (height != 0 && Distance.distance() == height) {
			return true;
		}
		
		Distance.setPoint(bottom / 2);
		Distance.setPoint_b(height);
		
		if (height != 0 && Distance.distance() == height) {
			return true;
		}
		
		Distance.setPoint(left / 2);
		Distance.setPoint_b(width);
		
		if (width != 0 && Distance.distance() == width) {
			return true;
		}
		
		Distance.setPoint(right / 2);
		Distance.setPoint_b(width);
		
		if (width != 0 && Distance.distance() == width) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Checks if the quadrilateral is an irregular trapezium
	 * @return
	 */
	public static boolean trapezium() {
		
		if (quadrilateral() == true && all_sides_equal() == false && all_angles_equal() == false && two_angles_equal() == false && top != bottom && left != right && parallel() == true) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Checks if the quadrilateral is an isosceles trapezium
	 * @return
	 */
	public static boolean isosceles_trapezium() {
		
		if (quadrilateral() == true && all_sides_equal() == false && all_angles_equal() == false && two_angles_equal() == true && parallel() == true) {
			if (bottom_right_angle == bottom_left_angle && top_right_angle == top_left_angle && left == right) {
				return true;
			}
			return true;
		} else if (quadrilateral() == true && all_sides_equal() == false && all_angles_equal() == false && two_angles_equal() == true && parallel() == true) {
			if (bottom_left_angle == top_left_angle && top_right_angle == bottom_right_angle && top == bottom) {
				return true;
			}
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Checks if the quadrilateral is a kite
	 * @return
	 */
	public static boolean kite () {
		
		if (quadrilateral() == true && two_angles_equal() == true) {
			if (top == right && top_left_angle == bottom_right_angle || bottom == left && top_left_angle == bottom_right_angle) {
				return true;
			} else if (top == left && top_right_angle == bottom_left_angle || bottom == right && top_right_angle == bottom_left_angle) {
				return true;
			}
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Provides the diagonal of the square after running the quadrilateral and square checks
	 * @return
	 */
	public static double square_diagonal() { 
		double diagonal = 0;
		
		if (quadrilateral() == true && square() == true) {
			diagonal = right * Math.sqrt(2);
		}
		
		return diagonal;
	}
	
	/**
	 * Provides the area of the square after running the quadrilateral and square checks
	 * @return
	 */
	public static double square_area() {
		
		double area = 0;
		
		if (quadrilateral() == true && square() == true) {
			area = Math.pow(top, 2);
		} else if (quadrilateral() == true && square() == true) {
			area = Math.pow(square_diagonal(), 2) / 2;
		}
		
		return area;
	}
	
	/**
	 * Provides the perimeter of the square after performing the quaderilateral and rectangle checks
	 * @return
	 */
	public static double square_perimeter() {
		
		double perimeter = 0;
		
		if (quadrilateral() == true && square() == true) {
			perimeter = right * 4;
		}
		
		return perimeter;
	}
	
	/**
	 * Provides the diagonal specifications of the rectangle after running the quadrilateral and rectangle checks
	 * @return
	 */
	public static double rectangle_diagonal() { 
		double diagonal = 0;
		
		if (quadrilateral() == true && rectangle() == true) {
			Triangle.setAdjacent(bottom);
			Triangle.setOpposite(left);
			Triangle.right_triangle_edges();
			diagonal = Triangle.getHypotenuse();
		}
		
		return diagonal;
	}
	
	/**
	 * Provides the area of the rectangle after running the quadrilateral and square checks
	 * @return
	 */
	public static double rectangle_area() {
		
		double area = 0;
		
		if (quadrilateral() == true && rectangle() == true) {
			area = Math.pow(left, bottom);
		} else if (quadrilateral() == true && rectangle() == true) {
			area = Math.pow(right, top);
		}
		
		return area;
	}
	
	/**
	 * Provides the perimeter of the rectangle after performing the quaderilateral and rectangle checks
	 * @return
	 */
	public static double rectangle_perimeter() {
		
		double perimeter = 0;
		
		if (quadrilateral() == true && rectangle() == true) {
			perimeter = top+bottom+left+right;
		}
		
		return perimeter;
	}
	
	/**
	 * The halfway point between the top and bottom of the trapezium
	 * @return
	 */
	public static double trapezium_median() {
		double median = 0;
		
		if (quadrilateral() == true && trapezium() == true) {
			median = top + bottom / 2;
		}
		
		return median;
	}
	
	/**
	 * Provides the area of the trapezium after running the quadrilateral and square checks
	 * @return
	 */
	public static double trapezium_area() {
		
		double area = 0;
		
		if (quadrilateral() == true && trapezium() == true) {
			area = Math.pow((top + bottom / 2), height); 
		} else if (quadrilateral() == true && trapezium() == true)  {
			area = trapezium_median() * height;
		}
		
		return area;
	}
	
	/**
	 * Provides the perimeter of the trapezium after performing the quaderilateral and rectangle checks
	 * @return
	 */
	public static double trapezium_perimeter() {
		
		double perimeter = 0;
		
		if (quadrilateral() == true && trapezium() == true) {
			try {
				perimeter = top + bottom + left + right;
			} catch (ArithmeticException A) {
				System.err.println(A);
			} finally {
				System.out.println("Make sure all of the sides are equal and have a size allocated");
			}
		}
		
		return perimeter;
	}
	
	/**
	 * Checks if the rectangle is golden ratio
	 * @return
	 */
	public static boolean rectangle_golden() {
		
		double n = rectangle_perimeter() / left;
		double m = rectangle_perimeter() / top;
		double o = rectangle_perimeter() / bottom;
		double p = rectangle_perimeter() / right;
		
		if (n == m || o == p ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Runs a few checks for rhombus status and then calculates the area
	 * using one of several methods depending on variable data allocation
	 *  
	 * @return
	 */
	public static double rhombus_area() {
		
		double area = 0;

		double p = 0;
		
		double[] top_left_angle_coords = new double[2];
		double[] bottom_right_angle_coords = new double[2];

		double q = 0;
		
		double[] top_right_angle_coords = new double[2];
		double[] bottom_left_angle_coords = new double[2];
		
		
		if (rhombus() == true && opposite() == true && parallel() == true && height != 0) {
			area = height * top;
		} else if (rhombus() == true && opposite() == true && parallel() == true && height != 0){
			area = height * bottom;
		} else if (rhombus() == true && opposite() == true && parallel() == true && width != 0){
			area = width * left;
		} else if (rhombus() == true && opposite() == true && parallel() == true && height != 0){
			area = width * right;
		} else if (rhombus() == true && opposite() == true && parallel() == true) {
			area = Math.pow(left, 2) * top_left_angle; 
		} else if (rhombus() == true && opposite() == true && parallel() == true) {
			area = Math.pow(top, 2) * top_right_angle;
		} else if (rhombus() == true && opposite() == true && parallel() == true) {
			area = Math.pow(right, 2) * bottom_right_angle;
		} else if (rhombus() == true && opposite() == true && parallel() == true) {
			area = Math.pow(bottom, 2) * bottom_left_angle;
		} else if (rhombus() == true && opposite() == true && parallel() == true && Distance.getPoint_2() != null && Distance.getPoint_2b() != null ){
				
			if (top_left_angle_x > 0 && top_left_angle_y > 0 && bottom_right_angle_x > 0 && bottom_right_angle_y > 0) {
			
				top_left_angle_coords[0] = top_left_angle_x;
				top_left_angle_coords[1] = top_left_angle_y;
				
				bottom_right_angle_coords[0] = bottom_right_angle_x;
				bottom_right_angle_coords[1] = bottom_right_angle_y;
				
				Distance.setPoint_2(top_left_angle_coords);
				Distance.setPoint_2b(bottom_right_angle_coords);
				
				p = Distance.two_d_distance();
			}
			
			if (top_right_angle_x > 0 && top_right_angle_y > 0 && bottom_left_angle_x > 0 && bottom_left_angle_y > 0) {
				top_right_angle_coords[0] = top_right_angle_x;
				top_right_angle_coords[1] = top_right_angle_y;
				
				bottom_left_angle_coords[0] = bottom_left_angle_x;
				bottom_left_angle_coords[1] = bottom_left_angle_y;
				
				Distance.setPoint_2(top_right_angle_coords);
				Distance.setPoint_2b(bottom_left_angle_coords);
				
				q = Distance.two_d_distance();
			}
			
			area = (p * q) / 2;
		}
		
		return area;
	}
	
	/**
	 * Runs a check for rhombus status and then calculates the perimeter
	 * @return
	 */
	public static double rhombus_perimeter() {
		double perimeter = 0;
		
		if (rhombus() == true) {
			try {
				perimeter = top + bottom + left + right;
			} catch (ArithmeticException A) {
				System.err.println(A);
			} finally {
				System.out.println("Make sure all of the sides are equal and have a size allocated, or allocate a value to just top");
			}
		} else if (rhombus() == true && top != 0) {
			try {
				perimeter = Math.pow(top, 4);
			} catch (ArithmeticException A) {
				System.err.println(A);
			} finally {
				System.out.println("Make sure top has a size allocated, or all of the sides are equal and have a size allocated");
			}
		}
		
		return perimeter;
	}
	
	
	
	public static double getTop() {
		return top;
	}
	public static void setTop(double top) {
		Quadrilaterals.top = top;
	}
	public static double getBottom() {
		return bottom;
	}
	public static void setBottom(double bottom) {
		Quadrilaterals.bottom = bottom;
	}
	public static double getLeft() {
		return left;
	}
	public static void setLeft(double left) {
		Quadrilaterals.left = left;
	}
	public static double getRight() {
		return right;
	}
	public static void setRight(double right) {
		Quadrilaterals.right = right;
	}
	
	public static double getHeight() {
		return height;
	}

	public static void setHeight(double height) {
		Quadrilaterals.height = height;
	}
	
	public static double getWidth() {
		return width;
	}

	public static void setWidth(double width) {
		Quadrilaterals.width = width;
	}

	public static double getTop_left_angle() {
		return top_left_angle;
	}

	public static void setTop_left_angle(double top_left_angle) {
		Quadrilaterals.top_left_angle = top_left_angle;
	}

	public static double getBottom_left_angle() {
		return bottom_left_angle;
	}

	public static void setBottom_left_angle(double bottom_left_angle) {
		Quadrilaterals.bottom_left_angle = bottom_left_angle;
	}

	public static double getTop_right_angle() {
		return top_right_angle;
	}

	public static void setTop_right_angle(double top_right_angle) {
		Quadrilaterals.top_right_angle = top_right_angle;
	}

	public static double getBottom_right_angle() {
		return bottom_right_angle;
	}

	public static void setBottom_right_angle(double bottom_right_angle) {
		Quadrilaterals.bottom_right_angle = bottom_right_angle;
	}
	
	public static double getTop_left_angle_x() {
		return top_left_angle_x;
	}

	public static void setTop_left_angle_x(double top_left_angle_x) {
		Quadrilaterals.top_left_angle_x = top_left_angle_x;
	}

	public static double getTop_left_angle_y() {
		return top_left_angle_y;
	}

	public static void setTop_left_angle_y(double top_left_angle_y) {
		Quadrilaterals.top_left_angle_y = top_left_angle_y;
	}

	public static double getBottom_right_angle_x() {
		return bottom_right_angle_x;
	}

	public static void setBottom_right_angle_x(double bottom_right_angle_x) {
		Quadrilaterals.bottom_right_angle_x = bottom_right_angle_x;
	}

	public static double getBottom_right_angle_y() {
		return bottom_right_angle_y;
	}

	public static void setBottom_right_angle_y(double bottom_right_angle_y) {
		Quadrilaterals.bottom_right_angle_y = bottom_right_angle_y;
	}

	public static double getTop_right_angle_x() {
		return top_right_angle_x;
	}

	public static void setTop_right_angle_x(double top_right_angle_x) {
		Quadrilaterals.top_right_angle_x = top_right_angle_x;
	}

	public static double getTop_right_angle_y() {
		return top_right_angle_y;
	}

	public static void setTop_right_angle_y(double top_right_angle_y) {
		Quadrilaterals.top_right_angle_y = top_right_angle_y;
	}

	public static double getBottom_left_angle_x() {
		return bottom_left_angle_x;
	}

	public static void setBottom_left_angle_x(double bottom_left_angle_x) {
		Quadrilaterals.bottom_left_angle_x = bottom_left_angle_x;
	}

	public static double getBottom_left_angle_y() {
		return bottom_left_angle_y;
	}

	public static void setBottom_left_angle_y(double bottom_left_angle_y) {
		Quadrilaterals.bottom_left_angle_y = bottom_left_angle_y;
	}
}
