package ua.com.foxminded.yuriy.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerDivison {

	private String emptyString = "";
	private String space = " ";
	private String middleLine = "-";
	private String underScore = "_";
	private String verticalLine = " | ";
	private String newLine = "\n";
	private StringBuilder divisionResult = new StringBuilder();
	private List<String> quotientList = new ArrayList<>();
	private List<String> dividendList = new ArrayList<>();
	
	public String LongDivision(int dividend, int divisor) {
		
		// Checking for invalid input

		if (divisor == 0) {
			throw new IllegalArgumentException("Divisor cant be zero.");
		}
		if (divisor > dividend) {
			throw new IllegalArgumentException("Divident should be bigger than divisor.");
		}
	
		// Filling created arrays with digits by ""

		quotientList.addAll(Arrays.asList(String.valueOf(dividend / divisor).split(emptyString)));
		dividendList.addAll(Arrays.asList(String.valueOf(dividend).split(emptyString)));
		
		divisionBody(dividend, divisor);
		centralIteration(divisor);
		
		return divisionResult.toString();

		
	}

	private StringBuilder starterDividend(int divisor) {

		StringBuilder tmpBuilder = new StringBuilder();
		for (String s : dividendList) {
			tmpBuilder.append(s);
			if (Integer.parseInt(tmpBuilder.toString()) >= divisor) {
				break;
			}
		}
		return tmpBuilder;
	}

	private void divisionBody(int dividend, int divisor) {

		// Determining stater Dividend

		StringBuilder dividendToStart = starterDividend(divisor);

		// Creating Spaces Before and After Initial Dividend

		StringBuilder spaceBeforeDividend = new StringBuilder();
		StringBuilder spaceAfterDividend = new StringBuilder();
		StringBuilder regulatoryDash = new StringBuilder();
		StringBuilder dashUnderDividend = new StringBuilder();

		int spaceBeforeLength = 1 + (dividendToStart.toString().length()
				- String.valueOf(Integer.parseInt(quotientList.get(0)) * divisor).length());

		for (int i = 0; i < spaceBeforeLength; i++) {
			spaceBeforeDividend.append(space);
		}

		int spaceAfterLength = dividendList.size() - dividendToStart.toString().length();

		for (int i = 0; i < spaceAfterLength; i++) {
			spaceAfterDividend.append(space);
		}

		int regulatoryDashLength = quotientList.size();

		for (int i = 0; i < regulatoryDashLength; i++) {
			regulatoryDash.append(middleLine);
		}

		int dashUnderDividendLength = String.valueOf(Integer.parseInt(quotientList.get(0)) * divisor).length();

		for (int i = 0; i < dashUnderDividendLength; i++) {
			dashUnderDividend.append(middleLine);
		}

		// Appending process

		divisionResult.append(underScore + dividend + verticalLine + divisor + newLine); // First line
		divisionResult.append(spaceBeforeDividend.toString() + dividendToStart.toString() + spaceAfterDividend.toString()
				+ verticalLine + regulatoryDash + newLine); // Second line
		divisionResult.append(spaceBeforeDividend.toString() + dashUnderDividend.toString()
				+ spaceAfterDividend.toString() + verticalLine + dividend / divisor + newLine); // Third line

	}

	private void centralIteration(int divisor) {

		StringBuilder minuend = starterDividend(divisor);
		int subtrahend = Integer.parseInt(quotientList.get(0)) * divisor;

		// Creating iteration, taking as start reference : actual position of dividend
		// and divisor.

		for (int i = minuend.toString().length(), j = 1; i < dividendList.size(); i++, j++) {
			StringBuilder newMinuend = new StringBuilder();

			// Creating first part of next dividend if difference is not zero

			if (Integer.parseInt(minuend.toString()) - subtrahend != 0) {
				newMinuend.append(Integer.parseInt(minuend.toString()) - subtrahend);
			}

			// Appending next digit

			newMinuend.append(dividendList.get(i));

			// Determining space length space to append before next iteration

			int spaceBeforeLength = i - (newMinuend.length() - 1);
			StringBuilder spaceBefore = new StringBuilder();
			for (int k = 0; k < spaceBeforeLength; k++) {
				spaceBefore.append(space);
			}

			// Enter this iteration if newMinued value is not enough to subtract divisor
			// value.

			while (Integer.parseInt(newMinuend.toString()) < divisor) {

				// If newMinued value was not enough, step up to the next position of dividend
				// list.

				i++;
				if (i >= dividendList.size()) {
					break;
				}

				// Append next digit to the newMinued

				newMinuend.append(dividendList.get(i));

				// Step up the quotient position any time you step up dividend position

				j++;

			}

			divisionResult.append(spaceBefore.toString() + underScore + newMinuend.toString() + newLine); // Next dividend line

			// Determining new subtrahend based on quotient position

			int newSubtrahend = Integer.parseInt(quotientList.get(j)) * divisor;

			divisionResult.append(spaceBefore.toString() + space + newSubtrahend + newLine); // Next subtrahend line
			
			// Determining equal signs to print under subtrahend
			
			StringBuilder equalSign = new StringBuilder();
			StringBuilder positionForRest = new StringBuilder();
			equalSign.setLength(0);
			int equalSignLength = Integer.toString(newSubtrahend).length();

			for (int h = 0; h < equalSignLength; h++) {
				equalSign.append(middleLine);
				positionForRest.append(space);
			}

			divisionResult.append(spaceBefore.toString() + space + equalSign.toString() + newLine); // Next equal sign line
			
			// Setting new parameters to start new iteration with

			minuend = newMinuend;
			subtrahend = newSubtrahend;
			
			// If it is a last iteration print the rest of division
			
			if (i == dividendList.size() - 1) {
				int rest = (Integer.parseInt(minuend.toString()) - subtrahend);
				divisionResult.append(spaceBefore.toString() + positionForRest + rest);
			}

		}

	}
}
