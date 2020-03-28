package ru.startandroid.p0171dynamiclayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout llMain;
    RadioGroup rgGravity;
    EditText etName;
    Button btnCreate;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnClear = (Button) findViewById(R.id.btnClear);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                LinearLayout.LayoutParams layoutParams
                        = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                        ViewGroup.LayoutParams.WRAP_CONTENT);

                int selectedGravity = Gravity.START;
                switch (rgGravity.getCheckedRadioButtonId()) {
                    case R.id.rbLeft:
                        selectedGravity = Gravity.START;
                        break;
                    case R.id.rbCenter:
                        selectedGravity = Gravity.CENTER;
                        break;
                    case R.id.rbRight:
                        selectedGravity = Gravity.END;
                        break;
                }
                layoutParams.gravity = selectedGravity;

                Button btn = new Button(this);
                btn.setText(etName.getText().toString());
                llMain.addView(btn, layoutParams);
                break;
            case R.id.btnClear:
                llMain.removeAllViews();
                Toast.makeText(this, "Cleared!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRemoveLast:
                int viewCount = llMain.getChildCount();
                if (viewCount == 0) {
                    Toast.makeText(this, "Nothing to remove", Toast.LENGTH_SHORT).show();
                    break;
                }
                llMain.removeViewAt(viewCount - 1);
                break;
        }
    }
}
