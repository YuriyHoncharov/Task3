package ua.com.foxminded.yuriy.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

class IntegerDivisionTest {
	
	private final IntegerDivision test = new IntegerDivision();	
			
	@Test
	void LongDivision_DivisorEqualToDividend_RightPrintResult() {
		
		int dividendEqualDivisor = 888;
		String resultCaseOne = test.longDivision(dividendEqualDivisor, dividendEqualDivisor);
		String expectedResultCaseOne = "_888 | 888" + "\n"
								         	+ " 888 | -" + "\n"
								         	+ " --- | 1" + "\n"
												+ "   0";
		assertEquals(expectedResultCaseOne, resultCaseOne);
	}

	@Test
	void LongDivision_DivisorEqualToOne_RightPrintResult() {
		
		int dividend = 66;
		int divisor = 1;
		String resultCaseTwo = test.longDivision(dividend, divisor);
		String expectedResultCaseTwo = "_66 | 1" + "\n"
			 							   	+ " 6  | --" + "\n"
			 							   	+ " -  | 66"  + "\n"
			 							   	+ " _6" + "\n"
			 							   	+ "  6" + "\n"
			 							   	+ "  -" + "\n"
			 							   	+ "  0";
		assertEquals(expectedResultCaseTwo, resultCaseTwo);
	}
	
	@Test
	void LongDivision_MoreThanTwoIterationsInCentralIterationWhileLoop_ReturnTrueValue() {
		int dividend = 999998;
		int divisor = 9981;
		String resultCaseThree = test.longDivision(dividend, divisor);
		String expectedResultCaseTwo = "_999998 | 9981" + "\n"
			 							   	+ " 9981   | ---" + "\n"
			 							   	+ " ----   | 100"  + "\n"
			 							   	+ "  _1898" + "\n"
			 							   	+ "      0" + "\n"
			 							   	+ "      -" + "\n"
			 							   	+ "      1898";
		assertEquals(expectedResultCaseTwo, resultCaseThree);
	}
	
	@Test	
	void LongDivision_MoreThanOneIterationInStarterDividendMethod_ReturnTrueDividend() {
		int dividend = 8893;
		int divisor = 973;
		String resultCaseFour = test.longDivision(dividend, divisor);
		String expectedResultCaseTwo = "_8893 | 973" + "\n"
			 							   	+ " 8757 | -" + "\n"
			 							   	+ " ---- | 9"  + "\n"
			 							   	+ "  136";
		assertEquals(expectedResultCaseTwo, resultCaseFour);
	}

	@Test
	void LongDivision_DividendEqualZero_ThrowIllegalException() {

		int dividend = 0;
		int divisor = 100500;
		assertThrows(IllegalArgumentException.class, () -> test.longDivision(dividend, divisor));
	}
	
	@Test
	void LongDivision_DivisorEqualZero_ThrowIllegalException() {
		
		int dividend = 100500;
		int divisor = 0;
		assertThrows(IllegalArgumentException.class, () -> test.longDivision(dividend, divisor));
	}
}
