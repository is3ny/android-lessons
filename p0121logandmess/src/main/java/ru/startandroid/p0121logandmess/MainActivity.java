package ru.startandroid.p0121logandmess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Get the View object using their IDs");
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        Log.d(TAG, "Assign an OnClickListener to all Buttons");
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    public void onClick(View v) {
        Log.d(TAG, "Using the Button ID, determine what needs to be done");
        switch (v.getId()) {
            case R.id.btnOk:
                Log.d(TAG, "OK Button was pressed");
                tvOut.setText("OK!");
                Toast.makeText(this, "OK was pressed!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancel:
                Log.d(TAG, "Cancel Button was pressed");
                tvOut.setText("Ahhh!");
                Toast.makeText(this, "Cancel was pressed!", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
