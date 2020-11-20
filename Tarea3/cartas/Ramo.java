package cartas;

import java.util.ArrayList;
import java.util.List;

public class Ramo extends Carta {
    Integer creditos;
    List<Estudio> estudios;
    departamento area;
    int sumaTotal;
    int bonusEvento;

    public Ramo(String nombrecito, String lorecito, departamento areacita){
        super(nombrecito, lorecito);
        this.area=areacita;
        this.creditos=areacita.obtenerCreditos();
        this.estudios=new ArrayList<>();
        this.sumaTotal=0;
        this.bonusEvento=0;
    }

    public int calcularNota(){
        for (Estudio study : estudios) {
            int estudioLocal= study.calcularBonus();
            if (study.area==this.area){
                estudioLocal*=1.25;
                System.out.println("Bonus por area aplicado\n");
            }
            sumaTotal+=estudioLocal;
        }
        sumaTotal-=((this.creditos+this.bonusEvento)*2);
        return sumaTotal;
    }

    public void anadirEstudio(Estudio estudio){
        estudios.add(estudio);
    }

    /**
     * getNombre: Obtener nombre de un ramo
     *
     * @return String: El nombre correspondiente.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * setBonusEventos: Setear el bonus de cada evento
     *
     * @return void: Solo setea el valor
     */
    public void setBonusEvento(int bonus){
        this.bonusEvento=bonus;
    }

    @Override
    public void mostrarCarta() {
        System.out.println("\tNombre: " + nombre + "\n");
        System.out.println("\tLore: " + lore + "\n");
        System.out.println("\tArea: " + area.obtenerSector() + "\n");
        System.out.println("\tCreditos:  " + area.obtenerCreditos() + "\n");
    }
}
