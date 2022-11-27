package hackerrank;

import java.awt.geom.Area;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


//https://stackoverflow.com/questions/2049582/how-to-determine-if-a-point-is-in-a-2d-triangle
public class Triangle_Result {
	public static void main(String[] args) {
		List<Integer> arrw =List.of(1,2,3,4,5,6,7);
		//List<Integer> arrws =List.of(4,1,7,3,8);
		//List c = new ArrayList(arrws);
				//System.out.println(equalizeTeamSize(arrw, 10));
				
				
				//Triangle triangle = new Triangle(3,1,7,1,5,5);
				//System.out.println(triangle.contains(1,1));
						//System.out.println(triangle.contains(4, 3));
		//System.out.println(pointBlong(3,1,7,1,5,5,3,1,0,0));
		//System.out.println(pointBlong(0,0,2,0,4,0,2,0,4,0));
		//System.out.println(pointBlong(3,1,7,1,5,5,1,1,4,3));
		 /* int[][] bidi  = {{3,2},{2,1}};
		  a = Arrays.stream(bidi)
          .map(Arrays::asList)
          .collect(Collectors.toList());*/
		  
		  List<List<Integer>> query = List.of(List.of(3,2), List.of(2,1));
		//System.out.println(getElement(List.of(4,1,2,3,4,5,6,7,8,9,10,11,12), query));
	}

	
	/*
	 * int[][] twoD_arr = new int[arry.size() - 1][lengtg]; for (int i = 0; i <
	 * arry.size() - 1; i++) { for (int j = 0; j < lengtg; j++) { twoD_arr[i][j] =
	 * input[(j*10) + i]; } return arry; }
	 */
	public static int pointBlong(int x1, int y1,int x2, int y2,int x3, int y3,int xp, int yp,int xq, int yq) {
		
		Triangle triangle =  new Triangle(x1, y1,x2,y2,x3,y3);
		if (!area(x1, y1,x2, y2,x3, y3)) {
			return 0;
		} else if (triangle.contains(xp,yp) && !triangle.contains( xq,yq)) {
			return 1;
		} else if (!triangle.contains(xp,yp) && triangle.contains( xq,yq)) {
			return 2;
		}  else if (triangle.contains(xp,yp) && triangle.contains( xq,yq)) {
			return  3;
		} else if (!triangle.contains(xp,yp) && !triangle.contains( xq,yq)) {
			return 4;
		}
		return yq;
		
	}
	
	private static boolean area(int x1, int y1,int x2, int y2,int x3, int y3) {
		double ab = Math.abs(x1 - x2);
		double bc = Math.sqrt(Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2));
		double ac = Math.sqrt(Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2));
		return ab + bc > ac && bc +ac > ab && ab+ac >bc;
	}
	

	 static class  Triangle {
		    private final double x3, y3;
		    private final double y23, x32, y31, x13;
		    private final double det, minD, maxD;
			Triangle(double x1, double y1, double x2, double y2, double x3,
			            double y3) {
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

  



}