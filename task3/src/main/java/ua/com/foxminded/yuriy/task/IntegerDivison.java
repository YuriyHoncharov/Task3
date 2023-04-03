package ua.com.foxminded.yuriy.task;

public class IntegerDivison {

	public static void LongDivision(int divident, int divisor) {

		// Basic Variables
		int quotient = divident / divisor;
		String numDivident = Integer.toString(divident);
		String numDivisor = Integer.toString(divisor);
		String space = " ";
		String middleLine = "-";
		String underScore = "_";
		char newLine = '\n';
		
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
			regulatorySpace.append(space);
			regulatoryDash.append(middleLine);
		}

		for (int i = 0; i < divisorArray.length; i++) {
			equalSign.append(middleLine);
		}

		// Body of the Integer Division

		
		
		divisionResult.append(underScore + divident + " | " + divisor + newLine);
		divisionResult.append(space + (divisor * quotientArray[0]) + regulatorySpace + " | " + regulatoryDash + newLine);
		divisionResult.append(space + equalSign + regulatorySpace + " | " + quotient + newLine);

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
			divisionResult.append(underScore);
			divisionResult.append(tmpDivident);
			int tmpDivisor = (divisor * quotientArray[dividentPosition]);
			variableSpace.append(space);
			divisionResult.append(newLine);
			divisionResult.append(variableSpace);
			divisionResult.append(tmpDivisor);
			divisionResult.append(newLine).append(variableSpace).append(equalSign).append(equalSign);
			divisionResult.append(newLine);
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
