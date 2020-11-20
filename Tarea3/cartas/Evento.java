package cartas;

import resto.*;

public class Evento extends Carta{
    

    public efecto eventito;
    void aplicarEvento( Tablero tablero, Mazo mazoCarrera, Integer posicionCarta){
        if (this.eventito.obtenerEfecto().equals("RAV")){
            Carta ramoBotado= mazoCarrera.eliminarEnPosicion(posicionCarta);
            System.out.println("Botaste el ramo "+ramoBotado.getName());
        }
        else if( this.eventito.obtenerEfecto().equals("Cambio de coordinacion")){
            if (Math.random() < 0.5) {
                Carta ramoAfectado = mazoCarrera.getInPosition(posicionCarta);
            } else {
            }
            break;

        }
        else if(this.eventito.obtenerEfecto().equals("Buff")){

        }
        else{
            System.out.println("Error al detectar evento. Evento no aplicado\n");
        }
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
