package com.test.helios;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Automatic extends AppCompatActivity {

    BluetoothFrag bluetoothFrag;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic);

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
    public void goToManual(View view) {
        Intent intent = new Intent(this, Manual.class);
        startActivity(intent);
    }
}
