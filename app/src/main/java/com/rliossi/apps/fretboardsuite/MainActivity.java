package com.rliossi.apps.fretboardsuite;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new SelectNotesFragment();
    }
}
