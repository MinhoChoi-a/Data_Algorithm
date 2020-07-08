import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekFiveMoneChangeTest {

	@Test
	void test() {
		int m = 34;
		assertEquals(25, weekFiveMoneChange.getChange(m), "test");
	}

}
