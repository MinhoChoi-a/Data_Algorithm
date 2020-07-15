import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekSixParentheseTest {

	@Test
	void test() {
		String exp = "5-8+7*4-8+9";
		assertEquals(10, weekSixParenthese.getMaximValue(exp), "test");
	}

}
