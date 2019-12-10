package cn.kelibra.demo.multilanguage;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.kelibra.demo.multilanguage.utils.SpUtil;


public class LanguageChooseActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {
    RecyclerView mRecyclerview;
    private ArrayList<LanguageBean> languageList;
    private MyAdapter mAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_languagechoose;
    }

    @Override
    protected void init() {
        mRecyclerview = findViewById(R.id.recyclerview);
        initLaunguageData();
        initRecyclerView();
    }

    private void initLaunguageData() {
        languageList = new ArrayList<>();
        //跟随系统
//        languageList.add(new LanguageBean(getString(R.string.auto), ""));
        //汉语
        languageList.add(new LanguageBean(getString(R.string.zh), "zh"));
        //英语
        languageList.add(new LanguageBean(getString(R.string.en), "en"));
        //日语
        languageList.add(new LanguageBean(getString(R.string.ja), "ja"));
        //泰语
        languageList.add(new LanguageBean(getString(R.string.th), "th"));
        //韩语
        languageList.add(new LanguageBean(getString(R.string.ko), "ko"));
        //法语
        languageList.add(new LanguageBean(getString(R.string.fr), "fr"));
        //德语
        languageList.add(new LanguageBean(getString(R.string.de), "de"));
        //俄语
        languageList.add(new LanguageBean(getString(R.string.ru), "ru"));
        //西班牙语
        languageList.add(new LanguageBean(getString(R.string.es), "es"));

    }

    private void initRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.setHasFixedSize(true);
        mAdapter = new MyAdapter();
        mAdapter.bindToRecyclerView(mRecyclerview);
        mRecyclerview.setAdapter(mAdapter);
        mAdapter.setOnItemChildClickListener(this);
        mAdapter.setNewData(languageList);

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        String localeName = mAdapter.getData().get(position).getLocaleName();
        SpUtil.putString(Constant.KEY_LANGUAGE, localeName);
        Log.d("Language---put", localeName+"===");
        setResult(RESULT_OK);
        finish();
    }
}
