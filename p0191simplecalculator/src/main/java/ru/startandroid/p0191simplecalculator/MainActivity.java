package ru.startandroid.p0191simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        tvRes = (TextView) findViewById(R.id.tvRes);
    }

    public void onClick(View v) {
        String num1str = etNum1.getText().toString();
        String num2str = etNum2.getText().toString();

        if (TextUtils.isEmpty(num1str) || TextUtils.isEmpty(num2str)) {
            tvRes.setText("Please, provide numbers in both fields");
            return;
        }

        float num1, num2;
        try {
            num1 = Float.parseFloat(num1str);
        } catch (Exception e) {
            tvRes.setText("Invalid number in the left field");
            return;
        }

        try {
            num2 = Float.parseFloat(num2str);
        } catch (Exception e) {
            tvRes.setText("Invalid number in the right field");
            return;
        }

        float result = 0;
        String op = "?";
        switch (v.getId()) {
            case R.id.btnAdd:
                result = num1 + num2;
                op = "+";
                break;
            case R.id.btnSub:
                result = num1 - num2;
                op = "-";
                break;
            case R.id.btnMul:
                result = num1 * num2;
                op = "*";
                break;
            case R.id.btnDiv:
                if (num2 < 10e-8) {
                    tvRes.setText("Division by zero is forbidden");
                    return;
                }
                result = num1 / num2;
                op = "/";
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(num1));
        sb.append(" ");
        sb.append(op);
        sb.append(" ");
        sb.append(String.valueOf(num2));
        sb.append(" = ");
        sb.append(String.valueOf(result));

        tvRes.setText(sb.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear_fields:
                etNum1.setText("");
                etNum2.setText("");
                tvRes.setText("READY");
                Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
