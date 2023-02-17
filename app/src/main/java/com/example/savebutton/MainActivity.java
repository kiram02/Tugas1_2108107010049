package com.example.savebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_name, editText_npm, editText_jurusan;
    Button button_save;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_NPM = "npm";
    private static final String KEY_JURUSAN = "jurusan";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.editext_name);
        editText_npm = findViewById(R.id.editext_npm);
        editText_jurusan = findViewById(R.id.editext_jurusan);
        button_save = findViewById(R.id.button_save);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);

        if (name != null){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);

        }



        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when click a button pu data on shared preferences...
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,editText_name.getText().toString());
                editor.putString(KEY_NPM,editText_npm.getText().toString());
                editor.putString(KEY_JURUSAN,editText_jurusan.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

            }
        });


    }
}