package com.wlodek.mecalc.Hauptseiten.Services;

import android.provider.BaseColumns;

public class Contract {

    private Contract(){}

    public static final class Entry implements BaseColumns{
        public static final String TABLE_NAME = "Speisen";
        public static final String COLUMN_NAME = "name";
        public static final  String COLUMN_KCAL = "Kcal";
    }

}
