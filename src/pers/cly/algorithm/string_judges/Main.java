/**
 * Created by CLY on 2017年4月17日.
 */
package pers.cly.algorithm.string_judges;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * @author CLY
 *
 */
/**
 * 问题
判断字符串b的所有字符是否都在字符串a中出现过，a、b都是可能包含汉字的字符串。b中重复出现的汉字，那么a中也要至少重复相同的次数。汉字使用gbk编码（简单的说，用两个字节表示一个汉字，高字节最高位为1的代表汉字，低字节最高位可以不为1）。
        int is_include(char *a, char *b); 
  返回0表示没有都出现过，返回1表示都出现过。 
请设计一个算法。


								
输入
字符串a\n字符串b
样例输入
aaaabbbcccdddss
abc

输出
0或者1
样例输出
1
 */
public class Main {

	public static void main(String[] args)throws IOException {
		//第一个int存的是某字节的ASCII码，第二个int存的是该字节出现的次数
		HashMap<Integer, Integer> hashMap_a = new HashMap<>();
		HashMap<Integer, Integer> hashMap_b = new HashMap<>();
		int s_byte;//每一个字节的ASCII码
		int result = 1;
		
		//将第一行个字节的ASCII码存入map
		while ((s_byte = System.in.read())!='\n') {
			Integer now_appear_num = hashMap_a.get(s_byte);
			
			if (now_appear_num!=null) {
				hashMap_a.put(s_byte,now_appear_num+1);
			}else {
				hashMap_a.put(s_byte, 1);
			}
		}

		//将第二行个字节的ASCII码存入map
		while ((s_byte = System.in.read())!='\n') {

			Integer now_appear_num = hashMap_b.get(s_byte);
			
			if (now_appear_num!=null) {
				hashMap_b.put(s_byte,now_appear_num+1);
			}else {
				hashMap_b.put(s_byte, 1);
			}
		}
		
		Iterator<Entry<Integer, Integer>> it_b = hashMap_b.entrySet().iterator();

		//看b中的每一项是否在a中也有，并且数量也够
        while(it_b.hasNext()){
        	Entry<Integer, Integer> entry_b = it_b.next();
        	int asc_b = entry_b.getKey();
        	int num_b = entry_b.getValue();
        	
        	//b字符串中某字符在a字符串中的个数
        	Integer num_a = hashMap_a.get(asc_b);

        	if (num_a==null||num_a<num_b) {
				result=0;
				break;
			}
        }

        System.out.println(result);
	}
}
