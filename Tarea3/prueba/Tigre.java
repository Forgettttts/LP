package prueba;

public class Tigre {
    String nombre;
    int edad;

    public static void main(String[] args) {
        System.out.println("Tigre exitoso");
    }

    public Tigre(String nombrecito, int edadcita){
        this.nombre= nombrecito;
        this.edad= edadcita;
    }
    
    public void showData(){
        System.out.println("El nombre es: " +this.nombre);
        System.out.println("La edad es: " +this.edad);
    }


}