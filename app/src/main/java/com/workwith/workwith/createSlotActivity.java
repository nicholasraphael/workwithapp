package com.workwith.workwith;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class createSlotActivity extends Activity implements TimePicker.OnTimeChangedListener {

    private Calendar mCalendar;

    private TimePicker timePicker;
    /*array to test saving time from picker*/
    public static ArrayList<Date> savedSlots = new ArrayList<>();

    //TextView timePickerTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_slot);
        timePicker = findViewById(R.id.timePicker2);
        //timePickerTest = findViewById(R.id.test_time);

        //timePickerTest.setText("" + timePicker.getCurrentHour());

        Button b = findViewById(R.id.button4);

    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        Log.d("TAG", "In onTimeChanged");
        mCalendar.set(mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH),
                hourOfDay,
                minute);

        setCalendarTime();
    }

    private void setCalendarTime() {
        Date date = mCalendar.getTime();

        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy '@' h:mm a");
            String dateTime = formatter.format(date);

            Toast.makeText(this, dateTime, Toast.LENGTH_LONG).show();
        }

    }

    public void completedCreate(View view) {
        int hour = timePicker.getCurrentHour();
        int min = timePicker.getCurrentMinute();
        String time = hour + ":" + min;
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
            final Date dateObj = sdf.parse(time);
            savedSlots.add(dateObj);
        } catch (final ParseException e) {
            e.printStackTrace();
        }


        Intent intent = new Intent(this, userHomeActivity.class);
        startActivity(intent);
    }
git
   /* public ArrayList<Date> getSavedSlots() {
        return savedSlots;
    }
    */
}
