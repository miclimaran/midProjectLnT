package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding mb2;
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
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mb2 = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = mb2.getRoot();
        setContentView(view);
        typekendaraan = getIntent().getExtras().getString("typekendaraan", "None");
        brand = getIntent().getExtras().getString("Brand", "None");
        name = getIntent().getExtras().getString("Name", "None");
        license = getIntent().getExtras().getString("License", "None");
        topspeed = getIntent().getExtras().getString("Top Speed", "None");
        gascapacity = getIntent().getExtras().getString("Gas Capacity", "None");
        wheel = getIntent().getExtras().getString("Wheel", "None");
        Type = getIntent().getExtras().getString("Type", "None");
        ESA = getIntent().getExtras().getString("ESA", "None");

        if (typekendaraan.equals(typeMobil)) {
            if(Type.equals("SUV")){
                Toast.makeText(getApplicationContext(),"Turning on entertainment system...",Toast.LENGTH_SHORT).show();
            }
            if(Type.equals("Minivan")){
                Toast.makeText(getApplicationContext(),"Turning on entertainment system...",Toast.LENGTH_SHORT).show();
            }
            if(Type.equals("Supercar")){
                Toast.makeText(getApplicationContext(),"Boosting!!!",Toast.LENGTH_SHORT).show();
            }
            mb2.txtESA.setText("Entertainment System amount: " + ESA);
            mb2.txtCarname.setText("Car " + name);
        } else if (typekendaraan.equals(typeMotor)) {
            Toast.makeText(getApplicationContext(),name+" is Standing!!",Toast.LENGTH_SHORT).show();
            mb2.txtESA.setText("Helm: " + ESA);
            mb2.txtCarname.setText("Motorcycle " + name);
        }

        mb2.txtBrand.setText("Brand: " + brand);
        mb2.txtName.setText("Name: " + name);
        mb2.txtLicense.setText("License: " + license);
        mb2.txtTopspeed.setText("Top Speed: " + topspeed);
        mb2.txtGascapacity.setText("Gas Capacity: " + gascapacity);
        mb2.txtWheel.setText("Wheel: " + wheel);
        mb2.txtType.setText("Type: " + Type);

        if (typekendaraan.equals(typeMobil)) {
            mb2.price.setVisibility(View.INVISIBLE);
            mb2.txtPrice.setVisibility(View.INVISIBLE);
            mb2.totalprice.setVisibility(View.INVISIBLE);
        }
        else if(typekendaraan.equals(typeMotor)) {
            mb2.price.setVisibility(View.VISIBLE);
            mb2.txtPrice.setVisibility(View.VISIBLE);
            mb2.totalprice.setVisibility(View.VISIBLE);
        }

        mb2.btnTestdrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    price = mb2.price.getEditableText().toString();
                    mb2.totalprice.setText("Rp." + price);
                    mb2.price.setVisibility(View.GONE);

            }
        });
    }
}