import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekFiveDistanceTest {

	@Test
	void test() {
		
		String s="aabb";
		String t="abb";
		
		int a = weekFiveDistance.EditDistance(s, t);
		System.out.println(a);
	}

}
