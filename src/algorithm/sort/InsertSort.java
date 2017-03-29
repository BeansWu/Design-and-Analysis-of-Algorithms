package algorithm.sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] nums = RandomArrayUtil.getRandomArray(10);
		//哨兵
		int sentinel = 0;
		System.out.println(Arrays.toString(nums));
		//第0位默认为已经排序好的只有一个元素的数组，故从第一位开始,
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				//将要移动的元素赋给哨兵
				sentinel = nums[i];
				int j = i;
				/*
				 * 第 j 位元素即为将要插入到前面已排序好的数组中的的元素
				 * 若第 j-1 位元素小于哨兵，则将 j-1 位的元素值后移一位至 j
				 * 比较直到存在不大于哨兵的元素，则将哨兵插入到该元素的后一位
				 */
				while ((j > 0) && (sentinel < nums[j - 1])) {
					nums[j] = nums[j - 1];
					j--;
				}
				nums[j] = sentinel;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

}
