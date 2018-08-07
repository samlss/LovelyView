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
public class BankCardActivity extends AppCompatActivity {
    private LovelyView lovelyView1;
    private LovelyView lovelyView2;
    private LovelyView lovelyView3;
    private LovelyView lovelyView4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_card);

        Toolbar toolbar = findViewById(R.id.toolbar);
        Utils.setupToolBarBackAction(this, toolbar);

        lovelyView1 = findViewById(R.id.lv_1);
        lovelyView2 = findViewById(R.id.lv_2);
        lovelyView3 = findViewById(R.id.lv_3);
        lovelyView4 = findViewById(R.id.lv_4);

        lovelyView1.getLeftImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.showToast(BankCardActivity.this, "The left image is on click...");
            }
        });

//        lovelyView1.getRightTextView().setText("right");
//        lovelyView1.getRightTextView().setTextSize(20);
//
//        lovelyView1.getRightTopTextView().setText("right");
//        lovelyView1.getRightTopTextView().setTextSize(20);
//
//        lovelyView1.getRightBottomTextView().setText("right");
//        lovelyView1.getRightBottomTextView().setTextSize(20);
//
//        lovelyView1.getLeftTopTextView().setText("left top");
//        lovelyView1.getLeftTextView().setText("left");
//        lovelyView1.getLeftBottomTextView().setText("left bottom");
//
//        lovelyView1.getLeftImageView().setImageResource(R.mipmap.icon_cab);
//        lovelyView1.getRightImageView().setImageResource(R.mipmap.icon_cab);
//
//        lovelyView1.getCenterTextView().setText("center");
    }

    public void onClick(View view) {
        Utils.showToast(this, "Item click...");
    }

}
