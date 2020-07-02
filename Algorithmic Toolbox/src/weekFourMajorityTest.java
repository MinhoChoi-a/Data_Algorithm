import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekFourMajorityTest {

	@Test
	void test() {
		int[] array = {3,2,3,1,1,1,1,1,1,1,1,2,5,5};
		assertEquals(25, weekFourMajority.getMajorityElement(array, 0, array.length), "test");
	}

}
