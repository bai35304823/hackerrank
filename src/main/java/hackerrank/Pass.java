package hackerrank;

public class Pass {
 public static void main(String [] args) {
 int x = 5;
 Pass p = new Pass();
 p.doStuff(x);
 test("four");
 }

 void doStuff(int x) {
 System.out.print(" doStuff x = " + x++);
 }

 
 public static void test(String str) {
 int check = 4;
 if (check == str.length()) {
 System.out.print(str.charAt(check -= 1) +", ");
} else {
System.out.print(str.charAt(0) + ", ");
 }
 } 
}