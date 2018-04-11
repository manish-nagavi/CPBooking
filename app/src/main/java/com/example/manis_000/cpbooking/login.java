package com.example.manis_000.cpbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    EditText emailid, password;
    Button login;
    TextView tvuserreg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailid= (EditText) findViewById(R.id.etemailid);
        password=(EditText) findViewById(R.id.etpassword);
        login= (Button) findViewById(R.id.btnlogin);

        tvuserreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, registration.class));
            }
        });


    }

}
