/**
 * Created by CLY on 2017年4月23日.
 */
package pers.cly.algorithm.birthday_gift;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
题目描述
									
BF的生日快到了，这一次，小东决定为BF送一份特别的生日礼物为其庆生。
作为高智商中的佼佼者，BF在国外求学，因此小东无法与之一起庆生。小东计划送一个生日卡片，并通过特别的包装让BF永远难忘。

她决定把卡片套装在一系列的信封A = {a1,  a2,  ...,  an}中。
小东已经从商店中购买了很多的信封，她希望能够用手头中尽可能多的信封包装卡片。
为防止卡片或信封被损坏，只有长宽较小的信封能够装入大些的信封，同尺寸的信封不能套装，卡片和信封都不能折叠。

小东计算了邮寄的时间，发现她的时间已经不够了，为此找你帮忙包装，你能帮她吗？
								
输入
输入有若干组，每组的第一行包含三个整数n, w, h，1<=n<=5000, 1<=w, h<=10^6，分别表示小东手头的信封数量和卡片的大小。
紧随其后的n行中，每行有两个整数wi和hi，为第i个信封的大小，1<=wi, hi<=10^6。
样例输入
2 1 1
2 2
2 2
3 3 3
5 4
12 11
9 8

输出
对每组测试数据，结果第一行中输出最多能够使用的信封数量，结果第二行中按使用顺序输出信封的编号。
由于小东有洁癖，她对排在前面的信封比较有好感，若有多个信封可用，她喜欢用最先拿到的信封。
另外别忘了，小东要求把卡片装入能够装的最小信封中。
如果卡片无法装入任何信封中，则在单独的行中输出0。

样例输出
1
1
3
1 3 2
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int line_num = scanner.nextInt();
			long card_x_size= scanner.nextLong();
			int card_y_size = scanner.nextInt();
			
			ArrayList<Entry> sumList = new ArrayList<>();
			for (int i = 0; i < line_num; i++) {
				long now_x = scanner.nextLong();
				int now_y = scanner.nextInt();
				//信封必须大于卡片
				if (now_x>card_x_size&&now_y>card_y_size) {
					Entry now_entry = new Entry();
					now_entry.set_index(i+1);
					now_entry.set_mailer_x_size(now_x);
					now_entry.set_mailer_y_size(now_y);
					sumList.add(now_entry);
					
					//将当前entry与以存的entry进行大小的比较
					for(Entry old_entry :sumList){
						long old_x = old_entry.get_mailer_x_size();
						int old_y = old_entry.get_mailer_y_size();
						if (old_x>now_x&&old_y>now_y) {//旧信封比当前信封大
							now_entry.get_more_big_entry().add(old_entry);
						}else if (now_x>old_x&&now_y>old_y) {//当前信封比旧信封大
							old_entry.get_more_big_entry().add(now_entry);
						}
					}
				}
			}
			
			Entry start_mail=null;
			int sum = 0;
			//如果有比信件大的信封
			if (sumList.size()>=1) {
				Iterator<Entry> iterator = sumList.iterator();
				//先计算第一个entry的最优嵌套数，然后再和其他entry的最优嵌套数比对
				do {
					Entry now_entry = iterator.next();
					
					int now_len = now_entry.get_best_len();
					
					if (now_len!=0) {//拥有最优嵌套数
						if (now_len>sum) {
							sum = now_len;
							start_mail = now_entry;
						}
					}else {//还未计算最优嵌套数，现在计算
						now_len = calculate_best_len(now_entry);
						if (now_len>sum) {
							sum = now_len;
							start_mail = now_entry;
						}
					}
				} while (iterator.hasNext());
				
				System.out.println(sum);
				System.out.print(start_mail.get_index()+" ");
				Entry next_entry = start_mail.get_best_choose();
				while (next_entry!=null) {
					System.out.print(next_entry.get_index()+" ");
					next_entry = next_entry.get_best_choose();
				}
			}else {//没有合适的信封
				System.out.println(sum);
			}
		}
	}
	/**
	 * 计算某entry的最优嵌套数
	 * @param arrayList
	 * @return 最优嵌套数
	 */
	private static int calculate_best_len(Entry target_entry) {
		ArrayList<Entry> arrayList = target_entry.get_more_big_entry();
		int target_best_len=1;
		Entry target_best_choose=null;
		
		//如果target_entry拥有子list（比他大的entry），则迭代找到最大的len
		for (Entry entry : arrayList) {
			int son_best_len = entry.get_best_len();
			
			//如果该子entry也没有最优嵌套数，则先计算他的最优嵌套数
			if (son_best_len==0) {
				son_best_len = calculate_best_len(entry);
			}
			son_best_len++;//加上本entry后的总嵌套数
			
			if (son_best_len>target_best_len) {
				target_best_len = son_best_len;
				target_best_choose = entry;
			}
		}
		
		target_entry.set_best_choose(target_best_choose);
		target_entry.set_best_len(target_best_len);
		
		return target_best_len;
	}
}

class Entry{
	int index;//是第几个出现的
	long mailer_x_size;
	int mailer_y_size;
	ArrayList<Entry> more_big_entry;
	Entry best_choose;//选择哪一个信封可以达到最多嵌套数
	int best_len;//当选择了当前卡片后，前套数最多能加几（当前entry如果没有计算过,则为0，计算过后至少为1）
	
	public Entry() {
		this.index=0;
		this.mailer_x_size=0;
		this.mailer_y_size=0;
		this.best_len = 0;
		this.best_choose = null;
		this.more_big_entry= new ArrayList<>();
	}
	
	public void set_index(int index) {
		this.index=index;
	}
	public void set_mailer_x_size(long mailer_x_size) {
		this.mailer_x_size=mailer_x_size;
	}
	public void set_mailer_y_size(int mailer_y_size) {
		this.mailer_y_size=mailer_y_size;
	}
	public void set_best_choose(Entry entry) {
		this.best_choose = entry;
	}
	public void set_best_len(int best_len) {
		this.best_len = best_len;
	}
	
	public int get_index() {
		return this.index;
	}
	public long get_mailer_x_size() {
		return this.mailer_x_size;
	}
	public int get_mailer_y_size() {
		return this.mailer_y_size;
	}
	public ArrayList<Entry> get_more_big_entry() {
		return this.more_big_entry;
	}
	public Entry get_best_choose() {
		return this.best_choose;
	}
	public int get_best_len() {
		return this.best_len;
	}
}