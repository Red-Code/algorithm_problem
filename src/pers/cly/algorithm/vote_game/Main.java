/**
 * Created by CLY on 2017年4月23日.
 */
package pers.cly.algorithm.vote_game;

import java.util.Scanner;

/**
题目描述
									
小东和其他小朋友正在玩一个关于选举的游戏。选举是通过投票的方式进行的，得票最多的人将获胜。
小东是编号为1的候选者，此外还有其他的候选者参加选举。
根据初步的调查情况，所有准备投票的小朋友都有一定的投票倾向性，小东如果要获得胜利，必须争取部分准备为其他候选人投票的小朋友。
由于小东的资源较为有限，她希望用最小的代价赢得胜利，请你帮忙计算她最少需要争取的选票数。
	
输入
输入有若干组，每组包含两行，第一行为一个正整数n（2<=n<=100），表示候选者的数量，
第二行为每个候选人预期得到的选票数，以空格分开，每人的预期得票数在1到1000之间（包含1和1000）。
经过小东的争取后，可能出现候选人得票数为0或超过1000的情况。

样例输入
5
5 1 11 2 8
4
1 8 8 8
2
7 6

输出
对每组测试数据，单独输出一行，内容为小东最少需要争取的选票数。
样例输出
4
6
0
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int our_poll = scanner.nextInt();
			
			int[] arr = new int[n-1];
			for(int i=0;i<n-1;i++){
				arr[i] = scanner.nextInt();
			}
			shellSort(arr,arr.length/2);
			int now_max = arr[n-2];//找到第一次排序后的最大值
			int result_my_add=0;
			
			//如果比我的票多，则减少它
			while (our_poll<=now_max) {
				//减少最多者，增加自己
				arr[n-2]--;
				our_poll++;
				result_my_add++;
				//再排一次
				shellSort(arr,arr.length/2);
				now_max = arr[n-2];
			}
			System.out.println(result_my_add);
		}
	}
	
	/**
	 * 希尔排序（正序）
     * @param array 待排数组
     * @param incrementNum 初始增量
	 */
	public static void shellSort(int[] array,int incrementNum){
        for (int increment = incrementNum; increment > 0; increment /= 2) {//从初始增量开始循环，每次增量减少一倍
            //下面就是一个修改过的直接插入排序
            for (int i = increment; i < array.length; i++) {
                if(array[i] < array[i-increment]){
                    int temp = array[i];
                    int j;
                    for(j = i-increment; j >= 0 && array[j] > temp; j -=increment){
                        array[j+increment] = array[j];
                    }
                    array[j+increment] = temp;
                }
            }
        }
    }
}
