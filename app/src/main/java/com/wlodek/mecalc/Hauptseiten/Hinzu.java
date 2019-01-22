package com.wlodek.mecalc.Hauptseiten;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wlodek.mecalc.Hauptseiten.Services.Adapter;
import com.wlodek.mecalc.Hauptseiten.Services.Contract;
import com.wlodek.mecalc.Hauptseiten.Services.DBHelper;
import com.wlodek.mecalc.R;

public class Hinzu extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private Adapter mAdapter;
    private EditText mEditTextName;
    private EditText getmEditTextKcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinzu);

        DBHelper dbHelper = new DBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.rcv_liste);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new Adapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);

        mEditTextName = findViewById(R.id.edt_name);
        getmEditTextKcal = findViewById(R.id.edt_kcal);

        Button add_= findViewById(R.id.btn_hinzu_add);

        add_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });
    }

    private void addItem(){

        if(mEditTextName.getText().toString().trim().length() == 0 || getmEditTextKcal.getText().toString().trim().length() == 0){
            return;
        }

        String name = mEditTextName.getText().toString();
        String kcal = getmEditTextKcal.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(Contract.Entry.COLUMN_NAME, name);
        cv.put(Contract.Entry.COLUMN_KCAL,kcal);

        mDatabase.insert(Contract.Entry.TABLE_NAME, null,cv);
        mAdapter.swapCursor(getAllItems());

        mEditTextName.getText().clear();
        getmEditTextKcal.getText().clear();

    }

    private Cursor getAllItems(){
        return mDatabase.query(
                Contract.Entry.TABLE_NAME,
                null,null, null, null, null, Contract.Entry.COLUMN_TIMESTAMP + " DESC"
        );
    }

}
