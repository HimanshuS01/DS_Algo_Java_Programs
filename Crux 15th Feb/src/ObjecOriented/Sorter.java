package ObjecOriented;

import java.util.Date;

public class Sorter {
	
	public static<T extends Comparison<T>> void bubbleSort(T[] input1) {
		for (int endIndex = input1.length - 1; endIndex > 0; endIndex--) {
			for (int currentIndex = 0; currentIndex < endIndex; currentIndex++) {
				if (input1[currentIndex].compareTo(input1[currentIndex + 1]) == 1) {
					T temp = input1[currentIndex];
					input1[currentIndex] = input1[currentIndex + 1];
					input1[currentIndex + 1] = temp;
				}
			}
			
		}
	}
}
