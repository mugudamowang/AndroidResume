package com.example.teamresume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ResumeActivity extends AppCompatActivity {

    private Integer itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        Intent intent = getIntent();
        itemId = intent.getIntExtra("id", 0);
        Toast.makeText(ResumeActivity.this, itemId, Toast.LENGTH_LONG).show();
    }
}