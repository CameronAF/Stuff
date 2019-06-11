package com.test.helios;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Manual extends AppCompatActivity  {

    BluetoothFrag bluetoothFrag;

    //function called when activity is created
    //function that holds buttons onTouch Listeners
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set content to xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        FragmentManager fm = getFragmentManager();
        // Check to see if we have retained the worker fragment.
        bluetoothFrag = (BluetoothFrag) fm.findFragmentByTag("work");
        // If not retained (or first time running), we need to create it.
        if (bluetoothFrag == null) {
            bluetoothFrag = new BluetoothFrag();
            // Tell it who it is working with.
            fm.beginTransaction().add(bluetoothFrag, "work").commit();
        }

        //initialize the buttons to a variable
        Button upArrow = (Button) findViewById(R.id.upArrow);
        Button leftArrow = (Button) findViewById(R.id.leftArrow);
        Button rightArrow = (Button) findViewById(R.id.rightArrow);
        Button downArrow = (Button) findViewById(R.id.downArrow);

        //up button listener
        assert upArrow != null;
        upArrow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    //user presses button
                    case MotionEvent.ACTION_DOWN:
                        Move(1);
                        break;
                    //user releases button
                    case MotionEvent.ACTION_UP:
                        Move(0);
                        break;
                }
                return true;
            }
        });

        //left button listener
        assert leftArrow != null;
        leftArrow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    //user presses button
                    case MotionEvent.ACTION_DOWN:
                        Move(2);
                        break;
                    //user releases button
                    case MotionEvent.ACTION_UP:
                        Move(0);
                        break;
                }
                return true;
            }
        });

        //right button listener
        assert rightArrow != null;
        rightArrow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    //user presses button
                    case MotionEvent.ACTION_DOWN:
                        Move(3);
                        break;
                    //user releases button
                    case MotionEvent.ACTION_UP:
                        Move(0);
                        break;
                }
                return true;
            }
        });

        //down button listener
        assert downArrow != null;
        downArrow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    //user presses button
                    case MotionEvent.ACTION_DOWN:
                        Move(4);
                        break;
                    //user releases button
                    case MotionEvent.ACTION_UP:
                        Move(0);
                        break;
                }
                return true;
            }
        });
    }

    //function that goes to Automatic activity
    public void goToAutomatic(View view) {
        Intent intent = new Intent(this, Automatic.class);
        startActivity(intent);
    }

    //function that moves the wheelchair
    void Move(int i) {
        TextView textBox = (TextView) findViewById(R.id.textView);
        assert textBox != null;
        switch (i) {
            case 1:
                textBox.setText(R.string.M_Forward);
                bluetoothFrag.sendData("1");
                break;
            case 2:
                textBox.setText(R.string.M_Left);
                break;
            case 3:
                textBox.setText(R.string.M_Right);
                break;
            case 4:
                textBox.setText(R.string.M_Backwards);
                break;
            case 5:
                textBox.setText(R.string.M_Here);
                break;
            default:
                textBox.setText(R.string.M_Idle);
                break;
        }
    }
}

