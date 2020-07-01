import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekThreeDotTest {

	@Test
	void test() {
		int[] a = {1, 3, -5};
		int[] b = {-2, 4, 1};
		assertEquals(25, weekThreeDot.maxDotProduct(a, b), "test");
	}

}
