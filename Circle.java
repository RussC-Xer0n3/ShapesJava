package ShapesJava;

public class Circle {

	private static double rad = 0;
	
	public Object circle (double rad) {
		return Math.PI * Math.pow(rad, 2);
	}
	
	public double circle_area (double rad) {
		return Math.PI * Math.pow(rad, 2);
	}
	
	public double circle_circumference (double rad) {
		return Math.PI * rad;
	}
	
	public static double getRad() {
		return rad;
	}
	
	public void setRad(double rad) {
		Circle.rad = rad;
	}	
}


