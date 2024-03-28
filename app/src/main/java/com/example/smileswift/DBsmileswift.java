package com.example.smileswift;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBsmileswift extends SQLiteOpenHelper {

    public static final String DBNAME = "smileswift.db";

    // Table1 Patient
    public static final String T1_Patient = "Patient";
    public static final String COL1 = "Patient_name";
    public static final String COL2 = "password";
    public static final String numberP = "Patient_Number";

    // Table2 Appointment
    public static final String T2_Appointment = "Appointment";
    public static final String idColumnA = "Appointment_id";
    public static final String dateColumnA = "Appointment_Date";
    public static final String stateColumnA = "Appointment_State";
    public static final String idColumnD = "Doctor_id";
    public static final String idColumnP = "Patient_id";

    // Table3 Doctor
    public static final String T3_Doctor = "Doctor";
    public static final String idColumnD_Doc = "Doctor_id";
    public static final String nameColumnD = "Doctor_name";
    public static final String yearColumnD = "Years_Of_Service";

    public DBsmileswift( Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + T1_Patient + "(" +
                idColumnP + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + " TEXT, " +
                COL2 + " TEXT, " +
                numberP + " TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + T2_Appointment + "(" +
                idColumnA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                dateColumnA + " TEXT, " +
                stateColumnA + " TEXT, " +
                idColumnD + " INTEGER, " +
                idColumnP + " INTEGER, " +
                "FOREIGN KEY(" + idColumnD + ") REFERENCES " + T3_Doctor + "(" + idColumnD_Doc + "), " +
                "FOREIGN KEY(" + idColumnP + ") REFERENCES " + T1_Patient + "(" + idColumnP + "))");

        sqLiteDatabase.execSQL("CREATE TABLE " + T3_Doctor + "(" +
                idColumnD_Doc + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                nameColumnD + " TEXT, " +
                yearColumnD + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + T1_Patient);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + T2_Appointment);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + T3_Doctor);
        onCreate(sqLiteDatabase);
    }

    public boolean insertPatientData(String username, String password, String number) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, username);
        contentValues.put(COL2, password);
        contentValues.put(numberP, number);
        long result = MyDB.insert(T1_Patient, null, contentValues);
        return result != -1;
    }

    public boolean insertAppointmentData(String date, String state, int doctorId, int patientId) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dateColumnA, date);
        contentValues.put(stateColumnA, state);
        contentValues.put(idColumnD, doctorId);
        contentValues.put(idColumnP, patientId);
        long result = MyDB.insert(T2_Appointment, null, contentValues);
        return result != -1;
    }

    public boolean insertDoctorData(String name, int yearsOfService) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(nameColumnD, name);
        contentValues.put(yearColumnD, yearsOfService);
        long result = MyDB.insert(T3_Doctor, null, contentValues);
        return result != -1;
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getReadableDatabase(); // Change to getReadableDatabase()
        Cursor cursor = MyDB.rawQuery("SELECT * FROM " + T1_Patient + " WHERE " + COL1 + " = ?", new String[]{username});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDB = this.getReadableDatabase(); // Change to getReadableDatabase()
        Cursor cursor = MyDB.rawQuery("SELECT * FROM " + T1_Patient + " WHERE " + COL1 + " = ? AND " + COL2 + " = ?", new String[]{username, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

}

