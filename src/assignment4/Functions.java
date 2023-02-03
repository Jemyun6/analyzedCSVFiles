package assignment4;

public class Functions {
	public static void main(String[] args) {
		Functions.printResult();
	}
	
	public static int multiply(int x, int y) {
		int result = x * y;
		return result; 
	}
	
	public static void printResult() {
		int res = Functions.multiply(10, 5);
		System.out.println(res);
	}

}
