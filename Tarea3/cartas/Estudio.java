package cartas;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Estudio extends Carta{
    
    Integer horas;
    Integer bonusMin ;
    int bonusMax ;
    departamento area;
    String variante;

    public Estudio(String nombrecito, String lorecito, Integer horitas, departamento areacita){
        super(nombrecito, lorecito);
        this.area=areacita;
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
/**
         * getHoras: obtener la cantidad de horas que gasta un estudio
         *
         * @return int: Las horas correspondientes.
         */
    public int getHoras(){
        return this.horas;
    }
/**
         * getName: obtener el nombre de cada carta
         *
         * @return String: El nombre correspondiente.
         */
    public String getName(){
        return nombre;
    }
    @Override
    public void mostrarCarta() {
        System.out.println("\tNombre: "+nombre+"\n");
        System.out.println("\tLore: "+ lore+"\n");
        System.out.println("\tVariante: "+ variante+"\n");
        System.out.println("\tHoras de estudio: "+ horas+"\n");
        System.out.println("\tArea: "+ area.obtenerSector()+"\n");
        System.out.println("\tCreditos:  "+ area.obtenerCreditos()+"\n");
        
        System.out.println("\n.................................................................");
        }
    }
