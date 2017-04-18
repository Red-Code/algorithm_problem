/**
 * Created by CLY on 2017年4月18日.
 */
package pers.cly.algorithm.food_supplement;

import java.util.Scanner;

/**
 * 题目描述

小赛很想到外面的世界看看，于是收拾行装准备旅行。
背了一个大竹筐，竹筐里装满了路上吃的，这些吃的够它走N公里。
为了规划路线，它查看了地图，沿途中有若干个村庄，在这些村庄它都可以补充食物。
但每次补充食物都需要花费时间，在它竹筐的食物足够可以走到下一个村庄的时候它就不用补充，这样背起来不累而且不花费时间。
地图上可以看到村庄之间的距离，现在它要规划一下它的路线，确定在哪些村庄补充食物可以使沿途补充食物的次数最少。你能帮帮小赛吗？

输入
第一行有两个数字，第一个数字为竹筐装满可以走的公里数，即N值；第二个数字为起点到终点之间的村庄个数。
第二行为起点和村庄、村庄之间、村庄和终点之间的距离。
这些数字都为整数，且范围不能超过一个int型表达的范围。
样例输入
7 4
5 6 3 2 2

输出
程序输出为至少需要补充食物的次数。
样例输出
2
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = 0;
		int[] arrline_2 = null;

		for(int i1=0;i1<2;i1++){
			int now_num = scanner.nextInt();
			if (i1==0) {
				n=now_num;
			}else {
				arrline_2 = new int[now_num+1];
			}
		}

		int len = arrline_2.length;
		for(int i2=0;i2<len;i2++){
			int now_num = scanner.nextInt();
			arrline_2[i2] = now_num;
		}

		int result = 0;//补充食物的次数
		for(int j=0;j<len;){//j表示数组下标（当前位置到下一个村庄的距离）
			int k = j+1;//k表示数组下标（下一个村庄到下下个村庄的距离）
			int after_road = arrline_2[j];
			if (after_road>n) {
				result = 1;
				break;
			}
			
			for (; k < len; k++) {
				int after_a_road = after_road+arrline_2[k];
				//如果下条路加上下下条路距离小于等于可走距离，就表示能到达下下个村庄。
				if (n>=after_a_road) {
					after_road = after_a_road;
				}else {
					break;
				}
				
			}
			
			j=k;
			result++;
		}
		
		System.out.println(result-1);//因为走到终点还会补充一次
	}
}