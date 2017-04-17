/**
 * Created by CLY on 2017年4月17日.
 */
package pers.cly.algorithm.stock_expert;

import java.util.Scanner;

/**
 * @author CLY
 *
 */

/**
 * 问题：
经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？

输入
输入包括多组数据；
每行输入一个n，1<=n<=10^9 
样例输入
1
2
3
4
5

输出
请输出他每股股票多少钱，对于每组数据，输出一行。
样例输出
1
2
1
2
3
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int money = 1;
			int down_day = 1;//在第几天下跌（去除掉第一天，再从第0开始算，所以初始为1）
			int after_down = 3;//在多少天后继续下跌
			
			if (n==1) {
			}else {
				for(int i=0;i<n-1;i++){
					if (i==down_day) {
						money -= 1;
						down_day +=after_down;
						after_down++;
					}else {
						money++;
					}
				}
			}
			
			System.out.println(money);
		}
	}
}
