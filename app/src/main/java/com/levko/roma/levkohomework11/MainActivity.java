package com.levko.roma.levkohomework11;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.levko.roma.levkohomework11.Fragments.MoveFragment;
import com.levko.roma.levkohomework11.Fragments.PaintFragment;

public class MainActivity extends AppCompatActivity {
    boolean switchFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragments(new MoveFragment());
    }

    private void setFragments(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.fl_container_AM, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (switchFragment) {
            setFragments(new PaintFragment());
            switchFragment = false;
        } else {
            setFragments(new MoveFragment());
            switchFragment = true;
        }
        return super.onOptionsItemSelected(item);
    }
}
