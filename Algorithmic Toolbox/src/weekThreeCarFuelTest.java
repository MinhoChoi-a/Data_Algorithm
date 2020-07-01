import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekThreeCarFuelTest {

	@Test
	void test() {
		
		int[] array = {1,2,5,9};
		assertEquals(25, weekThreeCarFuel.min_refills(10, 3, array), "test");
	}

}
