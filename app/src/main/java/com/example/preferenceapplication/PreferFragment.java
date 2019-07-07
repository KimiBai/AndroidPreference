package com.example.preferenceapplication;

import android.os.Bundle;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.util.Log;

public class PreferFragment extends PreferenceFragmentCompat implements
        Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {

    private final String TAG = getClass().getSimpleName();

    private Preference mTv;
    private EditTextPreference mEt;
    private CheckBoxPreference mCb;
    private ListPreference mList;
    private SwitchPreference mSwitch;

    public PreferFragment() {
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
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
        mList.setOnPreferenceChangeListener(this);
        mSwitch.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        switch (preference.getKey()) {
            case "switch_preference":
                Log.d(TAG, "switch_preference preference changed");
                mSwitch.setSummary(String.valueOf(o));
                break;
            case "checkbox_preference_1":
                Log.d(TAG, "checkbox_preference_1 preference changed");
                mCb.setSummary(String.valueOf(o));
                break;
            case "edittext_preference":
                Log.d(TAG, "edit text preference changed");
                mEt.setSummary(String.valueOf(o));
                break;
            case "list_preference":
                ListPreference list = (ListPreference) preference;
                CharSequence entry = list.getEntry();
                mList.setSummary(entry.toString());
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
