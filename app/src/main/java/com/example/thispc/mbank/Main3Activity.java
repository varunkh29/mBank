package com.example.thispc.mbank;


import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    GridView gridView;
    String[] names={"My Account","Change Password","Transcation History","New Transcation","Logout"};
    int[] images={R.mipmap.ic_launcher_round,R.mipmap.ic_launcher,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher_round};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        gridView = findViewById(R.id.gridView);
        customadapter adapter=new customadapter(this,names,images);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos==0)
                {
                    Intent i=new Intent(Main3Activity.this,ProfileActivity.class);
                    startActivity(i);
                }
                if(pos==1)
                {
                    Intent i=new Intent(Main3Activity.this,ChangePassword.class);
                    startActivity(i);
                }
                if(pos==2)
                {
                    Intent i=new Intent(Main3Activity.this,TransactionHistory.class);
                    startActivity(i);
                }
                if(pos==3)
                {
                    Intent i=new Intent(Main3Activity.this,NewTranscation.class);
                    startActivity(i);
                }
                if(pos==4)
                {
                    Intent i=new Intent(Main3Activity.this,Main2Activity.class);
                    startActivity(i);
                }
            }
        });

    }
}
