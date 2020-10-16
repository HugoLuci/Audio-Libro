package app.audiohugo.audiolibros.audio;

import android.content.Context;

import java.util.Vector;
/**
 * @author Jova2811 : Víctor Hugo Lucio López
 */


public class AdaptadorLibrosFiltro extends AdaptadorLibros {
    private Vector<Libro> vectorSinFiltro;// Vector con todos los libros que necesitamos
    private Vector<Integer> indiceFiltro; // Índice en vectorSinFiltro
    // Cada elemento de vectorLibros
    private String busqueda = ""; // Búsqueda sobre autor o título
    private String genero = ""; // Genero seleccionado
    private boolean novedad = false; // Si queremos ver solo novedades
    private boolean leido = false; // Si queremos ver solo leidos
    public AdaptadorLibrosFiltro(Context contexto,
                                 Vector<Libro> vectorLibros) {
        super(contexto, vectorLibros);
        vectorSinFiltro = vectorLibros;
        recalculaFiltro();
    }
    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda.toLowerCase();
        recalculaFiltro();
    }
    public void setGenero(String genero) {
        this.genero = genero;
        recalculaFiltro();
    }
    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
        recalculaFiltro();
    }
    public void setLeido(boolean leido) {
        this.leido = leido;
        recalculaFiltro();
    }
    public void recalculaFiltro() {
        vectorLibros = new Vector<Libro>();
        indiceFiltro = new Vector<Integer>();
        for (int i = 0; i < vectorSinFiltro.size(); i++) {
            Libro libro = vectorSinFiltro.elementAt(i);
            if ((libro.titulo.toLowerCase().contains(busqueda) ||
                    libro.autor.toLowerCase().contains(busqueda))
                    && (libro.genero.startsWith(genero))
                    && (!novedad || (novedad && libro.novedad))
                    && (!leido || (leido && libro.leido))) {
                vectorLibros.add(libro);
                indiceFiltro.add(i);
            }
        }
    }
    public Libro getItem(int posicion) {
        return vectorSinFiltro.elementAt(indiceFiltro.elementAt(posicion));
    }
    public long getItemId(int posicion) {
        return indiceFiltro.elementAt(posicion);
    }
    public void borrar(int posicion){
        vectorSinFiltro.remove((int)getItemId(posicion));
        recalculaFiltro();
    }
    public void insertar(Libro libro){
        vectorSinFiltro.add(libro);
        recalculaFiltro();
    }
}