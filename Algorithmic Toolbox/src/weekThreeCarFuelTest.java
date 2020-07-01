import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekThreeCarFuelTest {

	@Test
	void test() {
		
		int[] array = {200,375,550,750};
		assertEquals(25, weekThreeCarFuel.min_refills(1200, 400, array), "test");
	}

}
