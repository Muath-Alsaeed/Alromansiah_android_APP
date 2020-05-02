package com.example.alromansiah;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Choice1 (View V){
        Intent t = new Intent(this,Choice.class);
        startActivity(t);
        overridePendingTransition(R.anim.slide_right,R.anim.slide_out_left);
        finish();
    }
}
