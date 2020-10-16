package app.audiohugo.audiolibros.audio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import app.audiohugo.audiolibros.audio.fragments.PreferenciasFragment;

/**
 * @author Jova2811 : Víctor Hugo Lucio López
 */

public class PreferenciasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.
                content, new PreferenciasFragment()).commit();
    }
}