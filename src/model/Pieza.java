package model;

import java.io.File;

public class Pieza {
    private File imagen;
    private int posicionX;
    private int posicionY;

    public Pieza(int pX, int pY, File pImagen){
        imagen = pImagen;
        posicionX = pX;
        posicionY = pY;
    }

    public File getImagen() {
        return imagen;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}
