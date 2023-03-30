package ua.com.foxminded.yuriy.task;

public class IntegerDivison {

	public static void LongDivision(int divident, int divisor) {

		// Basic Variables
		int quotient = divident / divisor;
		String numDivident = Integer.toString(divident);
		String numDivisor = Integer.toString(divisor);

		// Temporary Variables

		String tmpStringQuotient = Integer.toString(quotient);
		String tmpStringDivident = Integer.toString(divident);
		String tmpStringDivisor = Integer.toString(divisor);

		// Creating int [] array of variables above

		int[] quotientArray = new int[tmpStringQuotient.length()];
		int[] dividentArray = new int[tmpStringDivident.length()];
		int[] divisorArray = new int[tmpStringDivisor.length()];

		for (int i = 0; i < tmpStringQuotient.length(); i++) {
			quotientArray[i] = Character.getNumericValue(tmpStringQuotient.charAt(i));
		}
		for (int i = 0; i < tmpStringDivident.length(); i++) {
			dividentArray[i] = Character.getNumericValue(tmpStringDivident.charAt(i));
		}
		for (int i = 0; i < tmpStringDivisor.length(); i++) {
			divisorArray[i] = Character.getNumericValue(tmpStringDivisor.charAt(i));
		}

		// StringBuilders for printing result

		StringBuilder divisionResult = new StringBuilder();
		StringBuilder equalSign = new StringBuilder();
		StringBuilder regulatorySpace = new StringBuilder();
		StringBuilder regulatoryDash = new StringBuilder();
		StringBuilder variableSpace = new StringBuilder();

		for (int i = 0; i < dividentArray.length - divisorArray.length; i++) {
			regulatorySpace.append(" ");
			regulatoryDash.append("-");
		}

		for (int i = 0; i < divisorArray.length; i++) {
			equalSign.append("-");
		}

		// Body of the Integer Division

		divisionResult.append("_" + divident + " | " + divisor + '\n');
		divisionResult.append(" " + (divisor * quotientArray[0]) + regulatorySpace + " | " + regulatoryDash + '\n');
		divisionResult.append(" " + equalSign + regulatorySpace + " | " + quotient + '\n');

		// First Iteration to Start

		String tmpNumberToSubtract = "";

		for (int i = 0; i < divisorArray.length; i++) {
			tmpNumberToSubtract += dividentArray[i];
		}

		int initialNumberToSubtract = Integer.parseInt(tmpNumberToSubtract);
		int resultBeforeStartIteration = initialNumberToSubtract - divisor;
		int dividentPosition = tmpNumberToSubtract.length();
		int divisorPosition = 1;

		// Main Iteration

		for (int i = 1; i < dividentArray.length; i++) {
			String tmpCreateDivident = (Integer.toString(resultBeforeStartIteration) + dividentArray[dividentPosition]);
			int tmpDivident = Integer.parseInt(tmpCreateDivident);
			divisionResult.append("_");
			divisionResult.append(tmpDivident);
			int tmpDivisor = (divisor * quotientArray[dividentPosition]);
			variableSpace.append(" ");
			divisionResult.append('\n');
			divisionResult.append(variableSpace);
			divisionResult.append(tmpDivisor);
			divisionResult.append('\n').append(variableSpace).append(equalSign).append(equalSign);
			divisionResult.append('\n');
			divisionResult.append(variableSpace);
			//divisionResult.append(equalSign);
			resultBeforeStartIteration = tmpDivident - tmpDivisor;
			dividentPosition++;
			divisorPosition++;
			if (dividentPosition == dividentArray.length) {
				divisionResult.append(resultBeforeStartIteration);
			}
			
		}

		System.out.println(divisionResult.toString());
	}
}
