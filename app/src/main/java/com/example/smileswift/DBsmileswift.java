package com.example.smileswift;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBsmileswift extends SQLiteOpenHelper {

        public static final String DBNAME = "smileswift.db";

        public static int dbVersion=1;
              //  Table1 Patient  //
        public static final String T1_Patient = "Patient";
        private static String idColumnP="Patient id";
        public static final String COL1= "Patient name";
        public static final String COL2 = "password";
        public static final String numberP = "Patient Number";

               // Table2 Appointment //
        private static String T2_Appointment= "Appointment";
        private static String idColumnA="Appointment_id";
        private static String dateColumnA="Appointment_Date";
        private static String stateColumnA="Appointment_State";

             // Table3 Doctor //
        private static String T3_Doctor= "Doctor";
        private static String idColumnD="Doctor id";
        private static String nameColumnD="Doctor name";
        private static String yearColumnD="Years Of Service";


        public DBsmileswift(@Nullable Context context) {

            super(context, DBNAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL("CREATE TABLE " + T1_Patient +"(" +
                    idColumnP + " ,INTEGER PRIMARY KEY, " + // PK
                     COL1 + ", TEXT , " + COL2 + " TEXT" +
                    ")");

            sqLiteDatabase.execSQL("CREATE TABLE " + T2_Appointment +
                    "(" + idColumnA + " ,INTEGER PRIMARY KEY autoincrement, " +  // PK
                    dateColumnA + "String ," +
                    idColumnD +", INTEGER references"+T3_Doctor +idColumnD  + // FK
                    idColumnP +", INTEGER references" +T1_Patient +"(" + idColumnP + ")" ); // FK

            sqLiteDatabase.execSQL("CREATE TABLE " + T3_Doctor +
                    "(" + idColumnD + " ,INTEGER PRIMARY KEY autoincrement, " + // PK
                    nameColumnD + " ,TEXT ," +
                    yearColumnD +" INTEGER " +
                    ")");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + T1_Patient);
            onCreate(sqLiteDatabase);
        }

        public Boolean insertData(String username, String password) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL1, username);
            contentValues.put(COL2, password);
            long result = MyDB.insert(T1_Patient, null, contentValues);
            return result != -1;
        }

        public Boolean checkUsername(String username) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("SELECT * FROM " + T1_Patient + " WHERE " + COL1 + " = ?", new String[]{username});
            return cursor.getCount() > 0;
        }

        public Boolean checkUsernamePassword(String username, String password) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("SELECT * FROM " + T1_Patient + " WHERE " + COL1 + " = ? AND " + COL2 + " = ?", new String[]{username, password});
            return cursor.getCount() >0 ;
        }
   // New Methods :
        public <Appointment> long Appointment(Appointment appointment) {
           try {
               SQLiteDatabase sqLiteDatabase= getWritableDatabase();
               ContentValues contentValues= new ContentValues();
               contentValues.put(dateColumnA, appointment.getClass().getModifiers());
              return sqLiteDatabase.insert(T2_Appointment, null, contentValues) ;
           }  finally {

           }
    }

}

