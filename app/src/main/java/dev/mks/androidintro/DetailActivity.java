package dev.mks.androidintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tv;
    String title,desc;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv = findViewById(R.id.textView);
        sharedPreferences = getSharedPreferences("MYPRE",MODE_PRIVATE);
//        Intent intent = getIntent();
//        title = intent.getStringExtra("title");
//        desc = intent.getStringExtra("desc");

        title = sharedPreferences.getString("title","Default Value");

        tv.setText(title);
    }
}