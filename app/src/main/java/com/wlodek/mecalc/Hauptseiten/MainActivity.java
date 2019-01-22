package com.wlodek.mecalc.Hauptseiten;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wlodek.mecalc.R;

public class MainActivity extends AppCompatActivity {

    private Button info;
    private Button rechner;
    private Button tagebuch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.btn_info);
        rechner = findViewById(R.id.btn_rechner);
        tagebuch = findViewById(R.id.btn_tagebuch);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfo();
            }
        });

        rechner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRechner();
            }
        });

        tagebuch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTagebuch();
            }
        });
    }

    public void openInfo(){
        Intent intent = new Intent(this, Infoseite.class);
        startActivity(intent);
    }

    public void openRechner(){
        Intent intent = new Intent(this, Rechner.class);
        startActivity(intent);
    }

    public void openTagebuch(){
        Intent intent = new Intent(this, Tagebuch.class);
        startActivity(intent);
    }
}
