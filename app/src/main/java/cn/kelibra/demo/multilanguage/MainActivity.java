package cn.kelibra.demo.multilanguage;

import android.content.Intent;
import android.view.View;
import android.widget.Button;



public class MainActivity extends BaseActivity {

    Button mBtChange;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_main;
    }

    @Override
    protected void init() {
        mBtChange = findViewById(R.id.bt_change);

        mBtChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, LanguageChooseActivity.class), 2);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
        }
    }
}
