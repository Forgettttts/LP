package cartas;


import resto.*;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
public class Evento extends Carta{
    

    public efecto eventito;
    public void aplicarEvento( Tablero tablero, Mazo mazoCarrera){

        if (this.eventito.obtenerEfecto().equals("RAV")){
            Integer posicionCarta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la carta que elija desde la primera (1), hasta la ultima (" + (((tablero.getSemestre()).size())) + ") (En caso de que la entrada invalida, se aplicara a la primera carta)\n"));

            posicionCarta-=1;

            if ((posicionCarta>=0) && (posicionCarta<= (((tablero.getSemestre()).size()))-1)){
                mazoCarrera.putBack((tablero.getSemestre()).get(posicionCarta));
                mazoCarrera.shuffle();
                (tablero.getSemestre()).remove(posicionCarta);
            }        
            else{
                mazoCarrera.putBack((tablero.getSemestre()).get(0));
                mazoCarrera.shuffle();
                (tablero.getSemestre()).remove(0);
            }
            System.out.println("Botaste el ramo \n");
        }
        else if( this.eventito.obtenerEfecto().equals("Cambio de coordinacion")){
            Integer posicionCarta = Integer.parseInt(JOptionPane
                    .showInputDialog("Ingrese el numero de la carta que elija, desde la primera (1), hasta la ultima ("
                            + (((tablero.getSemestre()).size()))
                            + ") (En caso de entrada invalida, se aplicara a la primera carta)\n"));

            posicionCarta -= 1;

            if ((posicionCarta >= 0) && (posicionCarta <= (((tablero.getSemestre()).size())) - 1)) {
                Ramo ramote=(tablero.getSemestre()).get(posicionCarta);
                if(ramote.area==departamento.INFORMATICA){
                    if (Math.random() < 0.5) {
						ramote.creditos=2;
						System.out.println("Al ramo informatico elegido, "+ramote.nombre+", se le quitaron 3 creditos");
					} else {
						ramote.creditos=8;
						System.out.println("Al ramo: "+ramote.nombre+" se le añadieron 3 creditos, ahora cuentas con 8");
					}
                    
                }
                else if (ramote.area == departamento.MATEMATICA) {
                    if (Math.random() < 0.5) {
						ramote.creditos=4;
						System.out.println("Al ramo Matematico elegido, "+ramote.nombre+" se le quitaron 3 creditos");
					} else {
						ramote.creditos=10;
						System.out.println("Al ramo: "+ramote.nombre+" se le añadieron 3 creditos, ahora cuentas con 10");
					}
                }
                else {
                    if (Math.random() < 0.5) {
                        ramote.creditos = -1;
                        System.out.println("Al ramo Humanista elegido," + ramote.nombre + " se le quitaron 3 creditos");
                    } else {
                        ramote.creditos = 5;
                        System.out.println("Al ramo " + ramote.nombre + " se le añadieron 3 creditos, ahora cuentas con 5");
                    }
                }
            } else {
                mazoCarrera.putBack((tablero.getSemestre()).get(0));
                mazoCarrera.shuffle();
                (tablero.getSemestre()).remove(0);
            }

        }
        else if(this.eventito.obtenerEfecto().equals("Buff")){
            Integer posicionCarta = Integer.parseInt(JOptionPane
                    .showInputDialog("Ingrese el numero de la carta que elija, desde la primera (1), hasta la ultima ("
                            + (((tablero.getSemestre()).size()))
                            + ") (En caso de entrada invalida, se aplicara a la primera carta)\n"));
            if ((posicionCarta >= 0) && (posicionCarta <= (((tablero.getSemestre()).size())) - 1)) {
                Ramo ramooo=((tablero.getSemestre()).get(posicionCarta));
                departamento area_local=ramooo.area;

                for (int iterador1 = 0; iterador1 < tablero.getSemestre().size(); iterador1++) {
                    Ramo ramo_interno = tablero.getSemestre().get(iterador1);
                    if (ramo_interno.area == area_local) {
                        for (int iterador2 = 0; iterador2 < ramo_interno.estudios.size(); iterador2++) {
                            Estudio e = ramo_interno.estudios.get(iterador2);
                            e.bonusMax *= 1.25;
                        }
                    }
                }
            } else {
                Ramo ramooo = ((tablero.getSemestre()).get(0));
                departamento area_local = ramooo.area;

                for (int iterador1 = 0; iterador1 < tablero.getSemestre().size(); iterador1++) {
                    Ramo ramo_interno = tablero.getSemestre().get(iterador1);
                    if (ramo_interno.area == area_local) {
                        for (int iterador2 = 0; iterador2 < ramo_interno.estudios.size(); iterador2++) {
                            Estudio e = ramo_interno.estudios.get(iterador2);
                            e.bonusMax *= 1.25;
                        }
                    }
                }
            }
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
