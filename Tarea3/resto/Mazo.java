package resto;

import java.util.ArrayList;
import java.util.*;

import cartas.*;

public class Mazo {
    List<Carta> cartas;

    public Mazo(){
        this.cartas= new ArrayList<>();
    }

    /**
     * eliminarEnPosicion: Elimina la carta en la posicion entregada por parametro y
     * la retorna
     *
     * @param posicion int : posicion donde se encuentra el elemento que queremos eliminar.
     * @return Carta: Se retorna la carta que se elimina.
     */
    public Carta eliminarEnPosicion(Integer posicion){
        return this.cartas.remove((int)(posicion));
    }

    public void putBack(Carta carta){
        this.cartas.add(carta);
    }
    public Carta draw(){
        if (this.cartas.isEmpty()){
            System.out.println("Mazo vacio, no hay carta que entregar\n");
            return null;
        }
        return this.cartas.remove(this.cartas.size()-1);
    
    }

    /**
     * getInPosition: Retorna la carta presente en la posicion ingresada como parametro
     *
     * @param posicion Integer  : posicion donde se encuentra el elemento que queremos
     *                 retornar.
     * @return Carta: Se retorna la carta que se solicita por parametro.
     */
    public Carta getInPosition(Integer posicion){
        return cartas.get(posicion);
    }

    public void shuffle(){
        if (this.cartas.isEmpty()){
            System.out.println("Mazo vacio, no puede ser revuelto");
        }
        else{
            Collections.shuffle(this.cartas);
        }
    }
}
