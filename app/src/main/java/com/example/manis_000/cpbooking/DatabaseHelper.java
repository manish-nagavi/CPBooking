package com.example.manis_000.cpbooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by manis_000 on 11-04-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;
    public static final String dbname = "mydb";
    public static final int dbversion = 1;
    public static final String tablename = "users";
    public static final String col1 = "id";
    public static final String col2 = "user_name";
    public static final String col3 = "user_email";
    public static final String col4 = "user_password";
    public static final String col5 = "user_vehicle_number";
    public static final String col6 = "user_slot_no";


    public DatabaseHelper(Context context) {
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + tablename + " ( id integer primary key autoincrement, user_name text, user_email text, user_password text, user_vehicle_number text, user_slot_no int);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + tablename);
        onCreate(sqLiteDatabase);
    }

    public boolean insertdata(String user_name,String user_email, String user_password, String user_vehicle_number){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(DatabaseHelper.col2,user_name);
        contentValues.put(DatabaseHelper.col3,user_email);
        contentValues.put(DatabaseHelper.col4,user_password);
        contentValues.put(DatabaseHelper.col5,user_vehicle_number);
        Log.d(TAG, "insertdata: adding"+ user_name + user_email+ user_password + user_vehicle_number+ " to " +tablename);

        long id = sqLiteDatabase.insert(DatabaseHelper.tablename, null ,contentValues);
        if(id==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query="select user_name from "+ tablename;
        Cursor data= sqLiteDatabase.rawQuery(query,null);
        return data;
    }

}
