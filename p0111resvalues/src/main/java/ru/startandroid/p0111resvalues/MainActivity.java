package ru.startandroid.p0111resvalues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = (LinearLayout) findViewById(R.id.llBottom);
        TextView tv = (TextView) findViewById(R.id.tvBottom);
        Button btn = (Button) findViewById(R.id.btnBottom);

        ll.setBackgroundResource(R.color.llBottomColor);
        tv.setText(R.string.tvBottomText);
        btn.setText(R.string.btnBottomText);

        getResources().getString(R.string.btnBottomText);
    }
}
