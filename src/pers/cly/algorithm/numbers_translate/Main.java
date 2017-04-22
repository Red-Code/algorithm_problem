/**
 * Created by CLY on 2017年4月21日.
 */
package pers.cly.algorithm.numbers_translate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
题目描述						
小B最近对电子表格产生了浓厚的兴趣，她觉得电子表格很神奇，功能远比她想象的强大。
她正在研究的是单元格的坐标编号，她发现表格单元一般是按列编号的，第1列编号为A，第2列为B，以此类推，第26列为Z。
之后是两位字符编号的，第27列编号为AA，第28列为AB，第52列编号为AZ。之后则是三位、四位、五位……字母编号的，规则类似。
表格单元所在的行则是按数值从1开始编号的，表格单元名称则是其列编号和行编号的组合，如单元格BB22代表的单元格为54列中第22行的单元格。
小B感兴趣的是，编号系统有时也可以采用RxCy的规则，其中x和y为数值，表示单元格位于第x行的有第y列。
上述例子中的单元格采用这种编码体系时的名称为R22C54。
小B希望快速实现两种表示之间的转换，请你帮忙设计程序将一种方式表示的坐标转换为另一种方式。
								
输入
输入的第一行为一个正整数T，表示有T组测试数据（1<=T<=10^5）。
随后的T行中，每行为一组测试数据，为一种形式表示的单元格坐标。
保证所有的坐标都是正确的，且所有行列坐标值均不超过10^6。
样例输入
2
R23C55
BC23

输出
对每组测试数据，单独输出一行，为单元格坐标的另一种表示形式。
样例输出
BC23
R23C55
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i =0;i<t;i++){
			String data = scanner.next();
			//2
			//R23C55
			//BC23
			if (is_RxCy(data)) {
				int[] arr = analysis_rxcy(data);
				int x = arr[0];
				int y = arr[1];
				String s_y = translate_num(y).toString();
				
				System.out.println(s_y+x);
				
			}else {
				String[] arr = analysis_enNum(data);
				int x = Integer.parseInt(arr[0]);
				String y = arr[1];
				int int_y = translate_en(y);
				String result = "R"+x+"C"+int_y;
				System.out.println(result);
			}
		}
	}
	
	/**
	 * 判断字符串是否为RxCy形式
	 * @param data 待查字符串
	 * @return true为是RxCy形式
	 */
	private static boolean is_RxCy(String data) {
		String reg = "R[0-9]+C[0-9]+";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(data);
		boolean rs = matcher.find();
		
		return rs;
	}
	
	/**
	 * 传入RxCy格式的数据，获取行数和列数
	 * @param data
	 * @return int[0]为行数，int[1]为列数
	 */
	private static int[] analysis_rxcy(String data) {
		int[] arr = new int[2];
		
		String reg = "[0-9]+";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(data);

		for(int i=0;i<2;i++){
			matcher.find();
			arr[i] = Integer.parseInt(matcher.group());
		}
		
		return arr;
	}
	
	/**
	 * 传入英文加数字的格式
	 * @param data
	 * @return String[0]为行数,String[1]为列数
	 */
	private static String[] analysis_enNum(String data) {
		String reg_en = "[A-Z]+";
		String reg_num = "[0-9]+";
		
		Matcher matcher_en = Pattern.compile(reg_en).matcher(data);
		Matcher matcher_num = Pattern.compile(reg_num).matcher(data);
		matcher_en.find();
		matcher_num.find();
		
		String[] arr = {matcher_num.group(),matcher_en.group()};
		return arr;
	}
	
	private static int translate_en(String en) {
		
		int len = en.length();
		int result=0;
		for(int i=len-1,j=0;i>=0;i--,j++){
			char letter = en.charAt(i);
			switch (letter) {
			case 'A':
				result+=(1*Math.pow(26, j));
				break;
			case 'B':
				result+=(2*Math.pow(26, j));
				break;
			case 'C':
				result+=(3*Math.pow(26, j));
				break;
			case 'D':
				result+=(4*Math.pow(26, j));
				break;
			case 'E':
				result+=(5*Math.pow(26, j));
				break;
			case 'F':
				result+=(6*Math.pow(26, j));
				break;
			case 'G':
				result+=(7*Math.pow(26, j));
				break;
			case 'H':
				result+=(8*Math.pow(26, j));
				break;
			case 'I':
				result+=(9*Math.pow(26, j));
				break;
			case 'J':
				result+=(10*Math.pow(26, j));
				break;
			case 'K':
				result+=(11*Math.pow(26, j));
				break;
			case 'L':
				result+=(12*Math.pow(26, j));
				break;
			case 'M':
				result+=(13*Math.pow(26, j));
				break;
			case 'N':
				result+=(14*Math.pow(26, j));
				break;
			case 'O':
				result+=(15*Math.pow(26, j));
				break;
			case 'P':
				result+=(16*Math.pow(26, j));
				break;
			case 'Q':
				result+=(17*Math.pow(26, j));
				break;
			case 'R':
				result+=(18*Math.pow(26, j));
				break;
			case 'S':
				result+=(19*Math.pow(26, j));
				break;
			case 'T':
				result+=(20*Math.pow(26, j));
				break;
			case 'U':
				result+=(21*Math.pow(26, j));
				break;
			case 'V':
				result+=(22*Math.pow(26, j));
				break;
			case 'W':
				result+=(23*Math.pow(26, j));
				break;
			case 'X':
				result+=(24*Math.pow(26, j));
				break;
			case 'Y':
				result+=(25*Math.pow(26, j));
				break;
			case 'Z':
				result+=(26*Math.pow(26, j));
				break;
			default:
				break;
			}
		}
		
		return result;
	}
	
	private static StringBuffer translate_num(int data) {
		StringBuffer result = new StringBuffer("");
		int surplus;
		int rs;
		do {
			surplus = data%26;
			data = data/26;
			if (surplus==0) {
				data-=1;
				surplus=26;
			}
			switch (surplus) {
			case 1:
				result.insert(0, "A");
				break;
			case 2:
				result.insert(0, "B");
				break;
			case 3:
				result.insert(0, "C");
				break;
			case 4:
				result.insert(0, "D");
				break;
			case 5:
				result.insert(0, "E");
				break;
			case 6:
				result.insert(0, "F");
				break;
			case 7:
				result.insert(0, "G");
				break;
			case 8:
				result.insert(0, "H");
				break;
			case 9:
				result.insert(0, "I");
				break;
			case 10:
				result.insert(0, "J");
				break;
			case 11:
				result.insert(0, "K");
				break;
			case 12:
				result.insert(0, "L");
				break;
			case 13:
				result.insert(0, "M");
				break;
			case 14:
				result.insert(0, "N");
				break;
			case 15:
				result.insert(0, "O");
				break;
			case 16:
				result.insert(0, "P");
				break;
			case 17:
				result.insert(0, "Q");
				break;
			case 18:
				result.insert(0, "R");
				break;
			case 19:
				result.insert(0, "S");
				break;
			case 20:
				result.insert(0, "T");
				break;
			case 21:
				result.insert(0, "U");
				break;
			case 22:
				result.insert(0, "V");
				break;
			case 23:
				result.insert(0, "W");
				break;
			case 24:
				result.insert(0, "X");
				break;
			case 25:
				result.insert(0, "Y");
				break;
			case 26:
				result.insert(0, "Z");
				break;
			default:
				break;
			}
		} while (data!=0);

		return result;
	}
}
