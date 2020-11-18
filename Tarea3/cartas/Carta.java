package cartas;

public abstract class Carta {
    public enum departamento {
        MATEMATICA(7, "Matematica"), HUMANISTA(2, "Humanista"), INFORMATICA(5,"Informatica");

        int creditosRamo;
        String subSector;

        departamento(int c, String s) {
            this.creditosRamo = c;
            this.subSector=s;
        }

        public int obtenerCreditos(){
            return creditosRamo;
        }
        public String obtenerSector(){
            return subSector;
        }
    }
    
    public enum efecto {
        RAV("RAV"), BUFF("Buff"), CDC("Cambio de coordinacion" );

        String nombre;

        efecto(String nombrecito) {
            this.nombre = nombrecito;
        }

        String obtenerEfecto() {
            return this.nombre;
        }
    }
    String nombre;
    String lore;

    public Carta(String nombrecito, String lorecito){
        this.nombre=nombrecito;
        this.lore=lorecito;
    }

    public abstract void mostrarCarta();
}
