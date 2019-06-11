package com.test.helios;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    BluetoothFrag bluetoothFrag;
    Button btnOn, btnOff;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOn = (Button) findViewById(R.id.btnOn);
        btnOff = (Button) findViewById(R.id.btnOff);

        btnOn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                bluetoothFrag.sendData("1");
                Toast.makeText(getBaseContext(), "Turn on LED", Toast.LENGTH_SHORT).show();
            }
        });

        btnOff.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                bluetoothFrag.sendData("0");
                Toast.makeText(getBaseContext(), "Turn off LED", Toast.LENGTH_SHORT).show();
            }
        });

        FragmentManager fm = getFragmentManager();
        // Check to see if we have retained the worker fragment.
        bluetoothFrag = (BluetoothFrag) fm.findFragmentByTag("work");
        // If not retained (or first time running), we need to create it.
        if (bluetoothFrag == null) {
            bluetoothFrag = new BluetoothFrag();
            // Tell it who it is working with.
            fm.beginTransaction().add(bluetoothFrag, "work").commit();
        }
    }

    /** Called when the user clicks the Send button */
    public void goToAutomatic(View view) {
        Intent intent = new Intent(this, Automatic.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Send button */
    public void goToManual(View view) {
        Intent intent = new Intent(this, Manual.class);
        startActivity(intent);
    }
}
