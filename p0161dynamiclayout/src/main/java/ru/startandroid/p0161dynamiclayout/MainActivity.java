package ru.startandroid.p0161dynamiclayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // ViewGroup.LayoutParams is the base class for different view parameters
        // One may set only width and height
        // To set more sophisticated parameters use the derived versions
        ViewGroup.LayoutParams llParams
                = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                             ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(linearLayout, llParams);

        LinearLayout.LayoutParams llChildParams
                = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText("First line!");
        tv.setLayoutParams(llChildParams);
        linearLayout.addView(tv);

        // Altering the previous one will alter the position of the text too.
        LinearLayout.LayoutParams leftMarginParams
                = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                ViewGroup.LayoutParams.WRAP_CONTENT);
        leftMarginParams.leftMargin = 50;

        Button btn1 = new Button(this);
        btn1.setText("Батон");
        linearLayout.addView(btn1, leftMarginParams);

        LinearLayout.LayoutParams rightGravityParams
                = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                ViewGroup.LayoutParams.WRAP_CONTENT);
        rightGravityParams.gravity = Gravity.END;

        Button btn2 = new Button(this);
        btn2.setText("Хлеба");
        linearLayout.addView(btn2, rightGravityParams);
    }
}
