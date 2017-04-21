/**
 * Created by CLY on 2017年4月19日.
 */
package pers.cly.algorithm.multiplication_table;

import java.util.Scanner;
/**
题目描述
									
度度熊和爷爷在玩一个乘法表游戏。乘法表的第i行第j列位置的元素为i*j，并且乘法表下标编号从1开始，比如2 × 3乘法表为
1 2 3
2 4 6
爷爷十分聪明，对于n*m的乘法表，
只要度度熊给出一个数k，爷爷就能立刻告诉度度熊乘法表中元素按照不减顺序排列之后，第k个元素是多少。
你能重复这个游戏吗？
			
输入
输入数据是三个整数：n, m, k (1≤n, m≤5*105, 1≤k≤nm)。
样例输入
2 3 4

输出
输出n*m乘法表按照不减顺序排列的第k个数。
样例输出
3
 */
public class Main {

	/**
	 * 假设有一个9*9乘法表，
	 * 那么小于6的数就是：
	 * 第一行有6/1个
	 * 第二行有6/2个，
	 * 第三行有6/3个，
	 * ·······
	 * 第6行有6/6个。
	 * （第7行以后为6/7=0,所以没有小于6的数）
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		long k = scanner.nextLong();
		/**
		 * 先找到总数，之后找到总数的中位数，再找该中位数在第几位，
		 * 如果该位数小于查找位数，则从目前中位数和总数之间再找一中位数，找其位数。
		 * 如果该位数大于查找位数，则从1到中位数之间找一中位数，再找其位数。
		 * ·····
		 * 直到“某中位数的位数”与查找位数相同，则该数就是需要找的数
		 */
		long left = 1;
		long right = n*m;
		long mid = (left+right)/2;
		long num = little_num(n, m, mid);
		long result=0;

		while ((left+1)!=right) {
			if (num<k) {
				left = mid;
				mid = (left+right)/2;
				num = little_num(n, m, mid);
			}else {
				right = mid;
				mid = (left+right)/2;
				num = little_num(n, m, mid);
			}
		}
		
		if (num<k) {
			result=right;
		}else {
			result=left;
		}
		
		System.out.println(result);
	}
	
	/**
	 * 查找有多少个数小于等于mid
	 * @param n 行数
	 * @param m 列数
	 * @param mid 目标数
	 * @return 小于等于mid的数的个数
	 */
	private static long little_num(long n,long m,long mid) {
		long num=0;
		for(int i=1;i<=n;i++){
			long little_num = mid/i;//当前行中，小于中间数的数的个数
			
			if (little_num==0) {
				break;
			}
			
			if (little_num>=m) {//个数不能大于列数
				little_num = m;
			}
			
			num +=little_num;
		}
		
		return num;
	}
}