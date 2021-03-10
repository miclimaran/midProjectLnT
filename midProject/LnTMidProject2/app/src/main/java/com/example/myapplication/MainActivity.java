package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mb;
    int ctr=1;
    String typekendaraan;
    String typeMobil = "Mobil";
    String typeMotor = "Motor";
    String brand;
    String name;
    String license;
    String topspeed;
    String gascapacity;
    String wheel;
    String Type;
    String ESA;
    String brandExpression = "[a-zA-Z]{5,100}+";
    String nameExpression = "[a-zA-Z]{5,100}+";
    String licenseExpression = "[A-Z]+ [0-9]{1,4}+ [A-Z]{1,3}+";
    String topspeedExpression = "[100-250]+";
    String gascapacityExpression = "[30-60]+";
    String wheelExpression;
    String ESAcarExpression = "[0-9]{1,10}+";
    String helmmotorExpression = "[1-10]+";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mb.getRoot();
        setContentView(view);

        Intent intent = new
                Intent(MainActivity.this,
                MainActivity2.class);

        mb.btnSavetype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typekendaraan = mb.typekendaraan.getEditableText().toString().trim();

                if(typekendaraan.equals(typeMobil)){
                    mb.type.setHint("[SUV/Supercar/Minivan]:");
                    mb.ESA.setText("Entertainment System amount:");
                    wheelExpression = "[4-6]+";
                }
                else if(typekendaraan.equals(typeMotor)){
                    mb.type.setHint("[Automatic/Manual]:");
                    mb.ESA.setText("Helm amount:");
                    wheelExpression = "[2-3]+";
                }
                else{
                    mb.typekendaraan.setError("Tidak Sesuai");
                }
            }
        });

        mb.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                brand = mb.brand.getEditableText().toString();
                name = mb.name.getEditableText().toString();
                license = mb.license.getEditableText().toString();
                topspeed = mb.topspeed.getEditableText().toString();
                gascapacity = mb.gascapacity.getEditableText().toString();
                wheel = mb.wheel.getEditableText().toString();
                Type = mb.type.getEditableText().toString();
                ESA = mb.entertainment.getEditableText().toString();

                    ctr = 1;
                    if (!brand.trim().matches(brandExpression)) {
                        mb.brand.setError("Tidak Sesuai");
                        ctr = 0;
                    }
                    if (!name.trim().matches(nameExpression)) {
                        mb.name.setError("Tidak Sesuai");
                        ctr = 0;
                    }
                    if (!license.trim().matches(licenseExpression)) {
                        mb.license.setError("Tidak Sesuai");
                        ctr = 0;
                    }
                    if (!topspeed.trim().matches(topspeedExpression)) {
                        mb.topspeed.setError("Tidak Sesuai");
                        ctr = 0;
                    }
                    if (!gascapacity.trim().matches(gascapacityExpression)) {
                        mb.gascapacity.setError("Tidak Sesuai");
                        ctr = 0;
                    }
                    if (!wheel.trim().matches(wheelExpression)) {
                        mb.wheel.setError("Tidak Sesuai");
                        ctr = 0;
                    }
                    if (!ESA.trim().matches(ESAcarExpression)) {
                        mb.entertainment.setError("Tidak Sesuai");
                        ctr = 0;
                    }

                    if (!typekendaraan.isEmpty()) {
                        intent.putExtra("typekendaraan", typekendaraan);
                    }
                    if (!brand.isEmpty()) {
                        intent.putExtra("Brand", brand);
                    }
                    if (!name.isEmpty()) {
                        intent.putExtra("Name", name);
                    }
                    if (!license.isEmpty()) {
                        intent.putExtra("License", license);
                    }
                    if (!topspeed.isEmpty()) {
                        intent.putExtra("Top Speed", topspeed);
                    }
                    if (!gascapacity.isEmpty()) {
                        intent.putExtra("Gas Capacity", gascapacity);
                    }
                    if (!wheel.isEmpty()) {
                        intent.putExtra("Wheel", wheel);
                    }
                    if (!Type.isEmpty()) {
                        intent.putExtra("Type", Type);
                    }
                    if (!ESA.isEmpty()) {
                        intent.putExtra("ESA", ESA);
                    }

                    if (ctr == 1) {
                        startActivity(intent);
                    }


            }
        });
    }
}
