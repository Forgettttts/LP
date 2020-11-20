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
        
        /**
         * obtenerCreditos: obtener creditos de cada departamento de la universidad
         *
         * @return int: los creditos correspondientes.
         */
        public int obtenerCreditos(){
            return creditosRamo;
        }
        
        /**
         * obtenerSector: obtener area de cada departamento de la universidad
         *
         * @return String: El area correspondiente.
         */
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
        
        /**
         * obtenerEfecto: obtener el efecto de cada evento
         *
         * @return String: El efecto correspondiente.
         */
        public String obtenerEfecto() {
            return this.nombre;
        }
    }
    String nombre;
    String lore;

    /**
     * getName: Obtener nombre de la carta
     *
     * @return String: El nombre correspondiente.
     */
    public String getName(){
        return this.nombre;
    }

    public Carta(String nombrecito, String lorecito){
        this.nombre=nombrecito;
        this.lore=lorecito;
    }

    public abstract void mostrarCarta();
}
