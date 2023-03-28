package ua.com.foxminded.yuriy.task;

public class IntegerDivison {

	public static void LongDivision(int divident, int divisor) {

		int quotient = divident / divisor;

		String numDivident = Integer.toString(divident);
		String numDivisor = Integer.toString(divisor);

		char[] dividentArray = numDivident.toCharArray();
		char[] divisorArray = numDivisor.toCharArray();

		int dividentLength = dividentArray.length;
		StringBuilder leftSpace = new StringBuilder();
		StringBuilder regulatorySpace = new StringBuilder();
		StringBuilder regulatoryDash = new StringBuilder();

		for (int i = 0; i < dividentLength - divisorArray.length; i++) {
			regulatorySpace.append(" ");
			regulatoryDash.append("-");
		}

		for (int i = 0; i < divisorArray.length; i++) {
			leftSpace.append(" ");
		}
		System.out.println("_" + divident + " | " + divisor);
		System.out.println(" " + divisor + regulatorySpace + " | " + regulatoryDash);
		System.out.println(leftSpace + "-" + regulatorySpace + " | " + quotient);

		for (int i = 0; i < dividentLength - 1; i++) {
			
			int tmpDivident = dividentArray[i];
			int tmpDifference = tmpDivident - divisor;
			int tmpSecondDividentNumber = dividentArray[i + 1];
			
			String tmpStringToMerge = String.valueOf(tmpDifference) + String.valueOf(tmpSecondDividentNumber);
			int dividentNumber = Integer.parseInt(tmpStringToMerge);
			System.out.println("_" + dividentNumber);
			int nextDivisor = ((int) Math.floor(dividentNumber / 4)) * 4;
			System.out.println(leftSpace + "--");

		}

	}

}
