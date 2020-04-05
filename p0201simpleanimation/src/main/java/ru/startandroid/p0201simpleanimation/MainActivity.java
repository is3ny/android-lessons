package ru.startandroid.p0201simpleanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaCodecInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANS_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBI_ID = 5;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info) {
        switch (v.getId()) {
            case R.id.tv:
                menu.add(0, MENU_ALPHA_ID, 0, "Alpha");
                menu.add(0, MENU_SCALE_ID, 0, "Scale");
                menu.add(0, MENU_TRANS_ID, 0, "Translate");
                menu.add(0, MENU_ROTATE_ID, 0, "Rotate");
                menu.add(0, MENU_COMBI_ID, 0, "Scale & Rotate");
                break;
        }

        super.onCreateContextMenu(menu, v, info);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Animation anim = null;

        switch (item.getItemId()) {
            case MENU_ALPHA_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case MENU_SCALE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case MENU_TRANS_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                break;
            case MENU_ROTATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case MENU_COMBI_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
        }

        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}
