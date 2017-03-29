package algorithm.sort;

import java.util.Random;

public class RandomArrayUtil {
	public static int[] getRandomArray(int length){
		int[] nums = new int[length];
		Random random = new Random();
		for (int i = 0; i < nums.length; i ++) {
			nums[i] = random.nextInt(50)%(50+1);
		}
		return nums;
	}
}
