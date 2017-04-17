/**
 * Created by CLY on 2017年4月16日.
 */
package pers.cly.algorithm.upper_steps;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

/**
 * @author CLY
 *
 */
/**
 *题目描述
									
有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或二级，要走上第m级，共有多少走法？
注：规定从一级到一级有0种走法。
								
输入
输入数据首先包含一个整数n(1<=n<=100)，表示测试实例的个数，然后是n行数据，每行包含一个整数m，（1<=m<=40), 表示楼梯的级数。
样例输入
2
2
3

输出
对于每个测试实例，请输出不同走法的数量。
样例输出
1
2
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		for(int i=0;i<n;i++){
			int step_num = scanner.nextInt();
			
			int moves = upper(0, step_num-2,0);
			
			System.out.println(moves+1);//加上所有都为1，这种可能性
		}
	}
	
	/**
	 * 相当于一开始都是{1,1,1,1,1,1,······第n个1}这种走法。
	 * 然后[0][1]合并成了2，算一种方法。
	 * 如果后面的“多个1”还能合并，则递归。
	 * 
	 * 然后[1][2]合并成2
	 * ······
	 * 
	 * @param start 开始合并的位置
	 * @param max 每步爬1，最后一步的次数。整个台阶总长度-2（因为从0开始算）
	 * @param now_moves （当前走法数）
	 * @return 目前的走法数
	 */
	private static int upper(int start,int max,int now_moves) {
		for(int i=start;i<max;i++){
			if ((i+1)<max) {
				now_moves = upper(i+2, max, now_moves);
			}

			now_moves++;
		}
		return now_moves;
	}

}
