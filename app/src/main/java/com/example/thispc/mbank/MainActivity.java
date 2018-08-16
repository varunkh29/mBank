
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
        import android.widget.ListView;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void user(View view) {
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(i);
    }

    public void admin(View view) {

    }



    public void shownext(View view) {
    }

    public void showforgot(View view) {
    }
}

