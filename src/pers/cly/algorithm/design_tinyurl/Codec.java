package pers.cly.algorithm.design_tinyurl;

import java.util.ArrayList;

/**
 * Created by CLY on 2017/4/15.
 */
public class Codec {
    ArrayList<String> arrayList = new ArrayList();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        arrayList.add(longUrl);
        return "http://tinyurl.com/"+(arrayList.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] s = shortUrl.split("ttp://tinyurl.com/");

        int index = Integer.parseInt(s[1]);
        String origin_url = arrayList.get(index);
        return origin_url;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
