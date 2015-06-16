package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Partida implements Serializable{
    
    private ArrayList<Jugada> listaDeJugadas;

    public Partida() {
        listaDeJugadas = new ArrayList<>();
    }

    public void setListaDeJugadas(ArrayList<Jugada> listaDeJugadas) {
        this.listaDeJugadas = listaDeJugadas;
        this.listaDeJugadas.sort(null);
    }

    public ArrayList<Jugada> getListaDeJugadas() {
        listaDeJugadas.sort(null);
        return listaDeJugadas;
    }
    
    public Jugada getJugada(int index){
        listaDeJugadas.sort(null);
        return listaDeJugadas.get(index);
    }
    
    public void anadirJugada(Jugada pJugada){
        listaDeJugadas.add(pJugada);
        listaDeJugadas.sort(null);
    }
}