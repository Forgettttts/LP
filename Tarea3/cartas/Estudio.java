package cartas;

public class Estudio extends Carta{
    
    Integer horas;
    Integer bonusMin ;
    Integer bonusMax ;
    departamento area;

    public Estudio(Integer horitas){
        this.horas=horitas;
        if (this.horas==2){
            this.bonusMin=18;
            this.bonusMax=26;}
        else if (this.horas == 3){
            this.bonusMin=28;
            this.bonusMax=40;}
        else if(this.horas==4){
            this.bonusMin=20;
            this.bonusMax=90;}
        else{
            System.out.println("Variante indeterminada, bonus no realizado");
        }
    }
    int calcularBonus(){
        return (int)(Math.random()*(this.bonusMax-this.bonusMin+1)+this.bonusMin);
    }
    @Override
    void mostrarCarta() {
        System.out.println("Implementando mostrarCarta()");
    }
    
}
