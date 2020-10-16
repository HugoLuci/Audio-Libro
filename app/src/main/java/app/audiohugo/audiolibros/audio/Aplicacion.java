package app.audiohugo.audiolibros.audio;

import android.app.Application;
import android.content.SharedPreferences;

import java.util.Vector;

/**
 * @author Jova2811 : Víctor Hugo Lucio López
 */

public class Aplicacion extends Application {
    private Vector<Libro> vectorLibros;
    private AdaptadorLibrosFiltro adaptador;
    private Object application;

    @Override
    public void onCreate() {
        super.onCreate();
        vectorLibros = Libro.ejemploLibros();
        adaptador = new AdaptadorLibrosFiltro(this, vectorLibros);
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
    }

    public AdaptadorLibrosFiltro getAdaptador() {
        return adaptador;
    }

    public Vector<Libro> getVectorLibros() {
        return vectorLibros;
    }

    public Object getApplication() {
        return application;
    }
}
