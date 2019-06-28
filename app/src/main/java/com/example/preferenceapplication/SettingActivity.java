package com.example.preferenceapplication;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.SwitchPreference;
import android.util.Log;

public class SettingActivity extends PreferenceActivity implements
        Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {

    private final String TAG = getClass().getSimpleName();
    private Preference mTv;
    private EditTextPreference mEt;
    private CheckBoxPreference mCb;
    private ListPreference mList;
    private SwitchPreference mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

        mTv = findPreference("preference");
        mEt = (EditTextPreference) findPreference("edittext_preference");
        mCb = (CheckBoxPreference) findPreference("checkbox_preference_1");
        mList = (ListPreference) findPreference("list_preference");
        mSwitch = (SwitchPreference) findPreference("switch_preference");

        mTv.setOnPreferenceClickListener(this);
        mEt.setOnPreferenceChangeListener(this);
        mCb.setOnPreferenceChangeListener(this);
        mList.setOnPreferenceClickListener(this);
        mSwitch.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        switch (preference.getKey()) {
            case "switch_preference":
                Log.d(TAG, "switch_preference preference changed");
                mSwitch.setSummary(String.valueOf(newValue));
                break;
            case "checkbox_preference_1":
                Log.d(TAG, "checkbox_preference_1 preference changed");
                mCb.setSummary(String.valueOf(newValue));
                break;
            case "edittext_preference":
                Log.d(TAG, "edit text preference changed");
                mEt.setSummary(String.valueOf(newValue));
                break;
            default:
                Log.d(TAG, "None preference changed");
                break;
        }
        return true;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()) {
            case "preference":
                Log.d(TAG, "preference clicked");
                break;

            case "list_preference":
                Log.d(TAG, "list_preference clicked");
                break;

            default:
                Log.d(TAG, "None preference clicked");
                break;
        }
        return false;
    }
}
