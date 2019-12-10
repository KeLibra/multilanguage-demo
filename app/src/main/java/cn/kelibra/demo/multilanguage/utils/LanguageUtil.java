package cn.kelibra.demo.multilanguage.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import java.util.Locale;

import androidx.annotation.RequiresApi;

public class LanguageUtil {

    public static Context attachBaseContext(Context context, String language) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale;
        if (TextUtils.isEmpty(language)) {//如果没有指定语言使用系统首选语言
            locale = getSystemFirstLanguage();
        } else {//指定了语言使用指定语言，没有则使用首选语言
            locale = new Locale(language);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        } else {
            configuration.locale = locale;
            DisplayMetrics dm = resources.getDisplayMetrics();
            resources.updateConfiguration(configuration, dm);
            return context;
        }
    }


    /**
     * 获取系统首选语言
     *
     * @return Locale
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static Locale getSystemFirstLanguage() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        return locale;
    }
}
