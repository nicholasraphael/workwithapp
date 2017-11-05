package com.workwith.workwith;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**call this method when the user taps the create slot button*/
    public void createSlot(View view) {
        Intent intent = new Intent(this, createSlotActivity.class);
        startActivity(intent);
    }

    public void joinslot(View view) {
        Intent intent = new Intent(this, joinSlotActivity.class);
        startActivity(intent);
    }

}
