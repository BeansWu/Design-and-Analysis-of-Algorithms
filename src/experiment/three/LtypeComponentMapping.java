package experiment.three;

import java.util.Scanner;

/**
 * @Description: L型组件填图问题，参考http://www.cnitblog.com/intrl/archive/2009/04/11/56263.aspx
 * @author: Andrew 
 * @date:   2017-06-02
 */
public class LtypeComponentMapping {
	
	//L 型组件的标识，从 10 开始，两位数呈现的效果会更好
	static int mark = 10;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		L(n, 2);
		scanner.close();
	}
	/**
	 * @Title: L   
	 * @Description: TODO   
	 * @param: @param n 棋盘的规格为 n * n
	 * @param: @param k 初次放置 L 型组件的形态（有四种，详见 Excel）
	 * @return: void      
	 * @throws
	 */
	public static void L(int n, int k) {
		int[][] nn = new int[n][n];
		divide(nn, 0, n - 1, 0, n - 1, 2);
		//打印
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(nn[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * @Title: divide   
	 * @Description: 分治，有四种类型的放置，按逆时针顺序放置，详见 Excel 
	 * @param: @param nn 棋盘
	 * @param: @param xb x-begin 棋盘左上角的 x 轴坐标
	 * @param: @param xe x-end 棋盘右下角的 x 轴坐标
	 * @param: @param yb y-begin 棋盘左上角的y 轴坐标
	 * @param: @param ye y-end 棋盘右下角的y 轴坐标
	 * @param: @param type L 型摆放的形态
	 * @return: void      
	 * @throws
	 */
	public static void divide(int[][] nn, int xb, int xe, int yb, int ye, int type) {
		if (xe > xb && ye > yb) {
			if (type == 1) {
				//1:1 4 1 2
				divide(nn, xb, (xb + xe)/2, yb, (yb + ye)/2, 1);
				divide(nn, xb, (xb + xe)/2, (yb + ye)/2 + 1, ye, 4);
				divide(nn, (xb + xe)/2 + 1, xe, (yb + ye)/2 + 1, ye, 1);
				divide(nn, (xb + xe)/2 + 1, xe, yb, (yb + ye)/2, 2);
				//放置 L 型组件
				nn[(xb + xe)/2 + 1][(yb + ye)/2] = mark;
				nn[(xb + xe)/2 + 1][(yb + ye)/2 + 1] = mark;
				nn[(xb + xe)/2][(yb + ye)/2 + 1] = mark;
				//为下一个组件的放置准备
				mark++;
			}
			if (type == 2) {
				//2:3 2 1 2
				divide(nn, xb, (xb + xe)/2, yb, (yb + ye)/2, 3);
				divide(nn, xb, (xb + xe)/2, (yb + ye)/2 + 1, ye, 2);
				divide(nn, (xb + xe)/2 + 1, xe, (yb + ye)/2 + 1, ye, 1);
				divide(nn, (xb + xe)/2 + 1, xe, yb, (yb + ye)/2, 2);
				
				nn[(xb + xe)/2][(yb + ye)/2] = mark;
				nn[(xb + xe)/2 + 1][(yb + ye)/2] = mark;
				nn[(xb + xe)/2 + 1][(yb + ye)/2 + 1] = mark;
				mark++;
			}
			if (type == 3) {
				//3:3 4 3 2
				divide(nn, xb, (xb + xe)/2, yb, (yb + ye)/2, 3);
				divide(nn, xb, (xb + xe)/2, (yb + ye)/2 + 1, ye, 4);
				divide(nn, (xb + xe)/2 + 1, xe, (yb + ye)/2 + 1, ye, 3);
				divide(nn, (xb + xe)/2 + 1, xe, yb, (yb + ye)/2, 2);
				
				nn[(xb + xe)/2][(yb + ye)/2] = mark;
				nn[(xb + xe)/2 + 1][(yb + ye)/2] = mark;
				nn[(xb + xe)/2][(yb + ye)/2 + 1] = mark;
				mark++;
			}
			if (type == 4) {
				//3:3 4 1 4
				divide(nn, xb, (xb + xe)/2, yb, (yb + ye)/2, 3);
				divide(nn, xb, (xb + xe)/2, (yb + ye)/2 + 1, ye, 4);
				divide(nn, (xb + xe)/2 + 1, xe, (yb + ye)/2 + 1, ye, 1);
				divide(nn, (xb + xe)/2 + 1, xe, yb, (yb + ye)/2, 4);
				
				nn[(xb + xe)/2][(yb + ye)/2] = mark;
				nn[(xb + xe)/2][(yb + ye)/2 + 1] = mark;
				nn[(xb + xe)/2 + 1][(yb + ye)/2 + 1] = mark;
				mark++;
			}
		}
	}
}
