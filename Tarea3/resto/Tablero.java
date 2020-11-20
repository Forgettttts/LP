package resto;

import cartas.*;
import java.util.ArrayList;
import java.util.*;
public class Tablero {
    List<Ramo> semestre;
    Integer horasDisponibles;

    public Tablero(){
        horasDisponibles=12;
        semestre=new ArrayList<>(10);
    }

    void jugarEstudio(Estudio estudio, Integer pos){
        this.horasDisponibles-=estudio.getHoras();
        Ramo ramito= semestre.get(pos);
        ramito.anadirEstudio(estudio);
        System.out.println("Se aplico la carta estudio: "+estudio.getName()+" al ramo: "+ramito.getNombre());
    }

    void mostrarTablero(){
        System.out.println("Ramos presentes en el semestre: \n");
        for (Ramo ramo : semestre) {
            System.out.println("\t"+ ramo.getNombre()+"\n");
        }
        
    }
}
