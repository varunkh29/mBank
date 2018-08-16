package com.example.thispc.mbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NewTranscation extends AppCompatActivity {
    Spinner accno;
    EditText amt,dateEt;
    int postion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transcation);
        accno=findViewById(R.id.accno);
        dateEt=findViewById(R.id.date1);
        amt=findViewById(R.id.amt1);
        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_list_item_1,AdminDatabase.accountno);
        accno.setAdapter(ad);
        postion=Main2Activity.postion;
        Toast.makeText(this, ""+postion, Toast.LENGTH_SHORT).show();
    }

    public void makep(View view) {

        String toRemBal="";
        String accountno = accno.getSelectedItem().toString();
        for(int pos=0;pos<AdminDatabase.accountno.length;pos++){
            if (AdminDatabase.accountno[pos].equals(accountno)) {
                toRemBal=AdminDatabase.curbal[pos];
            }

        }
        String amount = amt.getText().toString();
        String date = dateEt.getText().toString();
        ProfileDatabase database=new ProfileDatabase(this);
        String newFromBal=String.valueOf(Integer.parseInt(AdminDatabase.curbal[postion])-Integer.parseInt(amount));
        String newTOBal=String.valueOf(Integer.parseInt(toRemBal)+Integer.parseInt(amount));
        TransactionInfo fromInfo=new TransactionInfo(AdminDatabase.accountno[postion],accountno,amount,date,"debit",newFromBal);
        TransactionInfo toInfo=new TransactionInfo(AdminDatabase.accountno[postion],accountno,amount,date,"credit",newTOBal);

        database.addTransaction(fromInfo);
        database.addTransaction2(toInfo);
    }
}
