import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekOneMaxTwoTest {

	@Test
	void test() {
		
		int[] testArray = {2,1};
		
		assertEquals(2, weekOneMaxTwo.getMaxPairwiseProduct(testArray), "must be 2");
		
	}

}
