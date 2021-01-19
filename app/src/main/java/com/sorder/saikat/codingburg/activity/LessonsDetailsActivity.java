package com.sorder.saikat.codingburg.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sorder.saikat.codingburg.R;

public class LessonsDetailsActivity extends AppCompatActivity {
    private TextView title,lecturer1,lecturer2,code_title1,code1,code_title2,code2,image_title1,image_title2,writer_name,date,update_time;
    private ImageView image1,image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_details);

        title = findViewById(R.id.title);
        lecturer1 = findViewById(R.id.lecturer1);
        lecturer2 = findViewById(R.id.lecturer2);
        code_title1 = findViewById(R.id.code_title1);
        code1 = findViewById(R.id.code1);
        code_title2 = findViewById(R.id.code_title2);
        code2 = findViewById(R.id.code2);
        image_title1 = findViewById(R.id.image_title1);
        image1 = findViewById(R.id.image1);
        image_title2 = findViewById(R.id.image_title2);
        image2 = findViewById(R.id.image2);
        writer_name = findViewById(R.id.writer_name);
        date = findViewById(R.id.date);
        update_time = findViewById(R.id.update_time);
        title.setText(getIntent().getExtras().getString("title"));
        lecturer1.setText(getIntent().getExtras().getString("lecturer1"));
        lecturer2.setText(getIntent().getExtras().getString("lecturer2"));
        code_title1.setText(getIntent().getExtras().getString("code_title1"));
        code1.setText(getIntent().getExtras().getString("code1"));
       code1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ClipboardManager cm = (ClipboardManager)getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
               cm.setText(code1.getText());
               Toast.makeText(getApplicationContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
           }
       });
        code_title2.setText(getIntent().getExtras().getString("code_title2"));
        code2.setText(getIntent().getExtras().getString("code2"));
        code2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cm = (ClipboardManager)getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(code2.getText());
                Toast.makeText(getApplicationContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        image_title1.setText(getIntent().getExtras().getString("image_title1"));
        Glide.with(this).load(getIntent().getExtras().getString("image1")).into(image1);
        try{
            if(getIntent().getExtras().getString("image2").equals(null)){
                image2.setVisibility(View.GONE);
            }
            else {
                Glide.with(this).load(getIntent().getExtras().getString("image2")).into(image2);
            }
        } catch (Exception e) {
            image2.setVisibility(View.GONE);
            e.printStackTrace();
        }

        image_title2.setText(getIntent().getExtras().getString("image_title2"));
        writer_name.setText(getIntent().getExtras().getString("writer_name"));
        date.setText(getIntent().getExtras().getString("date"));
        update_time.setText(getIntent().getExtras().getString("update_time"));

    }
}