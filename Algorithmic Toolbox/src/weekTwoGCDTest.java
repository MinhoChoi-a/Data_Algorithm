import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekTwoGCDTest {

	@Test
	void test() {
		assertEquals(1, weekTwoGCD.gcd_naive(18, 35), "test");
		assertEquals(17657, weekTwoGCD.gcd_naive(28851538, 1183019), "test");
	}

}
