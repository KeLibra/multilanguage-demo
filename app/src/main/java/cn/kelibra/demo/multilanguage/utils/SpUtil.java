package cn.kelibra.demo.multilanguage.utils;

import android.content.Context;
import android.content.SharedPreferences;

import cn.kelibra.demo.multilanguage.MultiLanguageApp;


public class SpUtil {

    private SpUtil() {

    }

    private static volatile SharedPreferences sSP;

    private static final String PREFERENCE_NAME = "preference_name";

    private static SharedPreferences createSp() {
        if (sSP == null) {
            synchronized (SpUtil.class) {
                if (sSP == null) {
                    sSP = MultiLanguageApp.getINSTANCE().getSharedPreferences(PREFERENCE_NAME,
                            Context.MODE_PRIVATE);
                }
            }
        }
        return sSP;
    }

    public static void clear() {
        createSp().edit().clear().apply();
    }

    public static void remove(String key) {
        createSp().edit().remove(key).apply();
    }

    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = createSp().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(String key) {
        return createSp().getString(key, "");
    }
}
