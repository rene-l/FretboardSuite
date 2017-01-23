package com.rliossi.apps.fretboardsuite;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rene on 15/01/2017.
 */

public class SelectNotesFragment extends Fragment {
    private Button mStartButton;
    private GridLayout mGridLayout;
    private ArrayList<String> mNotes;
    private String mLastNote = "";
    private Handler mHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_select_notes, container, false);
        mNotes = new ArrayList<>();

        mGridLayout = (GridLayout) v.findViewById(R.id.grid_select);

        setCheckBoxListeners();

        mStartButton = (Button) v.findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s = mNotes.size();

                if (s > 0) {
                    Random r = new Random();
                    int n = r.nextInt(s);
                    if (!mNotes.get(n).equalsIgnoreCase(mLastNote)) {
                        mLastNote = mNotes.get(n);
                    }
                }
            }
        });

        return v;
    }

    private void setCheckBoxListeners() {
        for (int i = 0; i < mGridLayout.getChildCount(); i++) {
            if( mGridLayout.getChildAt(i) instanceof CheckBox){

                CheckBox c = (CheckBox) mGridLayout.getChildAt(i);

                c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        String n = buttonView.getText().toString();

                        if (mNotes.indexOf(n) == -1) {
                            mNotes.add(n);
                        } else {
                            int i = mNotes.indexOf(n);
                            mNotes.remove(i);
                        }
                    }
                });
            }
        }
    }

    private void setSlideHandler(){
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                mHandler.sendEmptyMessageDelayed(0, 500);
            }
        };

        mHandler.sendEmptyMessage(0);
    }
}
