package ua.com.foxminded.yuriy.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerDivision {

	private final String emptyString = "";
	private final String space = " ";
	private final String middleLine = "-";
	private final String underScore = "_";
	private final String verticalLine = " | ";
	private final String newLine = "\n";
	private StringBuilder divisionResult = new StringBuilder();
	private List<String> quotientList = new ArrayList<>();
	private List<String> dividendList = new ArrayList<>();

	public String longDivision(int dividend, int divisor) {

		// Checking for invalid input

		inputCheck(dividend, divisor);

		// Filling created arrays with digits by ""

		quotientList.addAll(Arrays.asList(String.valueOf(dividend / divisor).split(emptyString)));
		dividendList.addAll(Arrays.asList(String.valueOf(dividend).split(emptyString)));

		divisionBody(dividend, divisor);
		centralIteration(divisor);

		return divisionResult.toString();
	}

	private void inputCheck(int dividend, int divisor) {

		if (divisor == 0) {
			throw new IllegalArgumentException("Divisor cant be zero.");
		}
		if (divisor > dividend) {
			throw new IllegalArgumentException("Divident should be bigger than divisor.");
		}
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
	
	private StringBuilder repeat (int timesToRepeat, String signToAppend) {
		
		StringBuilder buildedString = new StringBuilder();
		for (int i = 0; i < timesToRepeat; i++) {
			buildedString.append(signToAppend);
		}
		return buildedString;
	}

	private void divisionBody(int dividend, int divisor) {

		// Determining stater Dividend

		StringBuilder dividendToStart = starterDividend(divisor);

		// Creating Spaces Before and After Initial Dividend

		StringBuilder spaceBeforeDividend = new StringBuilder();
		StringBuilder spaceAfterDividend = new StringBuilder();
		StringBuilder regulatoryDash = new StringBuilder();
		StringBuilder dashUnderDividend = new StringBuilder();

		int spaceBeforeLength = (1
				+ (dividendToStart.length() - String.valueOf(Integer.parseInt(quotientList.get(0)) * divisor).length()));

		spaceBeforeDividend = repeat(spaceBeforeLength, space);

		int spaceAfterLength = dividendList.size() - dividendToStart.toString().length();

		spaceAfterDividend = repeat(spaceAfterLength, space);

		int regulatoryDashLength = quotientList.size();

		regulatoryDash = repeat(regulatoryDashLength, middleLine);

		int dashUnderDividendLength = String.valueOf(Integer.parseInt(quotientList.get(0)) * divisor).length();
		
		dashUnderDividend = repeat(dashUnderDividendLength, middleLine);

		// Appending process

		divisionResult.append(underScore).append(dividend).append(verticalLine).append(divisor).append(newLine); // First line
		divisionResult.append(spaceBeforeDividend.toString()).append(Integer.parseInt(quotientList.get(0)) * divisor)
		.append(spaceAfterDividend.toString()).append(verticalLine).append(regulatoryDash).append(newLine); // Second line
		divisionResult.append(spaceBeforeDividend.toString()).append(dashUnderDividend.toString()).append(spaceAfterDividend.toString()).append(verticalLine)
		.append(dividend / divisor).append(newLine); // Third line
		
		if (quotientList.size() == 1) {
			
			int rest = dividend - (Integer.parseInt(quotientList.get(0)) * divisor);
			StringBuilder positionForRest = new StringBuilder();
			int restPosition = (String.valueOf(Integer.parseInt(quotientList.get(0)) * divisor).length() - String.valueOf(rest).length());
			positionForRest = repeat(restPosition, space);
			divisionResult.append(spaceBeforeDividend).append(positionForRest.toString()).append(rest);
		}
	}

	private void centralIteration(int divisor) {

		StringBuilder minuend = starterDividend(divisor);
		int subtrahend = Integer.parseInt(quotientList.get(0)) * divisor;

		// Creating iteration, taking as start reference : actual position of dividend and divisor.

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
			spaceBefore = repeat(spaceBeforeLength, space);

			// Enter this iteration if newMinued value is not enough to subtract divisor value.

			while (Integer.parseInt(newMinuend.toString()) < divisor) {

				// If newMinued value was not enough, step up to the next position of dividend list.

				i++;
				if (i >= dividendList.size()) {
					break;
				}

				// Append next digit to the newMinued

				newMinuend.append(dividendList.get(i));

				// Step up the quotient position any time you step up dividend position

				j++;

			}

			divisionResult.append(spaceBefore.toString()).append(underScore).append(newMinuend.toString()).append(newLine); // Next dividend line

			// Determining new subtrahend based on quotient position

			int newSubtrahend = Integer.parseInt(quotientList.get(j)) * divisor;

			// Determining the position of new subtrahend based on minuend and subtrahend length

			StringBuilder additionalSpace = new StringBuilder();

			int minuendAndSubtrahendLengthDiff = (newMinuend.toString()).length() - String.valueOf(newSubtrahend).length()	+ 1;

			additionalSpace = repeat(minuendAndSubtrahendLengthDiff, space);

			divisionResult.append(spaceBefore.toString()).append(additionalSpace.toString()).append(newSubtrahend).append(newLine); // Next subtrahend line

			// Determining equal signs to print under subtrahend

			StringBuilder equalSign = new StringBuilder();

			equalSign.setLength(0);
			int equalSignLength = Integer.toString(newSubtrahend).length();

			equalSign = repeat(equalSignLength, middleLine);

			divisionResult.append(spaceBefore.toString()).append(additionalSpace.toString()).append(equalSign.toString()).append(newLine); // Next equal sign line

			// Setting new parameters to start new iteration with

			minuend = newMinuend;
			subtrahend = newSubtrahend;

			// If it is a last iteration print the rest of division

			int rest = (Integer.parseInt(minuend.toString()) - subtrahend);
			StringBuilder positionForRest = new StringBuilder();
			int restPosition = (String.valueOf(subtrahend).length() - String.valueOf(rest).length());

			positionForRest = repeat(restPosition, space);

			if (i == dividendList.size() - 1 || j == quotientList.size() - 1) {

				divisionResult.append(spaceBefore.toString()).append(additionalSpace.toString()).append(positionForRest.toString()).append(rest);
			}
		}
	}
}
