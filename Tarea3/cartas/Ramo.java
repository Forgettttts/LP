package cartas;

import java.util.List;

class Ramo extends Carta {
    int creditos;
    //! List<Estudio>                      <-- AYUDA AQUI
    //! Enum area;                         <-- AYUDA AQUI

    /** 
    public Ramo(String nombrecito, String lorecito){
        this.lore=lorecito;
        this.nombre=nombrecito;
    }


    public void showData(){
        System.out.println(this.nombre);
        System.out.println(this.lore);
    }
    */
    void calcularNota(){
        System.out.println("Metodo calcularNota()");
    }

    void anadirEstudio(){//! Falta los parametros, pq es de tipo Estudio                     <-- AYUDA AQUI
        System.out.println("Implementando anadirEstudio()");
    }


    @Override
    void mostrarCarta() {
        System.out.println("Implementando mostrarCarta()");
    }
}
