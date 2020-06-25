import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekTwoGCDTest {

	@Test
	void test() {
		assertEquals(10, weekTwoGCD.gcd_naive(36, 80), "test");
		assertEquals(10, weekTwoGCD.gcd_naive(28851538, 1183019), "test");
	}

}
