package cn.kelibra.demo.multilanguage;

import android.app.Application;
import android.content.Context;


public class MultiLanguageApp extends Application {
    private static MultiLanguageApp INSTANCE;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static MultiLanguageApp getINSTANCE() {
        return INSTANCE;
    }

}
