package hackerrank;

/**
 * 
 * @author
 * @score 50/75
 */

//https://stackoverflow.com/questions/2049582/how-to-determine-if-a-point-is-in-a-2d-triangle
public class Triangle_Result {
	

	public static int pointsBlong(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {

		Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3);
		if (!area(x1, y1, x2, y2, x3, y3)) {
			return 0;
		} else if (triangle.contains(xp, yp) && !triangle.contains(xq, yq)) {
			return 1;
		} else if (!triangle.contains(xp, yp) && triangle.contains(xq, yq)) {
			return 2;
		} else if (triangle.contains(xp, yp) && triangle.contains(xq, yq)) {
			return 3;
		} else if (!triangle.contains(xp, yp) && !triangle.contains(xq, yq)) {
			return 4;
		}
		return yq;

	}

	private static boolean area(int x1, int y1, int x2, int y2, int x3, int y3) {
		double ab = Math.abs(x1 - x2);
		double bc = Math.sqrt(Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2));
		double ac = Math.sqrt(Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2));
		return ab + bc > ac && bc + ac > ab && ab + ac > bc;
	}

	static class Triangle {
		private final double x3, y3;
		private final double y23, x32, y31, x13;
		private final double det, minD, maxD;

		Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
			this.x3 = x3;
			this.y3 = y3;
			y23 = y2 - y3;
			x32 = x3 - x2;
			y31 = y3 - y1;
			x13 = x1 - x3;
			det = y23 * x13 - x32 * y31;
			minD = Math.min(det, 0);
			maxD = Math.max(det, 0);

		}

		boolean contains(double x, double y) {
			double dx = x - x3;
			double dy = y - y3;
			double a = y23 * dx + x32 * dy;
			if (a < minD || a > maxD)
				return false;
			double b = y31 * dx + x13 * dy;
			if (b < minD || b > maxD)
				return false;
			double c = det - a - b;
			if (c < minD || c > maxD)
				return false;
			return true;
		}

	}
	
	public static void main(String[] args) {

		// Sample case in question
		// output : 1
		System.out.println(pointsBlong(2,2,7,2,5,4,4,3,7,4));
				
		// Sample case 0
		// output : 0
		System.out.println(pointsBlong(0,0,2,0,4,0,2,0,4,0));
		// Sample case 1
		// output : 1
		System.out.println(pointsBlong(3,1,7,1,5,5,3,1,0,0));
		 
		// Sample case 2
		// output : 2
		System.out.println(pointsBlong(3,1,7,1,5,5,1,1,4,3));
		 
		// Sample case 3
		// output : 3
		System.out.println(pointsBlong(3,1,7,1,5,5,5,2,6,3));
		
		// Sample case 4
		// output : 4
		System.out.println(pointsBlong(3,1,7,1,5,5,1,1,2,2));
		
	}

}