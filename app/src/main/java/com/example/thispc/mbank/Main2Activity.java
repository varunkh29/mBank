package com.example.thispc.mbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText userEt, passEt;
static int postion=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        userEt = findViewById(R.id.userEt);
        passEt = findViewById(R.id.passEt);
    }

    public void shownext(View view) {

        String username = userEt.getText().toString();
        String password = passEt.getText().toString();
        int len = AdminDatabase.names.length;
        boolean status=false;
        for (int i = 0; i < len; i++) {
            if (AdminDatabase.names[i].equals(username) && AdminDatabase.password[i].equals(password)) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                postion=i;
                Toast.makeText(this, ""+postion, Toast.LENGTH_SHORT).show();
                status=true;
                startActivity(intent);
            }

        }
        if (!status){
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
        passEt.setText("");
        userEt.setText("");


    }


    public void showreset(View view) {
    }

    public void showforgot(View view) {
    }

    public void showcreate(View view) {
    }


}