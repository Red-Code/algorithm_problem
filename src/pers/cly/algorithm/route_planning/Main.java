/**
 * Created by CLY on 2017年4月23日.
 */
package pers.cly.algorithm.route_planning;

import java.util.ArrayList;
import java.util.Scanner;

/**
题目描述
									
小东和小C是一对好朋友，她俩经常一起玩游戏。
这一次她们俩又在一起玩一个新游戏，如图所示，游戏的场所是一个棋盘格，
每次小东或小C为对方指定棋盘格中的两个方块位置s和T，要求对方从位置S移动到位置T，
若移动的路径是最优最短路径则增加一分，否则不加分。若干轮游戏结束后，得分高的一方获胜。

每次移动时，小东或小C只能移动一步，即一个单元格的位置，从当前单元格移动到与之相邻的单元格。
两个单元格相邻是指两个单元格有共同的边或定点，即一个单元格最多只能有8个相邻的单元格。

每次移动方向可以用“L, R, U, D, LU, LD, RU, RD”之一表达，分别表示向“左、右、上、下、左上、左下、右上、右下”移动一步。 

小东对最优最短路径有着特别的嗜好，她对转弯较为敏感，喜欢走直道。
有对角道和水平或垂直方向道路可选时，她喜欢走对角道，因为她觉得走对角道距离更短，
能够更快抵达目的地，即便事实上可能并非如此。遗憾的是，小东对寻路不太擅长，她请你帮忙解决这个问题。
						
输入
输入中有多组测试数据。每组测试数据包含2行，分别代表单元格S和T的坐标。坐标由两个拉丁字母表示，第一个为小写的a-h之间的字母，第二个为1-8之间的数字。
样例输入
a8
h1

输出
对每组测试数据，先在单独的一行中输出最少移动的步数，之后在单独的行中输出最优最短路径中每步移动的方向。
样例输出
7
RD
RD
RD
RD
RD
RD
RD
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/**
		 * 思路：
		 * 先斜线移动到与end点在同一水平（或垂直）线上，之后再直线移动
		 */
		while (scanner.hasNext()) {
			String begin = scanner.next();
			String end = scanner.next();
			int begin_en = Integer.valueOf(begin.charAt(0));
			int begin_num = Integer.parseInt(begin.charAt(1)+"");
			int end_en = Integer.valueOf(end.charAt(0));
			int end_num = Integer.parseInt(end.charAt(1)+"");
			//“L, R, U, D, LU, LD, RU, RD”之一表达，分别表示向“左、右、上、下、左上、左下、右上、右下”
			ArrayList<String> arrayList = new ArrayList<>();
			while (begin_en!=end_en||begin_num!=end_num) {
				//在斜对角线上
				if (begin_en!=end_en&&begin_num!=end_num) {
					if (begin_en>end_en&&begin_num<end_num) {//end在左上
						begin_en--;
						begin_num++;
						arrayList.add("LU");
						continue;
					}
					
					if (begin_en<end_en&&begin_num<end_num) {//end在右上
						begin_en++;
						begin_num++;
						arrayList.add("RU");
						continue;
					}
					
					if (begin_en<end_en&&begin_num>end_num) {//end在右下
						begin_en++;
						begin_num--;
						arrayList.add("RD");
						continue;
					}
					
					if (begin_en>end_en&&begin_num>end_num) {//end在左下
						begin_en--;
						begin_num--;
						arrayList.add("LD");
						continue;
					}
				}else {//在同一直线上
					if (begin_en==end_en&&begin_num<end_num) {//end在上
						begin_num++;
						arrayList.add("U");
						continue;
					}
					if (begin_en==end_en&&begin_num>end_num) {//end在下
						begin_num--;
						arrayList.add("D");
						continue;
					}
					if (begin_num==end_num&&begin_en<end_en) {//end在右
						begin_en++;
						arrayList.add("R");
						continue;
					}
					if (begin_num==end_num&&begin_en>end_en) {//end在左
						begin_en--;
						arrayList.add("L");
						continue;
					}
				}
			}
			
			System.out.println(arrayList.size());
			for (String string : arrayList) {
				System.out.println(string);
			}
		}
	}

}
