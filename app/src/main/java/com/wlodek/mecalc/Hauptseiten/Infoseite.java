package com.wlodek.mecalc.Hauptseiten;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wlodek.mecalc.R;

public class Infoseite extends AppCompatActivity {

    private Button hinzu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoseite);

        hinzu = findViewById(R.id.btn_hinzu);
        hinzu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHinzu();
            }
        });
    }

    public void openHinzu(){
        Intent intent = new Intent(this, Hinzu.class);
        startActivity(intent);
    }

}
