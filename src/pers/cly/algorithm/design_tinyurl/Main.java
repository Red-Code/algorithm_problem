package pers.cly.algorithm.design_tinyurl;

/**
 * Created by CLY on 2017/4/15.
 */

/**
 * question：
 TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class Main {
    public static void main(String[] arg){
        String origin_url = "https://leetcode.com/problems/design-tinyurl";
        String encode_url;
        String decode_url;

        Codec codec = new Codec();
        encode_url = codec.encode(origin_url);
        decode_url = codec.decode(encode_url);

        System.out.println(origin_url);
        System.out.println(encode_url);
        System.out.println(decode_url);
    }
}
