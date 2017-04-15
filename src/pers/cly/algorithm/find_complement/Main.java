package pers.cly.algorithm.find_complement;

/**
 * Created by CLY on 2017/4/15.
 */

/**
 * question：
 Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Note:
 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.
 */
public class Main {
    public static void main(String[] args){
        int num=5;

        int result = findComplement(num);
        System.out.println(result);
    }

    public static int findComplement(int num) {
        String binary = Integer.toBinaryString(num);

        String result_binary="";
        for (int i=0;i<binary.length();i++){
            switch (binary.charAt(i)){
                case '1':
                    result_binary = result_binary+"0";
                    break;
                case '0':
                    result_binary = result_binary+"1";
                    break;
            }
        }

        int result_num = Integer.parseInt(result_binary,2);
        return result_num;
    }
}
