package cartas;

public class Estudio extends Carta{
    
    Integer horas;
    Integer bonusMin ;
    Integer bonusMax ;
    departamento area;
    String variante;

    public Estudio(String nombrecito, String lorecito, Integer horitas){
        super(nombrecito, lorecito);
        this.horas=horitas;
        if (this.horas==2){
            variante="Comun";
            this.bonusMin=18;
            this.bonusMax=26;}
        else if (this.horas == 3){
            variante="Rara";
            this.bonusMin=28;
            this.bonusMax=40;}
        else if(this.horas==4){
            variante="Epica";
            this.bonusMin=20;
            this.bonusMax=90;}
        else{
            System.out.println("Variante indeterminada, bonus no realizado");
        }
    }
    public int calcularBonus(){
        return (int)(Math.random()*(this.bonusMax-this.bonusMin+1)+this.bonusMin);
    }

    public int getHoras(){
        return this.horas;
    }
    @Override
    public void mostrarCarta() {
        System.out.println("\tNombre: "+nombre+"\n");
        System.out.println("\tLore: "+ lore+"\n");
        System.out.println("\tVariante: "+ variante+"\n");
        System.out.println("\tHoras de estudio: "+ horas+"\n");
        System.out.println("\tArea: "+ area.obtenerSector()+"\n");
        System.out.println("\tCreditos:  "+ area.obtenerCreditos()+"\n");
        }
    }
