import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekFourBinaryTest {

	@Test
	void test() {
		int[] array = {1,5,8,12,13};
		assertEquals(25, weekFourBinary.binarySearch(array, 23), "test");
	}

}
