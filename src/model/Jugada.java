package model;

import java.io.File;
import java.io.Serializable;

public abstract class Jugada implements Serializable, Comparable{
    private String anio;
    private File imagen;
    
    public Jugada(String pAnio, File pImagen){
        anio = pAnio;
        imagen = pImagen;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }
    
    public int compareTo(Object anotherJugada) throws ClassCastException {
    if (!(anotherJugada instanceof Jugada))
      throw new ClassCastException("A Jugada object expected.");
    String anotherJugadanAnio = ((Jugada) anotherJugada).getAnio();  
    return this.anio.compareTo(anotherJugadanAnio);    
  }
}
