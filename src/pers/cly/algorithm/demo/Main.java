/**
 * Created by CLY on 2017年4月16日.
 */
package pers.cly.algorithm.demo;

import java.util.Scanner;

/**
 * @author CLY
 *
 */
/**
 * 测试类
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();

		//连续输入n个数
//		int n = Integer.parseInt(scanner.nextLine());
//		
//		String[] arr = new String[n];
//		for(int i=0;i<n;i++){
//			arr[i] = scanner.nextLine();
//		}
		
		int i = fun1(line1,line2);
		String s = fun2(line1,line2);
		
		String string = null;
		System.out.println(string);
	}
	
	private static int fun1(String line1,String line2) {
		return 0;
	}
	
	private static String fun2(String line1,String line2) {
		return null;
	}
}
