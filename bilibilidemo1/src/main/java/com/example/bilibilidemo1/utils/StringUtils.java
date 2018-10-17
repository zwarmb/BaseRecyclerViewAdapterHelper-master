package com.example.bilibilidemo1.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yida on 2018/3/2.
 */

public class StringUtils {
    public static String[] returnImageUrlsFormHtml(String htmlUrl) {
        List<String> imageList = new ArrayList<>();
        Pattern p = Pattern.compile("\"<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n" +
                "\n" +
                "\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|" +
                "\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic|\\b)\\b)[^>]*>",
                Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(htmlUrl);
        String quote = null;
        String src = null;

        while (m.find()) {
            quote = m.group(1);
            src = (quote == null || quote.trim().length() == 0) ? m.group(2).split("//s+")[0] : m.group(2);
            Log.e("qq  图片地址 ", src.toString());
            imageList.add(src);
        }
        if (imageList == null || imageList.size() == 0) {
            Log.e("imagelist", "未在网页中找到图片链接");
            return null;
        }
        return imageList.toArray(new String[imageList.size()]);
    }
}
