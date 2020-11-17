package cartas;

abstract class Carta {
    enum departamento {
        MATEMATICA(7), HUMANISTA(2), INFORMATICA(5);

        int creditosRamo;

        departamento(int c) {
            this.creditosRamo = c;
        }
    }
    String nombre;
    String lore;

    abstract void mostrarCarta();
}
