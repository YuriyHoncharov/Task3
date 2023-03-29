package ua.com.foxminded.yuriy.task;

public class IntegerDivison {

	public static void LongDivision(int divident, int divisor) {

		int quotient = divident / divisor;

		String numDivident = Integer.toString(divident);
		String numDivisor = Integer.toString(divisor);
		StringBuilder divisionResult = new StringBuilder();

		char[] dividentArray = numDivident.toCharArray();
		char[] divisorArray = numDivisor.toCharArray();

		int[] numericDividentArray = new int[dividentArray.length];
		for (int i = 0; i < dividentArray.length; i++) {
			numericDividentArray[i] = Character.getNumericValue(dividentArray[i]);
		}

		int[] numericDivisorArray = new int[dividentArray.length];

		for (int i = 0; i < divisorArray.length; i++) {
			numericDivisorArray[i] = Character.getNumericValue(divisorArray[i]);
		}

		int divisorLength = divisorArray.length;
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

		StringBuilder tmpDividentToStartIteration = new StringBuilder();
		for (int i = 0; i < divisorLength; i++) {
			tmpDividentToStartIteration.append(dividentArray[i]);
		}
		int tmpDivident = Integer.parseInt(tmpDividentToStartIteration.toString());

		int tmpRemainder = 0;
		int tmpResult = 0;
		int numberToPrint = 0;

		while (tmpDivident >= divisor) {
			tmpDivident = tmpDivident - divisor;
			tmpResult = tmpDivident;
			tmpRemainder++;
			numberToPrint = (tmpDivident / divisor) * divisor;
		}

		divisionResult.append(tmpRemainder);

		// Most probably i'll start there my while iteration for full code.
		
		StringBuilder subtractResultBuilder = new StringBuilder();
		subtractResultBuilder.append(tmpResult);
		subtractResultBuilder.append(numericDividentArray[divisorLength]);

		
		int tmpIterationResult = 0;
		
		while (dividentLength > 0) {

			
			int tmpIterationDivident = Integer.parseInt(subtractResultBuilder.toString());
			numberToPrint = ( tmpIterationDivident / divisor ) * divisor;
			System.out.println("------------");
			System.out.println("_" + tmpIterationDivident);
			System.out.println(" " + numberToPrint);
			

			while (tmpIterationDivident >= divisor) {
				tmpIterationDivident = tmpIterationDivident - divisor;
				tmpIterationResult = tmpIterationDivident;
				tmpRemainder++;
				numberToPrint = (tmpIterationDivident / divisor) * divisor;

			}

			divisionResult.append(tmpRemainder);
			dividentLength--;
			divisorLength++;
			
			
		}
//			StringBuilder nextIterationResult = new StringBuilder();
//			nextIterationResult.append(tmpIterationResult);
//			nextIterationResult.append(numericDividentArray[divisorLength]);
//			System.out.println("_" + nextIterationResult);
//
//			divisorLength++;
//
//			int iterationResult = 0;
//			int nextIterationDivident = Integer.parseInt(nextIterationResult.toString());
//
//			while (nextIterationDivident >= divisor) {
//				nextIterationDivident = nextIterationDivident - divisor;
//				iterationResult = nextIterationDivident;
//				tmpRemainder++;
//			}
//
//			divisionResult.append(tmpRemainder);
//
//			dividentLength = dividentLength - 2;
//
//		}

//		int dividentLength = dividentArray.length;
//		StringBuilder leftSpace = new StringBuilder();
//		StringBuilder regulatorySpace = new StringBuilder();
//		StringBuilder regulatoryDash = new StringBuilder();
//
//		for (int i = 0; i < dividentLength - divisorArray.length; i++) {
//			regulatorySpace.append(" ");
//			regulatoryDash.append("-");
//		}
//
//		for (int i = 0; i < divisorArray.length; i++) {
//			leftSpace.append(" ");
//		}
//		System.out.println("_" + divident + " | " + divisor);
//		System.out.println(" " + divisor + regulatorySpace + " | " + regulatoryDash);
//		System.out.println(leftSpace + "-" + regulatorySpace + " | " + quotient);
//
//		for (int i = 0; i < dividentLength - 1; i++) {
//
//			int tmpDividentSandBox = numericDividentArray[i];
//			int tmpDifference = tmpDivident - divisor;
//			int tmpSecondDividentNumber = numericDividentArray[i + 1];
//
//			String tmpStringToMerge = String.valueOf(tmpDifference) + String.valueOf(tmpSecondDividentNumber);
//			int dividentNumber = Integer.parseInt(tmpStringToMerge);
//			System.out.println("_" + dividentNumber);
//			int nextDivisor = ((int) Math.floor(dividentNumber / 4)) * 4;
//			System.out.println(leftSpace + "--");
//
//		}

	}

}
