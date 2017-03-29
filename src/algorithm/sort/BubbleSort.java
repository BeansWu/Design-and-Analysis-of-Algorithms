package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = RandomArrayUtil.getRandomArray(10);
		System.out.println(Arrays.toString(array));
		int temp = 0;
		//总共要走 length-1 轮
		for (int i = 1; i < array.length; i++) {
			//每轮比较 length-i 次（0 ~ length - i）
			for (int j = 0; j< array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

}
