package com.iigo.lovelyview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startWeChatSettings(View view) {
        startActivity(new Intent(this, WeChatMeActivity.class));
    }

    public void startCardBand(View view) {
        startActivity(new Intent(this, BankCardActivity.class));
    }

    public void startCustom(View view) {
        startActivity(new Intent(this, CustomActivity.class));
    }
}
