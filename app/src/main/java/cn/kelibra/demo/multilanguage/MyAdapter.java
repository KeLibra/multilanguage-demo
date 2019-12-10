package cn.kelibra.demo.multilanguage;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import androidx.annotation.NonNull;


public class MyAdapter extends BaseQuickAdapter<LanguageBean, BaseViewHolder> {
    public MyAdapter() {
        super(R.layout.layout_adapter_item);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, LanguageBean item) {
        helper.setText(R.id.tv_type, item.getRealName());
        helper.addOnClickListener(R.id.click_parent);

    }
}
