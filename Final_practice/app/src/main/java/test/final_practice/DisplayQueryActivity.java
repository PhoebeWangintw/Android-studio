package test.final_practice;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DisplayQueryActivity extends AppCompatActivity {

    /* display data and making queries based on time and prices */
    private static int mYear, mMonth, mDay, mHour, mMinute;
    private ListView lv_display;
    private Button btn_start_date, btn_end_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_query);
        init();
    }

    private void init() {

        btn_start_date = (Button) findViewById(R.id.btn_start_date);
        btn_end_date = (Button) findViewById(R.id.btn_end_date);
    }

    private static void showNow() {
        Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(java.util.Calendar.YEAR);
        mMonth = calendar.get(java.util.Calendar.MONTH);
        mDay = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        mHour = calendar.get(java.util.Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(java.util.Calendar.MINUTE);
    }

    public static class DatePickerDialogFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new DatePickerDialog(
                    getActivity(), this, mYear, mMonth, mDay);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            mYear = year;
            mMonth = month;
            mDay = day;
        }
    }

    public static class TimePickerDialogFragment extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new TimePickerDialog(
                    getActivity(), this, mHour, mMinute, false);
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mHour = hourOfDay;
            mMinute = minute;
        }
    }
}
