package com.wlodek.mecalc.Hauptseiten;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.wlodek.mecalc.R;

public class Hinzu extends AppCompatActivity {

    private EditText mEditTextName;
    private EditText getmEditTextKcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinzu);

        mEditTextName = findViewById(R.id.edt_name);
        getmEditTextKcal = findViewById(R.id.edt_kcal);

        Button add_= findViewById(R.id.btn_hinzu_add);
    }


}
