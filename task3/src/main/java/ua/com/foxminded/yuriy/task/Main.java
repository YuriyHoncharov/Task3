package ua.com.foxminded.yuriy.task;

public class Main {

	public static void main(String[] args) {

		System.out.println("Enter the divident.");
		int divident = InputReader.readInt();

		System.out.println("Enter the divisor.");
		int divisor = InputReader.readInt();

		IntegerDivison.LongDivision(divident, divisor);

	}
}
