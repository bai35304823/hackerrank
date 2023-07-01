package hackerrank;

public class ExceptionFun {
	  public static void main(String[] args) {
		  Author a = new Author();
		  changeShirtColor(a, "B");       
	}
	  
	  public static Author changeShirtColor(Author theShirt, String color) {     
	        theShirt.setColorCode(color);
		theShirt = new Author();
		return theShirt;
	    }
}
