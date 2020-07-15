import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekSixParentheseTest {

	@Test
	void test() {
		String exp = "1+5";
		assertEquals(10, weekSixParenthese.getMaximValue(exp), "test");
	}

}
