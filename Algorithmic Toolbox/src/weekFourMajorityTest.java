import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekFourMajorityTest {

	@Test
	void test() {
		int[] array = {2,3,9,2,2};
		assertEquals(25, weekFourMajority.getMajorityElement(array, 0, array.length), "test");
	}

}
