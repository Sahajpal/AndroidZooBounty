package com.example.thezoo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;

public class UserSettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_user_setting);

        findPreference("bgMusicPref").setOnPreferenceChangeListener(
                new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(Preference preference, Object o) {
                        boolean x = (boolean) (o);
                        // True to update the state of the Preference with the new value.
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(UserSettingActivity.this);
                        if(x) {
                            SoundService.player.start();
                        } else {
                            SoundService.player.pause();
                        }
                        return true;
                    }
                });
    }
}