/**
 * Created by CLY on 2017年4月18日.
 */
package pers.cly.algorithm.hamming_barbette;

import java.util.Scanner;

/**
题目描述
									
兰博教训了提莫之后，然后和提莫讨论起约德尔人，谈起约德尔人，自然少不了一个人，那就是黑默丁格——约德尔人历史上最伟大的科学家。
提莫说，黑默丁格最近在思考一个问题：
黑默丁格有三个炮台，炮台能攻击到距离它R的敌人,
(两点之间的距离为两点连线的距离,例如(3,0)和(0,4)之间的距离是5),
如果一个炮台能攻击到敌人，那么会对敌人造成1X的伤害。
黑默丁格将三个炮台放在N*M方格中的点上,并且给出敌人的坐标。
问：那么敌人受到伤害会是多大？
							
输入
第一行9个整数，R，x1,y1,x2,y2,x3,y3,x0,y0。(0 <= R，x1,y1,x2,y2,x3,y3,x0,y0 <= 100) R 代表炮台攻击的最大距离，(x1,y1), (x2,y2), (x3,y3)代表三个炮台的坐标。(x0,y0)代表敌人的坐标。
样例输入
1 1 1 2 2 3 3 1 2

输出
输出一行,这一行代表敌人承受的最大伤害,(如果每个炮台都不能攻击到敌人，输出0X)。
输出格式见样例。
样例输出
2X
 */
public class Main {

	public static void main(String[] args) {
		double r,x1,y1,x2,y2,x3,y3,x0,y0;
		Scanner scanner = new Scanner(System.in);

		r=scanner.nextDouble();
		x1=scanner.nextDouble();
		y1=scanner.nextDouble();
		x2=scanner.nextDouble();
		y2=scanner.nextDouble();
		x3=scanner.nextDouble();
		y3=scanner.nextDouble();
		x0=scanner.nextDouble();
		y0=scanner.nextDouble();
		
		double len1 = len(x1, y1, x0, y0);
		double len2 = len(x2, y2, x0, y0);
		double len3 = len(x3, y3, x0, y0);
		
		int harm=0;
		if (len1<=r) {
			harm++;
		}
		if (len2<=r) {
			harm++;
		}
		if (len3<=r) {
			harm++;
		}
		
		System.out.println(harm+"X");
		}
	
	//(x1,y1)和(x2,y2)距离公式：√((x2-x1)^2+(y2-y1)^2)
	private static double len(double x1,double y1,double x2,double y2) {
		double len_x = Math.abs(x2-x1);
		double len_y = Math.abs(y2-y1);
		double len = Math.sqrt((len_x*len_x+len_y*len_y));

		return len;
	}
}