package com.atguigu.leetcode.algorithm;

//作者:lhh 创建时间:2019年1月23日 上午9:30:38 
//https://blog.csdn.net/qq_22222499/article/details/71007261
/**
 * n皇后问题
 * @author lhh
 *
 */
public class Question51 {

	public static int Q = 4; // 代表四皇后

	public static void main(String[] args) {
		int[][] dp = new int[Q][Q];
		int i, j;
		// 初始化
		for (i = 0; i < Q; i++) {
			for (j = 0; j < Q; j++) {
				dp[i][j] = 0;
			}
		}
		que(0, dp);
	}

	private static void que(int m, int[][] dp) {
		if (m == Q) {// 递归结束条件
			for (int i = 0; i < Q; i++) {
				for (int j = 0; j < Q; j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println("\n");
			}
			System.out.println("**********************");
		}
		// 递归计算
		for (int i = 0; i < Q; i++) {
			if (isCorrt(i, m, dp)) {
				dp[i][m] = 1;
				que(m + 1, dp);
				dp[i][m] = 0;
			}
		}
	}

	// 判断这个位置能不能放皇后
	private static boolean isCorrt(int i, int j, int[][] dp) {
		// TODO Auto-generated method stub
		int s, t; // s代表行,t代表列
		for (s = i, t = 0; t < Q; t++)
			if (dp[s][t] == 1 && t != j)
				return false;// 判断行
		for (t = j, s = 0; s < Q; s++)
			if (dp[s][t] == 1 && s != i)
				return false;// 判断列
		for (s = i - 1, t = j - 1; s >= 0 && t >= 0; s--, t--)
			if (dp[s][t] == 1)
				return false;// 判断左上方
		for (s = i + 1, t = j + 1; s < Q && t < Q; s++, t++)
			if (dp[s][t] == 1)
				return false;// 判断右下方
		for (s = i - 1, t = j + 1; s >= 0 && t < Q; s--, t++)
			if (dp[s][t] == 1)
				return false;// 判断右上方
		for (s = i + 1, t = j - 1; s < Q && t >= 0; s++, t--)
			if (dp[s][t] == 1)
				return false;// 判断左下方
		return true;
	}

}
