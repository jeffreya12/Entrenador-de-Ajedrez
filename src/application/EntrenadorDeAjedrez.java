/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import gui.Bienvenida;
import gui.CrearJugadaTactica;
import gui.CrearJugadaTeorica;
import gui.VentanaPrincipal;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import model.Jugada;
import model.Partida;

public class EntrenadorDeAjedrez {

    private static Partida partida = new Partida();
    
    public static void write(){
        Jugada pJugada;
        try {
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("src/text/Jugadas.txt"));
            for (int i = 0; i < partida.getListaDeJugadas().size(); i++){
                pJugada = partida.getListaDeJugadas().get(i);
                escribir.writeObject(pJugada);
            }
            escribir.close();  // Se cierra al terminar.
        }
        catch (IOException ex) {
            Logger.getLogger(CrearJugadaTactica.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(CrearJugadaTeorica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void initJugadas() throws IOException, ClassNotFoundException, EOFException{
        // Se lee el primer objeto
        ObjectInputStream lector = new ObjectInputStream(new FileInputStream("src/text/Jugadas.txt"));
        // Se lee el primer objeto
        Object aux = lector.readObject();
        // Mientras haya objetos
        while (aux != null){
            if (aux instanceof Jugada){
                partida.anadirJugada((Jugada) aux);
            }
            
            try {
                aux = lector.readObject();
            }
            catch (IOException | ClassNotFoundException e) {
                lector.close();
                break;
            }
        }
        lector.close();
    }
    
    public static Partida getPartida() {
        return partida;
    }

    public static void setPartida(Partida pPartida) {
        EntrenadorDeAjedrez.partida = pPartida;
    }
    
    public static void main(String[] args) throws IOException, 
            ClassNotFoundException, InstantiationException, 
            IllegalAccessException, UnsupportedLookAndFeelException {
        try {
            OUTER:
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (null != info.getName()) {
                    switch (info.getName()) {
                        case "Windows":
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break OUTER;
                        case "GTK+":
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break OUTER;
                    }
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException |
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try{
            initJugadas();
        }
        catch(EOFException e){
            File jugadasAux = new File("src/text/Jugadas.txt");
            if (jugadasAux.length() == 0){
                Bienvenida bienvenida = new Bienvenida();
                bienvenida.setLocationRelativeTo(null);
                bienvenida.setVisible(true);
            }           
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "El archivo de guardado ha sido removido o cambiado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
    }
}
