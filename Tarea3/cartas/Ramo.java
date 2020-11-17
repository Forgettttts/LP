package cartas;

import java.util.ArrayList;
import java.util.List;

class Ramo extends Carta {
    Integer creditos;
    List<Estudio> estudios;
    departamento area;
    int sumaTotal;

    public Ramo(Integer credititos, departamento areacita){
        this.creditos=credititos;
        this.area=areacita;
        this.estudios=new ArrayList<>();
        this.sumaTotal=0;
    }

    int calcularNota(){
        for (Estudio study : estudios) {
            int estudioLocal= study.calcularBonus();
            if (study.area==this.area){
                estudioLocal*=1.25;
            }
            sumaTotal+=estudioLocal;
        }
        sumaTotal-=(this.creditos*2);
        return sumaTotal;
    }

    void anadirEstudio(Estudio estudio){
        estudios.add(estudio);
    }


    @Override
    void mostrarCarta() {
        System.out.println("Implementando mostrarCarta()");
    }
}
