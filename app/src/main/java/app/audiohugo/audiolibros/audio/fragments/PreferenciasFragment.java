package app.audiohugo.audiolibros.audio.fragments;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import app.audiohugo.audiolibros.R;

public class PreferenciasFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences);
    }
}
