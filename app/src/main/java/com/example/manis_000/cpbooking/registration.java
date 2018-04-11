package com.example.manis_000.cpbooking;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    EditText username, useremail, userpassword, uservehicleno;
    Button register,view;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        databaseHelper = new DatabaseHelper(this);


        username=(EditText) findViewById(R.id.etusername);
        useremail=(EditText) findViewById(R.id.etuseremail);
        userpassword=(EditText) findViewById(R.id.etuserpassword);
        uservehicleno=(EditText) findViewById(R.id.etuservehicle);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name=username.getText().toString();
                String user_email=useremail.getText().toString();
                String user_password=userpassword.getText().toString();
                String user_vehicle_no=uservehicleno.getText().toString();

                if(user_name.isEmpty() || user_email.isEmpty() || user_password.isEmpty() || user_vehicle_no.isEmpty()){
                    AddData(user_name,user_email,user_password,user_vehicle_no);
                    //.setText("");  will try later
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(registration.this, viewobjects.class);
                startActivity(intent);
            }
        });

    }

    public void AddData(String user_name,String user_email, String user_password, String user_vehicle_number){
        boolean insertdata= databaseHelper.insertdata(user_name, user_email, user_password, user_vehicle_number);
        if(insertdata){
            ToastMessage("Data Entered Successfully");
        }
        else{
            ToastMessage("Data not entered");
        }
    }

    private void ToastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}
