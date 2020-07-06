import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekFourQuickSortTest {

	@Test
	void test() {
		int[] array = {2,3,9,2,2,3};
		weekFourQuickSort.randomizedQuickSort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
	}

}
