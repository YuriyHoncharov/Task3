package ua.com.foxminded.yuriy.task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {

	public static int readInt() {

		Scanner scanner = new Scanner(System.in);
		int num = 0;
		boolean validInput = false;

		while (!validInput) {
			try {
				num = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input. Please enter an integer number.");
				scanner.next();
			}
		}
		return num;
	}

}
