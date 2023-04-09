package ua.com.foxminded.yuriy.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

class IntegerDivisionTest {
	
	public static final IntegerDivision test = new IntegerDivision();

	@Test
	void LongDivision_DivisorEqualToDividend_RightPrintResult() {
		int dividendEqualDivisor = 888;
		IntegerDivision test = new IntegerDivision();
		String result_caseOne = test.LongDivision(dividendEqualDivisor, dividendEqualDivisor);
		String expectedResult_caseOne = "_888 | 888" + "\n"
								         	+ " 888 | -" + "\n"
								         	+ " --- | 1" + "\n";
		assertEquals(expectedResult_caseOne, result_caseOne);

	}

	@Test
	void LongDivision_DivisorEqualToOne_RightPrintResult() {
		int dividend = 66;
		int divisor = 1;
		IntegerDivision test = new IntegerDivision();
		String result_caseTwo = test.LongDivision(dividend, divisor);
		String expectedResult_caseTwo = "_66 | 1" + "\n"
			 							   	+ " 6  | --" + "\n"
			 							   	+ " -  | 66"  + "\n"
			 							   	+ " _6" + "\n"
			 							   	+ "  6" + "\n"
			 							   	+ "  -" + "\n"
			 							   	+ "  0";
		assertEquals(expectedResult_caseTwo, result_caseTwo);

	}

	@Test
	void LongDivision_DividendEqualZero_ThrowIllegalException() {
		IntegerDivision test = new IntegerDivision();
		int dividend = 0;
		int divisor = 100500;
		assertThrows(IllegalArgumentException.class, () -> test.LongDivision(dividend, divisor));
	}
	@Test
	void LongDivision_DivisorEqualZero_ThrowIllegalException() {
		IntegerDivision test = new IntegerDivision();
		int dividend = 100500;
		int divisor = 0;
		assertThrows(IllegalArgumentException.class, () -> test.LongDivision(dividend, divisor));
	}
}
