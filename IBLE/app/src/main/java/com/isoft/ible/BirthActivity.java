package com.isoft.ible;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class BirthActivity extends ActionBarActivity implements View.OnClickListener {

    Button next,male,female,birth;
    private Context mContext;
    private String selectGender = "";
    private Calendar mCalen;
    private int day;
    private int month;
    private int year;
    String strColor = "#fe4c4c";

    private static final int DATE_PICKER_ID = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth);

        mContext = this;

        next = (Button) findViewById(R.id.nextbtn);
        male = (Button) findViewById(R.id.manbtn);
        female = (Button) findViewById(R.id.womanbtn);
        birth = (Button) findViewById(R.id.birthBtn);
        next.setOnClickListener(this);
        mCalen = Calendar.getInstance();
        day = mCalen.get(Calendar.DAY_OF_MONTH);
        month = mCalen.get(Calendar.MONTH);
        year = mCalen.get(Calendar.YEAR);

        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_PICKER_ID);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.manbtn://male
                        //male.setBackgroundResource(R.drawable.man_button_on);
                        //female.setBackgroundResource(R.drawable.woman_button_off);
                        selectGender = "M";
                        break;
                    case R.id.womanbtn://female
                        //male.setBackgroundResource(R.drawable.man_button_off);
                        //female.setBackgroundResource(R.drawable.woman_button_on);
                        selectGender = "F";
                        break;
                }
            }
        };
        male.setOnClickListener(listener);
        female.setOnClickListener(listener);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(getApplicationContext(),"oo",Toast.LENGTH_SHORT).show();
        if (!checkValidation()) {
            return;
        }

        Intent i = new Intent(BirthActivity.this, LocationActivity.class);

        startActivity(i);
        finish();
    }

    private boolean checkValidation() {
        //Toast.makeText(context, "네트워크를 찾을 수 없습니다. 네트워크 상태를 확인하세요.", Toast.LENGTH_SHORT).show();

        if (selectGender.equals("")) {
            Toast t = Toast.makeText(mContext, "성별을 선택해주세요.", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
            return false;
        }

        String sBirth = birth.getText().toString();
        if (sBirth.equals("생년월일")) {
            Toast t = Toast.makeText(mContext, "생년월일을 입력해주세요.", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
            return false;
        }

        return true;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case DATE_PICKER_ID:
                return new DatePickerDialog(this, pickerListener,year,month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;
            //birth.setTextColor(Color.parseColor(strColor));
            birth.setText(new StringBuilder().append(year).append("-").append(month + 1)
                    .append("-").append(day).append(" "));
        }
    };
}
