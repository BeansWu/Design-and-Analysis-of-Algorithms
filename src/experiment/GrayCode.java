package experiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @Description:
 * 对于给定的正整数n，格雷码为满足如下条件的一个编码序列：
 * (1) 序列由2n个编码组成，每个编码都是长度为n的二进制位串。
 * (2) 序列中无相同的编码。
 * (3) 序列中位置相邻的两个编码恰有一位不同。
 * 如：n=2时的格雷码为：{00, 01, 11, 10}。
 * @author Andrew
 * @date 2017年4月22日
 */
public class GrayCode {

	public static List<String> grayCode(int n) {
		List<String> listBef = new ArrayList<String>();
		List<String> listAft = new ArrayList<String>();
		//n 为 1 时递归结束
		if (n == 1) {
			listBef.add("0");
			listBef.add("1");
			return listBef;
		} else {
			listBef = grayCode(n - 1);
			int nums = (int) Math.pow(2, n);
			for (int i = 0; i < nums * 0.5; i++) {
				listAft.add(listBef.get(i) + "0");
				listAft.add(listBef.get(i) + "1");
			}
			return listAft;
		}
	}
	
	public static void main(String[] args) {
		//测试例个数
		int m;
		//每个测试例的测试数据
		int n;
		//结果
		List<List<String>> result = new ArrayList<List<String>>();
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			m = scanner.nextInt();
			List<String> list = grayCode(m);
			result.add(list);
		}
		for (List<String> list : result) {
			for (String s : list) {
				System.out.println(s);
			}
			System.out.println();
		}
		scanner.close();
	}

}
