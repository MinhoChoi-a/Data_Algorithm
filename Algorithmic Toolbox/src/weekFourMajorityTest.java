import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekFourMajorityTest {

	@Test
	void test() {
		int[] array = {1,2,3,1};
		assertEquals(25, weekFourMajority.getMajorityElement(array, 0, 4), "test");
	}

}
