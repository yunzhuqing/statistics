package io.huashili.util;

import java.util.ArrayList;
import java.util.List;

public class PlatformUtil {
    private static List<Integer> platforms = new ArrayList<>();

    static {
        platforms.add(1); //微信
        platforms.add(2); //H5
    };

    public static boolean contain(int platform) {
        return platforms.contains(platform);
    }
}
