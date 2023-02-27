package ShapesJava;

//import Coordinates.Coordinates;

public class Triangle {
	
	//For generic Triangles
	private static double adjacent;
	private static double opposite;
	private static double hypotenuse;
	
	//Our Angles
	private static double angle_A;
	private static double angle_H;
	private static double angle_O;
	
	//Start allocating our variables strictly
	static double H = Triangle.setHypotenuse(Triangle.getHypotenuse());
	static double O = Triangle.setOpposite(Triangle.getOpposite());
	static double A = Triangle.setAdjacent(Triangle.getAdjacent());
	
	static double sin_H = Triangle.setAngle_H(Math.sin(Triangle.getAngle_H()));
	static double sin_O = Triangle.setAngle_O(Math.sin(Triangle.getAngle_O()));
	static double sin_A = Triangle.setAngle_A(Math.sin(Triangle.getAngle_A()));

	/**
	 * Just check if we add up to 180 degrees inside the triangle
	 * @return
	 */
	public static boolean angle_sum () {
		
		if (angle_A + angle_H + angle_O == 180.0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calculate the last remaining angle based on two provided
	 */
	public static void last_angle() {
		
		if (angle_sum() == false && sin_O == 0) {
			Triangle.setAngle_O(sin_H + sin_A - 180);
		} else if (angle_sum() == false && sin_A == 0) {
			Triangle.setAngle_A(sin_H + sin_O - 180);
		} else {
			Triangle.setAngle_H(sin_A + sin_O - 180);
		}
	}
	
	/**
	 * Calculate the total perimeter of irregular triangle
	 * @return perimeter
	 */
	public static double triangle_perim() {
		
		double perim = 0.0;
				
		if (adjacent != 0 && opposite != 0 && hypotenuse != 0) {
			perim = (adjacent + opposite + hypotenuse);
		}
		
		return perim;
	}
	
	/**
	 * Attempt to write out the sine laws as a process irrespective of missing data
	 * @reference https://mathsisfun.com/algebra/trig-sine-law.html 2023
	 */
	public static void sine_laws() {
				
		double HH = H / sin_H;
		double OO = O / sin_O;
		double AA = A / sin_A;
		
		if (H == 0 || O == 0 || A == 0) {
			Triangle.setHypotenuse(AA * sin_H);
			Triangle.setAdjacent(OO * sin_A);
			Triangle.setOpposite(HH * sin_O);
		}
		
		//FOR UNKNOWN ANGLES
		
		//Reference: https://mathsisfun.com/algebra/trig-sine-law.html
		if (angle_sum() == false) {
			
			sin_A *= H;
			sin_H *= O;
			sin_O *= A;
			Triangle.setAngle_A(Math.pow(sin_A, Math.exp(-1)));
			Triangle.setAngle_H(Math.pow(sin_H, Math.exp(-1)));
			Triangle.setAngle_O(Math.pow(sin_O, Math.exp(-1)));
		}
	}
	
	/**
	 * Attempt to write out the sine laws as a process irrespective of missing data
	 * @reference https://mathsisfun.com/algebra/trig-cosine-law.html 2023
	 */
	public static void cosine_laws() {
		
		Triangle.setHypotenuse(Math.sqrt(Math.pow(A, 2.0) + Math.pow(O, 2.0) - 2 * A * O * Math.cos(sin_A)));
		Triangle.setOpposite(Math.sqrt(Math.pow(A, 2.0) + Math.pow(H, 2.0) - 2 * A * H * Math.cos(sin_H)));
		Triangle.setAdjacent(Math.sqrt(Math.pow(H, 2.0) + Math.pow(O, 2.0) - 2 * H * O * Math.cos(sin_O)));
	}
	
	
	/**
	 * Returns true if the opposing side or angle is zero to the other
	 * H and sin_H are opposing if one is zero and the other not, they are between
	 */
	public static boolean between () {
		
		if (one_sides() == true && one_angles() == true) {
			
			if (H != 0 && sin_O != 0 || H != 0 && sin_A != 0) {
				return true;
			} else if (A != 0 && sin_H != 0 || A != 0 && sin_O != 0) {
				return true;
			} else if (O != 0 && sin_H != 0 || O != 0 && sin_A != 0) {
				return true;
			}
		
		} else if (one_sides() == true && two_angles() == true) {
			
			if (H != 0 && sin_O != 0 && sin_A != 0) {
				return true;
			} else if (A != 0 && sin_H != 0 && sin_O != 0) {
				return true;
			} else if (O != 0 && sin_H != 0 && sin_A != 0) {
				return true;
			}
		
		} else if (two_sides() == true && one_angles() == true) {
			
			if (H != 0 && A != 0 && sin_O != 0) {
				return true;
			} else if (A != 0 && O != 0 && sin_H != 0) {
				return true;
			} else if (O != 0 && H != 0 && sin_A != 0) {
				return true;
			}
			
		} else if (two_sides() == true && two_angles() == true) {

			if (H != 0 && sin_A != 0 && sin_O != 0) {
				return true;
			} else if (A != 0 && sin_O != 0 && sin_H != 0) {
				return true;
			} else if (O != 0 && sin_H != 0 && sin_A != 0) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * Check if there are three sides of measurements
	 * @return
	 */
	public static boolean three_sides() {
		
		if(H != 0 && O != 0 && A != 0) { 
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Check if there are two sides of measurements
	 * @return
	 */
	public static boolean two_sides() {

		if (H != 0 && O != 0 && A == 0) {
			return true;
		} else if (H != 0 && O == 0 && A != 0) {
			return true;
		} else if (H == 0 && O != 0 && A != 0) { 
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if there is at least one side of measurement
	 * @return
	 */
	public static boolean one_sides() {

		if (H != 0 && O == 0 && A == 0) {
			return true;
		} else if (H == 0 && O != 0 && A == 0) {
			return true;
		} else if (H == 0 && O == 0 && A != 0) { 
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if there are three angles of measurement
	 * @return
	 */
	public static boolean three_angles() {
		
		if(sin_H != 0 && sin_O != 0 && sin_A != 0) { 
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Check if there are two angles of measurement
	 * @return
	 */
	public static boolean two_angles() {

		if (sin_H != 0 && sin_O != 0 && sin_A == 0) {
			return true;
		} else if (sin_H != 0 && sin_O == 0 && sin_A != 0) {
			return true;
		} else if (sin_H == 0 && sin_O != 0 && sin_A != 0) { 
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if there is at least one angle of measurement
	 * @return
	 */
	public static boolean one_angles() {

		if (sin_H != 0 && sin_O == 0 && sin_A == 0) {
			return true;
		} else if (sin_H == 0 && sin_O != 0 && sin_A == 0) {
			return true;
		} else if (sin_H == 0 && sin_O == 0 && sin_A != 0) { 
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Investigates only having the all three angles
	 */
	public static void AAA() {
		
		//Coordinates coords = new Coordinates();
		
		/*RETRIANGULATION*/
		
		//try{
		//	Geographics.triangulate();
		//} catch (MathematicalException ME) {
		//	System.err.println("Cannot triangulate" + ME);
		//} finally {
		//	Geographics.retriangulate();
		//}
		
		//Set my message coords and lkl and lkv
		//double x = coords.getX();
		//double coords.getZ();
		//coords.getY();
		
		//Request permissions message
		
		//Set up OAuth sockets and TX ACK RX and message
		
		//Send message requesting Location B coords (Earth, or another satellite)
		
		//Calculate distance and respective distance to an angle and distance reporter
		
		//Run solve()
		
		//Update details
		
		//Send new message with new coordinates, velocity and angles
		
		//ALTERNATIVELY
		
		//GET THE ORIGIN of one angle and make a line, place the bisection at the angle and solve using heron of alex
	}
	
	/**
	 * Solves the Two Angles and a Side not between
	 */
	public static void AAS() {
		last_angle();
		sine_laws();
	}

	/**
	 * Solves the Two Angles and a Side between
	 */
	public static void ASA() {
		last_angle();
		sine_laws();
	}
	
	/**
	 * Solves the Two Sides and an Angle between
	 */
	public static void SAS() {
		cosine_laws();
		sine_laws();
		last_angle();
	}
	
	/**
	 * Solves the Two Sides and an Angle not between
	 */
	public static void SSA() {
		sine_laws();
		last_angle();
		sine_laws();
	}
	
	/**
	 * Solves the Three Sides only
	 */
	public static void SSS() {
		cosine_laws();
		sine_laws();
	}
	
	/**
	 * Attempt to solve all angles and edges from few
	 */
	public static void solve () {
		
		if (two_angles() == true && between() == false && one_sides() == true) {

			AAS();
			
		} else if ( two_angles() == true && between() == true && one_sides() == true) {
			
			ASA();

		} else if (one_angles() == true && between() == true && two_sides() == true) {
			
			SAS();

		} else if (one_angles() == true && between() == false && two_sides() == true) {
			
			SSA();

		} else if (three_sides() == true && three_angles() == false) {
			
			SSS();

		} else {
		
			System.err.println("Impossible to solve AAA without at least one length or all variables are NULL");
		
		}
	}
	
	/**
	 * Change settings for a triangle set based on your own measurements
	 * angle_Aadjacent && opposite > 0 
	 * angle_Hypotenuse && adjacent > 0
	 * angle_Opposite && hypotenuse > 0
	 */
	public static void get_Triangle () {
		
			try {
				if (angle_A == 60 && opposite > 0 || angle_H == 60 && adjacent > 0 || angle_O == 60 && hypotenuse > 0) {
					solve();
					equilateral_check();
				} else if (angle_A == 90 && opposite > 0 || angle_H == 90 && adjacent > 0 || angle_O == 90 && hypotenuse > 0) {
					solve();
				} else {
					try {
						solve();
					} catch (NullPointerException N) {
						System.err.print(N);
					} finally {
						System.err.println("Must set the angle and at least one opposing length");
					}
				}
				
			} catch (NullPointerException N) {
				System.err.print(N);
			} finally {
				System.err.println("Must set the angle and at least one opposing length");
			}
	}

	/**
	 * Heron of ALEXANDRIA
	 * Calculate the area of any non-right angled and non-equilateral triangle
	 * 
	 * @reference Bedside book of Algebra - Michael Willers - 2009
	 * 
	 * @return area
	 */
	public static double heron_of_alex() {
		double area = 0;
		//Force the error when we check divide by zero
		try {
			solve();
		} catch (ArithmeticException A) {
			
			System.err.println("Have to have all three components of the triangle: " + A);
			
		} catch (NullPointerException E) {
			
			System.err.println("Have to have all three components of the triangle: " + E);
			
		} finally {
			
			double s = (adjacent + opposite + hypotenuse) / 2.0;
			
			area = Math.sqrt(s * (s - adjacent) * (s - opposite) * (s - hypotenuse));			
		}
		
		return area;
	}
	
	/**
	 * Assign the correct edge value according to two measurements of 
	 * a right angled triangle.
	 * @return edge
	 */
	public static void right_triangle_edges () {
		
		if (adjacent == 0 && opposite == 0 && hypotenuse == 0) {
			//Force the error because we know all are empty
			try {
				adjacent /= opposite / hypotenuse;
			} catch (ArithmeticException A) {
				System.err.println("Cannot accept 0 because cannot create triangle, need at least two measurements: " + A);
			} finally { solve(); }
				
		} else if (adjacent != 0 && opposite != 0 && hypotenuse == 0) {
			Triangle.setHypotenuse(Math.sqrt(Math.pow(adjacent, 2.0) + Math.pow(adjacent, 2.0)));
		} else if (adjacent != 0 && opposite == 0 && hypotenuse != 0) {
			Triangle.setOpposite((Math.pow(hypotenuse, 2.0) +  adjacent) / 3.0);
		} else if (adjacent == 0 && opposite != 0 && hypotenuse != 0) {
			Triangle.setAdjacent(Math.pow(hypotenuse, 2.0) / 8.0);
		} 
	}
	
	/**
	 * Calculate the area of a right angled triangle
	 * @return area
	 */
	public static double right_triangle_area() {

		double area = 0;

		if (adjacent == 0 || opposite == 0 || hypotenuse == 0) {

			try {

				right_triangle_edges();

			} catch (ArithmeticException A) {

				System.err.println(A);

			} catch (NullPointerException E) {

				System.err.println(E);

			} finally {

				solve();

			}

			area = Math.pow(adjacent, opposite) / 2;

		}

		return area;
	}
	
	/**
	 * check edges & angles
	 * @return
	 */
	public static boolean equilateral_check() {

		double sum = (angle_A + angle_H + angle_O) / 3;

		if (adjacent != 0 && opposite != 0 && hypotenuse != 0) {
			
			if (adjacent == hypotenuse && opposite == hypotenuse && angle_sum() == true && sum == 60) {
				return true;
			} else {
				return false;
			}
			
		} else if (adjacent != 0 || opposite != 0 || hypotenuse != 0){
			
			if (adjacent == hypotenuse && opposite == hypotenuse && angle_sum() == true && sum == 60) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	/**
	 * Calculate the total perimeter of equilateral triangle
	 * @return perimeter
	 */
	public static double e_triangle_perim() {

		boolean equilateral = equilateral_check();
		
		double e_perim = 0.0;
		
		if (equilateral == true) {
			e_perim = (adjacent + opposite + hypotenuse);
		}
		
		return e_perim;
	}
	
	/**
	 * Calculate the area of an equilateral triangle after
	 * running through the solve and checks.
	 * @return
	 */
	public static double equilateral_area() {
		
		double area = 0;
		solve();
		equilateral_check();
		
		try {
		
			return heron_of_alex();
		
		} catch (ArithmeticException A){

			System.err.println(A);
		
		} catch (NullPointerException E) {
		
			System.err.println(E);
		
		} finally {
		
			area = heron_of_alex();
			
		}
		
		return area;
	}
	
	public static double getAdjacent() {
		return adjacent;
	}

	public static double setAdjacent(double adjacent) {
		return Triangle.adjacent = adjacent;
	}

	public static double getOpposite() {
		return opposite;
	}

	public static double setOpposite(double opposite) {
		return Triangle.opposite = opposite;
	}

	public static double getHypotenuse() {
		return hypotenuse;
	}

	public static double setHypotenuse(double hypotenuse) {
		return Triangle.hypotenuse = hypotenuse;
	}

	public static double getAngle_A() {
		return angle_A;
	}

	public static double setAngle_A(double angle_A) {
		return Triangle.angle_A = angle_A;
	}

	public static double getAngle_H() {
		return angle_H;
	}

	public static double setAngle_H(double angle_B) {
		return Triangle.angle_H = angle_B;
	}

	public static double getAngle_O() {
		return angle_O;
	}

	public static double setAngle_O(double angle_C) {
		return Triangle.angle_O = angle_C;
	}

}
