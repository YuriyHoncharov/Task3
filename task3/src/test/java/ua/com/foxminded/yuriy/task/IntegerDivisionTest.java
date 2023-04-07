package ua.com.foxminded.yuriy.task;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

class IntegerDivisionTest {

	IntegerDivision test = new IntegerDivision();
	IntegerDivision testTwo = new IntegerDivision();
	IntegerDivision testThree = new IntegerDivision();
	
	
	// First Case Data
	
	int dividend_caseOne = 888;
	int divisor_caseOne = 888;
	String result_caseOne = test.LongDivision(dividend_caseOne, divisor_caseOne);
	String expectedResult_caseOne = "_888 | 888" + "\n"
								         + " 888 | -" + "\n"
								         + " --- | 1" + "\n";
	
	// Second Case Data
	
	int dividend_caseTwo = 66;
	int divisor_caseTwo = 1;
	String result_caseTwo = testTwo.LongDivision(dividend_caseTwo, divisor_caseTwo);
	String expectedResult_caseTwo = "_66 | 1" + "\n"
			 							   + " 6  | --" + "\n"
			                        + " -  | 66"  + "\n"
			                        + " _6" + "\n"
			                        + "  6" + "\n"
			                        + "  -" + "\n"
			                        + "  0";
	// Third Case Data
	
	int dividend_caseThree = 0;
	int divisor_caseThree = 0;
	String result_caseThree = testThree.LongDivision(dividend_caseThree, divisor_caseThree);

	@Test
	void LongDivision_DivisorEqualToDividend_RightPrintResult() {
		assertEquals(expectedResult_caseOne, result_caseOne);
		
	}
	@Test
	void LongDivision_DivisorEqualToOne_RightPrintResult() {
		assertEquals(expectedResult_caseTwo, result_caseTwo);
		
	}
	
	@Test
	void LongDivision_DivisorOrDividendEqualZero_ThrowIllegalException() {
		assertThrows(IllegalArgumentException.class, () -> testThree.LongDivision(dividend_caseThree, divisor_caseThree));
	}
	
}
