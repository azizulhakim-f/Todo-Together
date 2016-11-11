package com.azizulhakim.todotogether;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CalendarPage extends InterfaceActivity {
    static final int DILOG_ID=0;
    Button btn;
    int year_x,month_x,day_x;
    String arr[]=new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        final Calendar cal= Calendar.getInstance();
        year_x=cal.get(Calendar.YEAR);
        month_x=cal.get(Calendar.MONTH);
        day_x=cal.get(Calendar.DAY_OF_MONTH);
        showDialog(DILOG_ID);
    }
    protected Dialog onCreateDialog(int id)
    {
        if(id==DILOG_ID)
            return new DatePickerDialog(this,dpickerListner,year_x,month_x,day_x);
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerListner
            =new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x=year;
            month_x=month;
            day_x=dayOfMonth;
            //Toast(CalendarPage.this,day_x+" "+arr[month_x]+" "+year_x,Toast.LENGTH_LONG.show());
            Toast toast = Toast.makeText(CalendarPage.this, day_x+" "+arr[month_x]+" "+year_x, Toast.LENGTH_SHORT);
            LinearLayout toastLayout = (LinearLayout) toast.getView();
            TextView toastTV = (TextView) toastLayout.getChildAt(0);
            toastTV.setTextSize(50);
            toast.show();
        }
    };
}
