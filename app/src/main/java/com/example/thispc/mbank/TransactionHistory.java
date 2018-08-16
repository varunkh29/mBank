package com.example.thispc.mbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class TransactionHistory extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcation_history);
        listView=findViewById(R.id.lview);
        ProfileDatabase database=new ProfileDatabase(this);

        HistoryAdapter adapter=new HistoryAdapter(this,database.showtransaction(AdminDatabase.accountno[Main2Activity.postion]));
        listView.setAdapter(adapter);
    }
}
