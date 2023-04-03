package ua.com.foxminded.yuriy.task;

public class IntegerDivison {

	public static void LongDivision(int dividend, int divisor) {

		// Basic Variables
		int quotient = dividend / divisor;
		String numDividend = Integer.toString(dividend);
		String numDivisor = Integer.toString(divisor);
		String space = " ";
		String middleLine = "-";
		String underScore = "_";
		char newLine = '\n';
		
		// Temporary Variables

		String tmpStringQuotient = Integer.toString(quotient);
		String tmpStringDividend = Integer.toString(dividend);
		String tmpStringDivisor = Integer.toString(divisor);

		// Creating int [] array of variables above

		int[] quotientArray = new int[tmpStringQuotient.length()];
		int[] dividendArray = new int[tmpStringDividend.length()];
		int[] divisorArray = new int[tmpStringDivisor.length()];

		for (int i = 0; i < tmpStringQuotient.length(); i++) {
			quotientArray[i] = Character.getNumericValue(tmpStringQuotient.charAt(i));
		}
		for (int i = 0; i < tmpStringDividend.length(); i++) {
			dividendArray[i] = Character.getNumericValue(tmpStringDividend.charAt(i));
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

		
		
		for (int i = 0; i < dividendArray.length - divisorArray.length; i++) {
			regulatorySpace.append(space);
			regulatoryDash.append(middleLine);
		}

		for (int i = 0; i < divisorArray.length; i++) {
			equalSign.append(middleLine);
		}

		// Body of the Integer Division

		
		
		divisionResult.append(underScore + dividend + " | " + divisor + newLine);
		divisionResult.append(space + (divisor * quotientArray[0]) + regulatorySpace + " | " + regulatoryDash + newLine);
		divisionResult.append(space + equalSign + regulatorySpace + " | " + quotient + newLine);

		// First Iteration to Start

		String tmpNumberToSubtract = "";
		
		for (int i = 0; i < divisorArray.length; i++) {
			tmpNumberToSubtract += dividendArray[i];
			if (Integer.parseInt(tmpNumberToSubtract) < divisor) {
				tmpNumberToSubtract += dividendArray[i+1];
			}
		}

		int initialNumberToSubtract = Integer.parseInt(tmpNumberToSubtract);
		int resultBeforeStartIteration = initialNumberToSubtract - divisor * quotientArray[0];
		int dividendPosition = tmpNumberToSubtract.length();
		int divisorPosition = 1;

		// Main Iteration

		for (int i = 1; i < dividendArray.length - 1; i++) {
			String tmpCreateDividend = (Integer.toString(resultBeforeStartIteration) + dividendArray[dividendPosition]);
			int tmpDividend = Integer.parseInt(tmpCreateDividend);
			divisionResult.append(underScore);
			divisionResult.append(tmpDividend);
			int tmpDivisor = (divisor * quotientArray[divisorPosition]);
			variableSpace.append(space);
			divisionResult.append(newLine);
			divisionResult.append(variableSpace);
			divisionResult.append(tmpDivisor);
			divisionResult.append(newLine).append(variableSpace).append(equalSign).append(equalSign);
			divisionResult.append(newLine);
			divisionResult.append(variableSpace);
			//divisionResult.append(equalSign);
			resultBeforeStartIteration = tmpDividend - tmpDivisor;
			dividendPosition++;
			divisorPosition++;
			if (dividendPosition == dividendArray.length) {
				divisionResult.append(resultBeforeStartIteration);
			}
			
		}

		System.out.println(divisionResult.toString());
	}
}
