package com.example.teamresume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResumeActivity extends AppCompatActivity {

    private Integer itemId;
    private String[] item;
    private TextView re_skill;
    private TextView re_name;
    private TextView re_age;
    private TextView re_gender;
    private TextView re_remark;
    private ImageView re_avatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);


        re_skill = findViewById(R.id.re_skill);
        re_name = findViewById(R.id.re_name);
        re_age = findViewById(R.id.re_age);
        re_gender = findViewById(R.id.re_gender);
        re_remark = findViewById(R.id.re_remark);
        re_avatar = findViewById(R.id.re_avatar);

        //set data which are getting from bundle
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        re_name.setText((String) bundle.get("ItemName"));
        re_age.setText((String) bundle.get("ItemAge"));
        re_gender.setText((String) bundle.get("ItemGender"));
        re_skill.setText((String) bundle.get("ItemSkill"));
        re_remark.setText((String) bundle.get("ItemRemark"));
        re_avatar.setImageResource((Integer) bundle.get("ItemImage"));

        //set titileBar style to goback home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(re_remark.getText());
    }

    //go back action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}