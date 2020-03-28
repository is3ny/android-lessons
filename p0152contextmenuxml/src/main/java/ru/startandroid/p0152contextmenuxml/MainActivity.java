package ru.startandroid.p0152contextmenuxml;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvColor, tvSize;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();

        switch (view.getId()) {
            case R.id.tvColor:
                inflater.inflate(R.menu.colormenu, menu);
                break;
            case R.id.tvSize:
                inflater.inflate(R.menu.sizemenu, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_red:
                tvColor.setTextColor(Color.RED);
                break;
            case R.id.menu_green:
                tvColor.setTextColor(Color.GREEN);
                break;
            case R.id.menu_blue:
                tvColor.setTextColor(Color.BLUE);
                break;
            case R.id.menu_22:
                tvSize.setTextSize(22);
                break;
            case R.id.menu_26:
                tvSize.setTextSize(26);
                break;
            case R.id.menu_30:
                tvSize.setTextSize(30);
                break;
        }

        return super.onContextItemSelected(item);
    }
}
