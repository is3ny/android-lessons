package ru.startandroid.p0081viewbyid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = (TextView) findViewById(R.id.myText);
        myTextView.setText("SAAAAAAAAAAAAAAaaS!");

        Button myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setText("Myuu");
        myBtn.setEnabled(false);

        CheckBox myChk = (CheckBox) findViewById(R.id.myChk);
        myChk.setText("Check me!");
        myChk.setChecked(true);
    }
}
