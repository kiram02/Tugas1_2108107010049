package com.example.savebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView textView_name, textView_npm, textView_jurusan;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_NPM = "npm";
    private static final String KEY_JURUSAN = "jurusan";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView_name = findViewById(R.id.text_fullname);
        textView_npm = findViewById(R.id.text_npm);
        textView_jurusan = findViewById(R.id.text_jurusan);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);
        String npm = sharedPreferences.getString(KEY_NPM,null);
        String jurusan = sharedPreferences.getString(KEY_JURUSAN,null);

        if (name != null || npm != null || jurusan != null){
            textView_name.setText("Nama : "+name);
            textView_npm.setText("NPM : "+npm);
            textView_jurusan.setText("Jurusan : "+jurusan);
        }



    }
}