package ua.com.foxminded.yuriy.task;

public class Main {

	public static void main(String[] args) {

		System.out.println("Enter the dividend.");
		int dividend = InputReader.readInt();

		System.out.println("Enter the divisor.");
		int divisor = InputReader.readInt();

		IntegerDivision longDivision = new IntegerDivision();
		String result = longDivision.LongDivision(dividend, divisor);
		System.out.println(result);
		
		

	}
}
