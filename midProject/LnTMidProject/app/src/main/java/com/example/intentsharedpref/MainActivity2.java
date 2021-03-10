package com.example.intentsharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.intentsharedpref.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding mb2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb2 = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = mb2.getRoot();
        setContentView(view);

        mb2.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        mb2.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}