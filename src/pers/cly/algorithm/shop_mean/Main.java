/**
 * Created by CLY on 2017年4月29日.
 */
package pers.cly.algorithm.shop_mean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

/**
题目描述						
过年啦！小B高兴的不行了，她收到了很多红包，可以实现好多的愿望呢。
小B可是对商店货架上心仪的货物红眼好久了，只因囊中羞涩作罢，这次她可是要大大的shopping一番。
小B想去购物时，总是习惯性的把要买的东西列在一个购买清单上，每个物品单独列一行（即便要买多个某种物品），这次也不例外。
小B早早的来到了商店，由于她太激动，以至于她到达商店的时候，服务员还没有把各个商品的价签排好，所有的价签还都在柜台上。
因此还需要一段时间，等服务器把价签放到对应的商品处，小B才能弄清她的购买清单所需的费用。
小B都有些迫不及待了，她希望你能够根据购买清单，帮她算算最好和最坏的情况下所需的费用，你能帮她吗？

输入
输入中有多组测试数据。
每组测试数据的第一行为两个整数n和m（1=＜n, m=＜1000），分别表示价签的数量以及小B的购买清单中所列的物品数。
第二行为空格分隔的n个正整数，表示货架上各类物品的价格，每个数的大小不超过100000。
随后的m行为购买清单中物品的名称，所有物品名称为非空的不超过32个拉丁字母构成的字符串，
保证清单中不同的物品种类数不超过n，且商店有小B想要购买的所有物品。
样例输入
5 3
4 2 1 10 5
apple
orange
mango
6 5
3 5 1 6 8 1
peach
grapefruit
banana
orange
orange

输出
对每组测试数据，在单独的行中输出两个数a和b，表示购买清单上所有的物品可能需要的最小和最大费用。
样例输出
7 19
11 30
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int label_num = scanner.nextInt();
			int goods_num = scanner.nextInt();
			
			int[] label_arr = new int[label_num];
			for (int i = 0; i < label_num; i++) {
				label_arr[i] = scanner.nextInt();
			}
			
			HashMap<String, Integer> goods_map = new HashMap<>();
			for (int i = 0; i < goods_num; i++) {
				String gooods_name = scanner.next();
				Integer good_now_num = goods_map.get(gooods_name);
				if (good_now_num!=null) {
					goods_map.put(gooods_name, good_now_num+1);
				}else {
					goods_map.put(gooods_name, 1);
				}
			}
			
			//将所有的商品数量存入数组并排序
			int[] goods_num_arr = new int[goods_map.size()];
			Iterator<Integer> iterator = goods_map.values().iterator();
			int index=0;
			while (iterator.hasNext()) {
				goods_num_arr[index] = iterator.next();
				index++;
			}
			
			int money_max = 0;
			int money_min = 0;
			int label_len = label_arr.length;
			int goods_len = goods_num_arr.length;
			quick_sort(label_arr, 0,label_len-1);
			quick_sort(goods_num_arr, 0,goods_len-1);
			for (int label_max=label_len-1,label_min=0,goods_index=goods_len-1;goods_index>=0;label_max--,label_min++,goods_index--) {
				money_max += goods_num_arr[goods_index]*label_arr[label_max];
				money_min += goods_num_arr[goods_index]*label_arr[label_min];
			}
			
			System.out.println(money_min+" "+money_max);
		}
	}

	public static void quick_sort(int[] arr,int pivot,int end) {
		int tmp_pivot = pivot;
		int tmp_end = end;
		
		//为true时pivot在数组左边，为false时在右边
		boolean flag = true;
		//整个过程是end往pivot逼近的过程
		while (tmp_pivot!=tmp_end) {
			if (flag) {//pivot在左边
				while (tmp_pivot<tmp_end) {
					//如果成立，则枢轴被换到右边，比枢轴小的数被换到左边 
					if (arr[tmp_pivot]>arr[tmp_end]) {
						int tmp = arr[tmp_pivot];
						arr[tmp_pivot] = arr[tmp_end];
						arr[tmp_end] = tmp;
						
						int tmp_index = tmp_pivot;
						tmp_pivot = tmp_end;
						tmp_end = tmp_index;
						tmp_end++;
						break;
					}else {//查找上一个右边的数，看是否比枢轴小
						tmp_end--;
					}
				}
				flag = false;
			}else {//pivot在右边
				while (tmp_pivot>tmp_end) {
					//如果成立，则枢轴被换到左边，比枢轴大的数被换到左边 
					if (arr[tmp_pivot]<arr[tmp_end]) {
						int tmp = arr[tmp_pivot];
						arr[tmp_pivot] = arr[tmp_end];
						arr[tmp_end] = tmp;
						
						int tmp_index = tmp_pivot;
						tmp_pivot = tmp_end;
						tmp_end = tmp_index;
						tmp_end--;
						break;
					}else {//查找下一个左边的数，看是否比枢轴大
						tmp_end++;
					}
				}
				flag = true;
			}
		}
		//此时枢轴左边的数都比它小，右边的数都比它大。
		//如果整个待排数组长度小于2，就表示已经排到底了。
		if (end-pivot<2) {
			return;
		}
		//如果当前枢轴在起始点的右边，就表示枢轴左边有值，可以对左边进行快排
		if (tmp_pivot>pivot) {
			quick_sort(arr, pivot, tmp_pivot-1);//对左边的数进行快排
		}
		//如果当前枢轴在结束点的左边，就表示枢轴右边有值，可以对右边进行快排
		if (tmp_pivot<end) {
			quick_sort(arr, tmp_pivot+1, end);//对右边的数进行快排
		}
	}
}
