package com.iigo.lovelyview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.iigo.library.LovelyView;

/**
 * @author SamLeung
 * @e-mail 729717222@qq.com
 * @github https://github.com/samlss
 * @csdn https://blog.csdn.net/Samlss
 * @description The settings of wechat.
 */
public class WeChatMeActivity extends AppCompatActivity {
    private LovelyView lovelyView1;
    private LovelyView lovelyView2;
    private LovelyView lovelyView3;
    private LovelyView lovelyView4;
    private LovelyView lovelyView5;
    private LovelyView lovelyView6;
    private LovelyView lovelyView7;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_me);

        Toolbar toolbar = findViewById(R.id.toolbar);
        Utils.setupToolBarBackAction(this, toolbar);

        lovelyView1 = findViewById(R.id.lv_1);
        lovelyView2 = findViewById(R.id.lv_2);
        lovelyView3 = findViewById(R.id.lv_3);
        lovelyView4 = findViewById(R.id.lv_4);
        lovelyView5 = findViewById(R.id.lv_5);
        lovelyView6 = findViewById(R.id.lv_6);
        lovelyView7 = findViewById(R.id.lv_7);
    }

    public void onClick(View view) {
        Utils.showToast(this, "Item click...");
    }

}
