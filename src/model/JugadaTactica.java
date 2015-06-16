package model;

import java.io.File;
import java.io.Serializable;

public class JugadaTactica extends Jugada implements Serializable{
    
    private String jugadorBlanco;
    private String jugadorNegro;

    public JugadaTactica(String pJugadorBlaco, String pJugadorNegro, String pAnio, File pImagen) {
        super(pAnio, pImagen);
        jugadorBlanco = pJugadorBlaco;
        jugadorNegro = pJugadorNegro;
    }

    public String getJugadorBlanco() {
        return jugadorBlanco;
    }

    public String getJugadorNegro() {
        return jugadorNegro;
    }

    public void setJugadorBlanco(String jugadorBlanco) {
        this.jugadorBlanco = jugadorBlanco;
    }

    public void setJugadorNegro(String jugadorNegro) {
        this.jugadorNegro = jugadorNegro;
    }

    @Override
    public String toString() {
        return  super.getAnio() + " / " + jugadorBlanco + " - " + jugadorNegro;
    }
    
}
