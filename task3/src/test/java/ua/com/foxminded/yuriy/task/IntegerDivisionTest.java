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
	private final List<String> arrayForTest() {
		List<String> listForTest = new ArrayList<>(Collections.nCopies(100, "1"));
		return listForTest;
	}
		
	@Test
	void LongDivision_DivisorEqualToDividend_RightPrintResult() {
		
		int dividendEqualDivisor = 888;
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

		int dividend = 0;
		int divisor = 100500;
		assertThrows(IllegalArgumentException.class, () -> test.LongDivision(dividend, divisor));
	}
	
	@Test
	void LongDivision_DivisorEqualZero_ThrowIllegalException() {
		
		int dividend = 100500;
		int divisor = 0;
		assertThrows(IllegalArgumentException.class, () -> test.LongDivision(dividend, divisor));
	}
	
	@Test
	void centralIterationWhileLoopLine139_MoreThanTwoIterations_ReturnTrueValue() {
		
		int divisor = 111112;
		List<String> dividendList = arrayForTest();
		StringBuilder newMinued = new StringBuilder();
		newMinued.append(dividendList.get(0));
		int i = 0;
		while (Integer.parseInt(newMinued.toString()) < divisor) {
			i++;
			if (i >= dividendList.size()) {
				break;
			}
			newMinued.append(dividendList.get(i));
		}
		assertEquals(6, i);
	}
	
	@Test	
	void starterDividend_MoreThanOneIteration_ReturnTrueDividend() {
		
		StringBuilder tmpBuilder = new StringBuilder();
		int divisor = 1112;
		List<String> dividendList = arrayForTest();
		for (String s : dividendList) {
			tmpBuilder.append(s);
			if (Integer.parseInt(tmpBuilder.toString()) >= divisor) {
				break;
			}
		}
		assertEquals(11111, Integer.parseInt(tmpBuilder.toString()));
	}
}
