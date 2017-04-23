/**
 * Created by CLY on 2017年4月22日.
 */
package pers.cly.algorithm.pass_exam;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
题目描述									
小明同学要参加一场考试，考试一共有n道题目，小明必须做对至少60%的题目才能通过考试。
考试结束后，小明估算出每题做对的概率，p1,p2,...,pn。你能帮他算出他通过考试的概率吗？

输入
输入第一行一个数n（1<=n<=100），表示题目的个数。第二行n个整数，p1,p2,...,pn。表示小明有pi%的概率做对第i题。（0<=pi<=100）
样例输入
4
50 50 50 50

输出
小明通过考试的概率，最后结果四舍五入，保留小数点后五位。
样例输出
0.31250
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n =scanner.nextInt();
		double[] pass_chance=new double[n];
		for(int i=0;i<n;i++){
			pass_chance[i] = scanner.nextDouble()/100;
		}
		
		int at_least = (int)Math.ceil(n*0.6);

		double rs;
		int len = pass_chance.length;
		//第一次循环找的是60%通过，然后每次循环概率加大
		for (int i = at_least; i <= n; i++) {
			rs =1;
			for (int j = 0; j < i; j++) {
				if (j!=0) {
					rs *= (1-pass_chance[j-1]);
				}
				get_chance(pass_chance,j,i,rs,len);
			}
		}
		
		DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println(df.format(results));
	}
	
	private static double results=0;
	
	/**
	 * 获得待排数组中选择m个题目通过的概率
	 * @param pass_chance 待排数组
	 * @param begin_index 从第几项（第几题）开始选
	 * @param m 需要做对多少条
	 * @return 做对的概率
	 */
	private static void get_chance(double[] pass_chance,int begin_index,int m,double rs,int len) {
		double result = pass_chance[begin_index];
		rs *= result;
		if (m!=1) {
			while (begin_index+m<=len) {
				begin_index++;
				get_chance(pass_chance, begin_index, m-1,rs,len);
				rs *= (1-pass_chance[begin_index]);
			}
		}else {
			for(int i=begin_index+1;i<len;i++){
				rs*=(1-pass_chance[i]);
			}
			results+=rs;
		}	
	}
}