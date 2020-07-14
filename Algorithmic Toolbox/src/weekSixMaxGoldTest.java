import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekSixMaxGoldTest {

	@Test
	void test() {
		int[] w= {1,4,8};
		assertEquals(10, weekSixMaxGold.optimalWeight(10, w), "test");
	}

}
