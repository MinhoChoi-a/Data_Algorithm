import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekFourBinaryTest {

	@Test
	void test() {
		int[] array = {1,1,8,12,8,8,2,8,9,7,6,5,4,3,8,8,8,8,8,8,8,8};
		assertEquals(25, weekFourBinary.binarySearch(array, array.length), "test");
	}

}
