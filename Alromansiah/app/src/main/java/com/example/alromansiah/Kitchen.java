package com.example.alromansiah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kitchen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
    }

    public void delat_activey(View V){
        Intent t = new Intent(this,Delete.class);
        startActivity(t);
        overridePendingTransition(R.anim.slide_right,R.anim.slide_out_left);

        finish();
    }
    public void updet_activey(View V){
        Intent t = new Intent(this,update.class);
        startActivity(t);
        overridePendingTransition(R.anim.slide_left,R.anim.slide_out_right);

        finish();
    }

    public void show_activey(View V){

        Intent t = new Intent(this,show.class);
        startActivity(t);

        finish();
    }
    public void go_back(View V){
        Intent t = new Intent(this,Choice.class);
        startActivity(t);
        overridePendingTransition(R.anim.slide_right,R.anim.slide_out_left);

        finish();
    }
}