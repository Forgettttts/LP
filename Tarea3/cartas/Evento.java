package cartas;

import resto.*;
public class Evento extends Carta{
    

    public efecto eventito;
    void aplicarEvento( Tablero tablero, Mazo mazoCarrera){
        //! Falta la implementacion aqui, despues de hacer tablero
    }

    public Evento(String nombrecito, String lorecito, efecto efectito){
        super(nombrecito, lorecito);
        eventito=efectito;
    }

    @Override
    public void mostrarCarta() {
        System.out.println("\tNombre: " + nombre + "\n");
        System.out.println("\tLore: " + lore + "\n");
        System.out.println("\tEfecto de evento: " + eventito.obtenerEfecto() + "\n");
    }
}
