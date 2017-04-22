package experiment;

import java.util.Scanner;
/**
 * @Description: TODO
 * 令S为一个n个正整数的集合，n为偶数。请设计一个有效算法将S分成两个子集S1和S2，使每个子集中含有n/2个元素，而且S1中所有元素的和与S2中所有元素的和的差最大。
 * @author Andrew
 * @date 2017年4月22日
 */
public class IntegerSetDecomposition {

	public static void main(String[] args) {
		//测试例个数;每个测试例的长度
		int n, m;
		//测试用例
		int nums[][] = null;
		//结果
		int result[][] = null;
		//哨兵
		int sentinel = 0;
		Scanner scanner = new Scanner(System.in);
		//输入数据
		n = scanner.nextInt();
		nums = new int[n][];
		result = new int[2 * n][];
		for (int i = 0; i < n; i++) {
			m = scanner.nextInt();
			for (int j = 0; j < m; j++) {
				nums[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			//采用插入排序
			//第 0 个默认已经排序好
			for (int j = 1; j < nums[i].length; j++) {
				if (nums[i][j] < nums[i][j - 1]) {
					//将要移动的元素给哨兵
					sentinel = nums[i][j];
					int k = j;
					//将大于哨兵的元素后移
					while (k > 0 && sentinel < nums[i][k - 1]) {
						nums[i][k] = nums[i][k - 1];
						k--;
					}
					nums[i][k] = sentinel;
					
				}
			}
		}
		//分离数组
		int t = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < nums[i].length * 0.5; j++) {
				result[t][j] = nums[i][j];
			}
			t++;
			for (int j = (int) (nums[i].length * 0.5); j < nums[i].length; j++) {
				result[t][j] = nums[i][j];
			}
			t++;
		}
		//打印
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}

}
