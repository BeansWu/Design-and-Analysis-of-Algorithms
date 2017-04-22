package experiment;

import java.util.Arrays;

import algorithm.sort.RandomArrayUtil;
/**
 * @Description:
 * 判断一个集合中是否有重复元素
 * @author Andrew
 * @date 2017年3月31日
 */
public class FindTheSameElement {

	public static void main(String[] args) {
		int[] array = RandomArrayUtil.getRandomArray(10);
		System.out.println(Arrays.toString(array));
		int target = 0;
		for (int i = 0; i < array.length - 1; i++) {
			target = array[i];
			int j = i + 1;
			while (j < array.length - 1 && array[j] != target) {
				j++;
			}
			if (target == array[j]) {
				System.out.println("true " + target);
				break;
			}
		}
		//时间复杂度为 O(n2)
	}
}
