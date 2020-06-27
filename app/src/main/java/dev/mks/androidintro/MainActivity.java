package dev.mks.androidintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String [] title = {"Ubuntu","WindowOS","MacOS","Android","Linux"};
    String [] desc = {"2000","2001","2002","2003","2004"};

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list_view);

        sharedPreferences = getSharedPreferences("MYPRE",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        MyCustomAdapter adapter = new MyCustomAdapter (title,desc);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               editor.putString("title",title[position]);
               editor.apply();

                Intent i = new Intent(MainActivity.this,DetailActivity.class);
//                i.putExtra("title",title[position]);
//                i.putExtra("desc",desc[position]);
                startActivity(i);
            }
        });
    }
}