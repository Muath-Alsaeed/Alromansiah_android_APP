package com.example.alromansiah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }
    public void order1(View V){
        Intent t = new Intent(this,Order.class);
        startActivity(t);
        overridePendingTransition(R.anim.slide_right,R.anim.slide_out_left);
        finish();
    }
    public void kitchen1(View V){
        Intent t = new Intent(this,Kitchen.class);
        startActivity(t);
        overridePendingTransition(R.anim.slide_left,R.anim.slide_out_right);

        finish();
    }
}
