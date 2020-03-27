package ru.startandroid.p0141menuadv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    CheckBox chb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);
    }

    // Menu creation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Add initial menu items
        menu.add(0, 0, 0, "Add");
        menu.add(0, 1, 0, "Edit");
        menu.add(0, 3, 3, "Delete");
        menu.add(1, 4, 1, "Copy");
        menu.add(1, 5, 1, "Paste");
        menu.add(1, 6, 4, "Exit");

        return super.onCreateOptionsMenu(menu);
    }

    // Menu update
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    // Click handling
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        StringBuilder sb = new StringBuilder();

        sb.append("Item Menu:");
        sb.append("\r\n groupID = " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemID = " + String.valueOf(item.getItemId()));
        sb.append("\r\n order = " + String.valueOf(item.getOrder()));
        sb.append("\r\n title = " + item.getTitle());
        tv.setText(sb.toString());

        return super.onOptionsItemSelected(item);
    }

}
