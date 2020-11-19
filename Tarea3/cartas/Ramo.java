package cartas;

import java.util.ArrayList;
import java.util.List;

public class Ramo extends Carta {
    Integer creditos;
    List<Estudio> estudios;
    departamento area;
    int sumaTotal;

    public Ramo(String nombrecito, String lorecito, departamento areacita){
        super(nombrecito, lorecito);
        this.area=areacita;
        this.creditos=areacita.obtenerCreditos();
        this.estudios=new ArrayList<>();
        this.sumaTotal=0;
    }

    int calcularNota(){
        for (Estudio study : estudios) {
            int estudioLocal= study.calcularBonus();
            if (study.area==this.area){
                estudioLocal*=1.25;
                System.out.println("Bonus por area aplicado\n");
            }
            sumaTotal+=estudioLocal;
        }
        sumaTotal-=(this.creditos*2);
        return sumaTotal;
    }

    void anadirEstudio(Estudio estudio){
        estudios.add(estudio);
    }

    public String getNombre(){
        return this.nombre;
    }


    @Override
    public void mostrarCarta() {
        System.out.println("\tNombre: " + nombre + "\n");
        System.out.println("\tLore: " + lore + "\n");
        System.out.println("\tArea: " + area.obtenerSector() + "\n");
        System.out.println("\tCreditos:  " + area.obtenerCreditos() + "\n");
    }
}
