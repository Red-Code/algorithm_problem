package pers.cly.algorithm.reverse_words;

/**
 * Created by CLY on 2017/4/14.
 */

/**
 * 问题：
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */
public class Main {
    public static void main(String[] arg){
        String words = "hello world";

        System.out.println(reverseWords(words));
    }

    public static String reverseWords(String s) {
        String[] array = s.split(" ");

        String result_words = "";

        for (int i=0;i<array.length;i++){
            StringBuffer sb = new StringBuffer(array[i]);

            array[i] = sb.reverse().toString();

            result_words = result_words+array[i]+" ";
        }
        result_words = result_words.substring(0,result_words.length()-1);

        return result_words;
    }
}
