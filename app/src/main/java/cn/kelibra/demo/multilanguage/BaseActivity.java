package cn.kelibra.demo.multilanguage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cn.kelibra.demo.multilanguage.utils.LanguageUtil;
import cn.kelibra.demo.multilanguage.utils.SpUtil;


public abstract class BaseActivity extends AppCompatActivity {


    protected abstract int getLayoutResId();

    protected abstract void init();

    @Override
    protected void attachBaseContext(Context newBase) {
        String language = SpUtil.getString(Constant.KEY_LANGUAGE);
        Log.d("Language---get", language+"===");
        super.attachBaseContext(LanguageUtil.attachBaseContext(newBase, language));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
