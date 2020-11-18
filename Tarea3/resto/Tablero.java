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
        if (pos ==-1){
            this.horasDisponibles -= estudio.getHoras();
            System.out.println("Estudio realizado, ahora solo te quedan "+this.horasDisponibles+" horas disponibles \n");
            //! Cual es el efecto que realiza la carta estudio? que parametros son los que cambia?

        }
    }

    void mostrarTablero(){
        System.out.println("Ramos presentes en el semestre: \n");
        for (Ramo ramo : semestre) {
            System.out.println("\t"+ ramo.getNombre()+"\n");
        }
        
    }
}
