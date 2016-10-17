package kr.hs.emirim.dahoe0304.simplediary;

import android.annotation.TargetApi;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatePicker datepic;
    EditText editDiary;
    Button butSave;
    String fileName;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datepic=(DatePicker)findViewById(R.id.date_picker);
        editDiary=(EditText)findViewById(R.id.edit_content);
        butSave=(Button)findViewById(R.id.but_save);

        //현재날짜 구하기
        Calendar calendar=Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int date=calendar.get(Calendar.DATE);

        //DatePicker에 현재날짜 설정
        datepic.init(nowYear,month,date,new DatePicker.OnDateChangedListener() {
        public void onDateChanged(DatePicker view,int year, int monthOfYear, int dayOfMonth){
           fileName=year+"_"+(monthOfYear+1)+"_"+dayOfMonth+".txt";
            String content = readDiary(fileName);
            editDiary.setText(content);
            butSave.setEnabled(true);
            }
         });
    }
    String readDiary(String fileName){
        return null;
    }
}
