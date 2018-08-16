package com.example.thispc.mbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView name,accno,address,contact,currbal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.name);
        accno=findViewById(R.id.accno);
        address=findViewById(R.id.address);
        contact=findViewById(R.id.contact);
        currbal=findViewById(R.id.currbal);
        int positon=Main2Activity.postion;
        name.setText(AdminDatabase.names[positon]);
        accno.setText(AdminDatabase.accountno[positon]);
        contact.setText(AdminDatabase.contact[positon]);
        address.setText(AdminDatabase.address[positon]);
        currbal.setText(AdminDatabase.curbal[positon]);
    }

}
