package com.rliossi.apps.fretboardsuite;

import android.support.v4.app.Fragment;

/**
 * Created by reliossi on 16/01/2017.
 */

public class RandomNotesActivity extends SingleFragmentActivity{
    private static String EXTRA_NOTES;

    @Override
    public Fragment createFragment() {
        return new RandomNotesFragment();
    }
}
