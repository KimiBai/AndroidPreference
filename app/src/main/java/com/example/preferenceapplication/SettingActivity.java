package com.example.preferenceapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class SettingActivity extends FragmentActivity {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}
