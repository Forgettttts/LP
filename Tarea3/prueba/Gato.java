/** 
Como Enseñanza de esto, nos queda que:
    1) El nombre de un paquete, siempre tiene que ser con minusculas y sin numeros
    2) EL nombre de una clase, el nombre del archivo.java y el nombre del constructor, tienen que ser iguales y comenzar con Mayusculas
    3) El constructor es de tipo public .....(){}, no tiene que ser de tipo void
    4) Al momento de compilar, se hace: javac -d . archivo1.java archivo2.java (si las clases se relacionan entre si, deben ir compiladas juntas)
    5) Para poder correr algun codigo ya compilado (un archivo.class) se hace: java paquete.archivo (va sin .class ni .java)
*/
package prueba;
public class Gato {
    enum Level{
        PERRO,
        GATO,
        ZORRO
    }
    public static void main(String[] args){
        Level prueba= Level.GATO;
        if (prueba==Level.GATO){
            System.out.println("Srive para Matemáticas :)");
        }
        
        Tigre tigresito = new Tigre("alan",12);
        tigresito.showData();

        Leon leoncito = new Leon(12, "Pepe");
        leoncito.showData();
    }
}
