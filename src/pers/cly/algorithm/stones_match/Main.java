/**
 * Created by CLY on 2017年4月16日.
 */
package pers.cly.algorithm.stones_match;

import java.util.Scanner;

/**
 * @author CLY
 *
 */

/**
 * 刚刚做完的美图公司笔试题。
 * 
 * question：
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap. True for win and false for lose.
For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 * 
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int sum = scanner.nextInt();
		
		//一开始我拿的三种状况
		if (chance(sum,1,1)) {
			System.out.println(true);
		}else if (chance(sum,2,1)) {
			System.out.println(true);
		}else if (chance(sum,3,1)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	
	/**
	 * 
	 * @param surplus 剩余的石头数量
	 * @param take_num 这一次拿走的数量
	 * @param people 1代表是我，2代表是朋友
	 * @return 返回true，则表示我能赢
	 */
	private static boolean chance(int surplus,int take_num,int people) {
		surplus = surplus-take_num;
		
		//当某人拿完，剩余四块时，该人赢
		if (surplus==4) {
			if (people==1) {
				return true;
			}else {
				return false;
			}
		}
		
		//当某人拿完，剩余数小于4块时，另一个人赢
		if (surplus<=3) {
			if (people==1) {
				return false;
			}else {
				return true;
			}
		}
		
		//此时剩余的石头大于4，继续拿
		
		if (people==1) {//交换人
			people = 2;
			//如果是朋友拿，则必须三个true
			if (chance(surplus,1,people)) {
				if (chance(surplus,2,people)) {
					if (chance(surplus,3,people)) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			people = 1;
			
			//如果是我拿，则只需有一个true即可
			if (chance(surplus,1,people)) {
				return true;
			}else if (chance(surplus,2,people)) {
				return true;
			}else if (chance(surplus,3,people)) {
				return true;
			}else {
				return false;
			}
		}
	}
}
