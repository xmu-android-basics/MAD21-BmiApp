package io.github.xmu_android_basics.bmiapp_2021;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA");

        System.out.println(message + "===");
    }
}