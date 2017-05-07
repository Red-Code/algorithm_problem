/**
 * Created by CLY on 2017年5月7日.
 */
package pers.cly.algorithm.phone_num_avatar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
题目描述
									
继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：首先将电话号码中的每个数字加上8取个位，然后使用对应的大写字母代替
（"ZERO", "ONE", "TWO", "THREE", "FOUR", 
"FIVE", "SIX", "SEVEN", "EIGHT", "NINE"），
然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。

输入
第一行是一个整数T（1<=T<=100)表示测试样例数；接下来T行，每行给定一个分身后的电话号码的分身（长度在3到10000之间）。
样例输入
4
EIGHT
ZEROTWOONE
OHWETENRTEO
OHEWTIEGTHENRTEO
输出
输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）。
样例输出
0
234
345
0345
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int data_num = scanner.nextInt();
		for (int i = 0; i < data_num; i++) {
			HashMap<Character, Integer> hashMap = new HashMap<>();
			String enString = scanner.next();
			
			//hashmap中装了所有出现了的字母，和他们的出现次数
			for (int j = 0; j < enString.length(); j++) {
				char one_en = enString.charAt(j);
				Integer en_show_num = hashMap.get(one_en);
				if (en_show_num==null) {
					en_show_num = 1;
				}else {
					en_show_num++;
				}
				
				hashMap.put(one_en, en_show_num);
			}
			
			ArrayList<Integer> result = new ArrayList<>();
			find_num(hashMap, result);
			
			Collections.sort(result, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				}
			});
			
			for (Iterator iterator = result.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				System.out.print(integer);
			}
			System.out.println();
		}
	}
	
	/**
	 * 根据hashmap中各个字母的出现次数，来判断是那些数字
	 * 判断的顺序一定不能乱，如先判断Z字母出现几次，再判断W字母出现几次·····
	 * @param en_hashMap 含有所有出现字母和出现次数的map
	 * @param result_arr 结果数组(里面就是真正的电话号码所含有的数字)
	 */
	private static void find_num(HashMap<Character, Integer> en_hashMap,ArrayList<Integer> result_arr) {
		Integer show_num;//字母出现次数
		
		//先判断有几个Z，就是有几个2
		show_num = en_hashMap.get('Z');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(2);
			}
			
			//将所有的ZERO字母从map中除去
			en_hashMap.remove('Z');
			en_hashMap.put('E', en_hashMap.get('E')-show_num);
			en_hashMap.put('R', en_hashMap.get('R')-show_num);
			en_hashMap.put('O', en_hashMap.get('O')-show_num);
		}
		
		show_num = en_hashMap.get('W');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(4);
			}
			
			en_hashMap.remove('W');
			en_hashMap.put('T', en_hashMap.get('T')-show_num);
			en_hashMap.put('O', en_hashMap.get('O')-show_num);
		}
		
		show_num = en_hashMap.get('G');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(0);
			}

			en_hashMap.remove('G');
			en_hashMap.put('E', en_hashMap.get('E')-show_num);
			en_hashMap.put('I', en_hashMap.get('I')-show_num);
			en_hashMap.put('H', en_hashMap.get('H')-show_num);
			en_hashMap.put('T', en_hashMap.get('T')-show_num);
		}
		
		show_num = en_hashMap.get('X');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(8);
			}

			en_hashMap.remove('X');
			en_hashMap.put('S', en_hashMap.get('S')-show_num);
			en_hashMap.put('I', en_hashMap.get('I')-show_num);
		}
		
		show_num = en_hashMap.get('U');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(6);
			}

			en_hashMap.remove('U');
			en_hashMap.put('F', en_hashMap.get('F')-show_num);
			en_hashMap.put('O', en_hashMap.get('O')-show_num);
			en_hashMap.put('R', en_hashMap.get('R')-show_num);
		}
		
		show_num = en_hashMap.get('O');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(3);
			}

			en_hashMap.remove('O');
			en_hashMap.put('N', en_hashMap.get('N')-show_num);
			en_hashMap.put('E', en_hashMap.get('E')-show_num);
		}
		
		show_num = en_hashMap.get('S');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(9);
			}

			en_hashMap.remove('S');
			en_hashMap.put('E', en_hashMap.get('E')-show_num*2);
			en_hashMap.put('V', en_hashMap.get('V')-show_num);
			en_hashMap.put('N', en_hashMap.get('N')-show_num);
		}
		
		show_num = en_hashMap.get('R');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(5);
			}

			en_hashMap.remove('R');
			en_hashMap.put('T', en_hashMap.get('T')-show_num);
			en_hashMap.put('H', en_hashMap.get('H')-show_num);
			en_hashMap.put('E', en_hashMap.get('E')-show_num*2);
		}
		
		show_num = en_hashMap.get('F');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(7);
			}

			en_hashMap.remove('F');
			en_hashMap.put('I', en_hashMap.get('I')-show_num);
			en_hashMap.put('V', en_hashMap.get('V')-show_num);
			en_hashMap.put('E', en_hashMap.get('E')-show_num);
		}
		
		show_num = en_hashMap.get('I');
		if (show_num!=null&&show_num!=0) {
			for (int i = 0; i < show_num; i++) {
				result_arr.add(1);
			}

			en_hashMap.remove('I');
			en_hashMap.put('N', en_hashMap.get('N')-show_num*2);
			en_hashMap.put('E', en_hashMap.get('E')-show_num);
		}
	}
}
