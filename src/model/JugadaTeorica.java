package model;

import java.io.File;
import java.io.Serializable;

public class JugadaTeorica extends Jugada implements Serializable{
    private String nombre;

    public JugadaTeorica(String pNombre, String pAnio, File pImagen) {
        super(pAnio, pImagen);
        nombre = pNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return super.getAnio()  + " / " +  nombre;
    }
}
