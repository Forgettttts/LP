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

    public void jugarEstudio(Estudio estudio, Integer pos){
        this.horasDisponibles-=estudio.getHoras();
        Ramo ramito= semestre.get(pos);
        ramito.anadirEstudio(estudio);
        System.out.println("Se aplico la carta estudio: "+estudio.getName()+" al ramo: "+ramito.getNombre());
    }

    /**
     * getSemestre: Retorna la la lista de los ramos del semestre 
     *
     * @return List<Ramo>: Se retorna la lista de ramos.
     */
    public List<Ramo> getSemestre(){
        return this.semestre;
    }

    public void mostrarTablero(){
        
        System.out.println("Horas disponibles: " + horasDisponibles);
        System.out.println("Ramos presentes en el semestre: \n");
        for (Ramo ramo : semestre) {
            System.out.println("\t"+ ramo.getNombre()+"\n");
        }
        
    }
}
