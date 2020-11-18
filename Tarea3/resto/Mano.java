package resto;
import cartas.*;

import java.util.ArrayList;
import java.util.*;
public class Mano{
    List<Carta> cartas;

    public Mano(){
        cartas = new ArrayList<>(6);
    }

    void mostrarMano(){
        System.out.println("Cartas: \n");
        for (Carta card : cartas) {
            card.mostrarCarta();
        }
    }

    void anadirCarta(Carta carta){
        if (cartas.size()<6){
            this.cartas.add(carta);}
        else{
            System.out.println("Mano llena, no puedes tener mas de 6 cartas en tu mano \n");
        }
    }

    Carta seleccionarCarta(Integer pos){
        return this.cartas.get(pos);
    }
}
