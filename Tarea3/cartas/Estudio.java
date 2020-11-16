package cartas;

public class Estudio extends Carta{
    Integer horas;
    Integer bonusMin ;
    Integer bonusMax ;
    //! Enum area;                     <-- AYUDA AQUI

    void calcularBonus(){
        System.out.println("Implementando calcularBonus()");
    }
    @Override
    void mostrarCarta() {
        System.out.println("Implementando mostrarCarta()");
    }
    
}
