package pers.cly.algorithm.hamming_distance;

/**
 * Created by CLY on 2017/4/14.
 */

/**
 * 要求：
     The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

     Given two integers x and y, calculate the Hamming distance.

     Note:
     0 ≤ x, y < 2^31
 */
public class Main {
    public static void main(String[] arg){
        int num = hammingDistance(1,4);

        System.out.println(num);
    }

    public static int hammingDistance(int x, int y) {
        if (x<0||y<0){
            return 0;
        }

        int z = x^y;

        int num=0;

        String two_z = Integer.toBinaryString(z);
        for (int i=0;i<two_z.length();i++){
            if (two_z.charAt(i)=='1'){
                num++;
            }
        }
        return num;
    }
}
