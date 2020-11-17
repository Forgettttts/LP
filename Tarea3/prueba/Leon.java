package prueba;
public class Leon {
    String nombre;
    int edad;

    public static void main(String[] args) {
        System.out.println("Leon exitoso");
    }
    public Leon(int edadcita, String nombrecito){
        this.edad=edadcita;
        this.nombre=nombrecito;
    }

    public void showData(){
        System.out.println("La edad es: " +this.edad);
        System.out.println("El nombre es: " +this.nombre);
    }
}