package ShapesJava;

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
	
	private static double top_left_angle;
	private static double bottom_left_angle;
	private static double top_right_angle;
	private static double bottom_right_angle;
	
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
		
		if (quadrilateral() == true && all_sides_equal() == true && all_angles_equal() == true) {
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
		
		if (quadrilateral() == true && top_left_angle < 90 && bottom_left_angle > 90 && top_right_angle > 90 && bottom_right_angle < 90) {
			return true;
		} else if (quadrilateral() == true && top_left_angle > 90 && bottom_left_angle < 90 && top_right_angle < 90 && bottom_right_angle > 90) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Checks if the quadrilateral is an irregular trapezium
	 * @return
	 */
	public static boolean trapezium() {
		
		if (quadrilateral() == true && all_sides_equal() == false && all_angles_equal() == false && two_angles_equal() == false && top != bottom && left != right) {
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
		
		if (quadrilateral() == true && all_sides_equal() == false && all_angles_equal() == false && two_angles_equal() == true) {
			if (bottom_right_angle == bottom_left_angle && top_right_angle == top_left_angle && left == right) {
				return true;
			}
			return true;
		} else if (quadrilateral() == true && all_sides_equal() == false && all_angles_equal() == false && two_angles_equal() == true) {
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
	 * Provides the diagonal of the rectangle after running the quadrilateral and rectangle checks
	 * @return
	 */
	public static double rectangle_diagonal() { 
		double diagonal = 0;
		
		if (quadrilateral() == true && rectangle() == true) {
			diagonal = Math.sqrt(Math.pow(left, 2) + Math.pow(bottom, 2));
		}
		
		return diagonal;
	}
	
	/**
	 * Provides the area of the square after running the quadrilateral and square checks
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
		
		if (quadrilateral() == true && square() == true) {
			perimeter = Math.pow(left, 2) + Math.pow(bottom, 2);
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
	public static double getTop_angle() {
		return top_left_angle;
	}
	public static void setTop_angle(double top_angle) {
		Quadrilaterals.top_left_angle = top_angle;
	}
	public static double getBottom_angle() {
		return bottom_left_angle;
	}
	public static void setBottom_angle(double bottom_angle) {
		Quadrilaterals.bottom_left_angle = bottom_angle;
	}
	public static double getLeft_angle() {
		return top_right_angle;
	}
	public static void setLeft_angle(double left_angle) {
		Quadrilaterals.top_right_angle = left_angle;
	}
	public static double getRight_angle() {
		return bottom_right_angle;
	}
	public static void setRight_angle(double right_angle) {
		Quadrilaterals.bottom_right_angle = right_angle;
	}
	
}
