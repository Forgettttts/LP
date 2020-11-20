package resto;

import java.util.Random;

import cartas.*;
import cartas.Carta.departamento;
import cartas.Carta.efecto;

public class Juego {
    
    Mazo mazoCarrera; //* Inicializado y  lleno
    Mazo mazoUniversitario; // * Inicializado y lleno
    Tablero tablero;
    Integer aprobados; // * Inicializado en 0
    Integer reprobados; // * Inicializado en 0
    Mano mano;

    public Juego(){
        this.aprobados=0;
        this.reprobados=0;
        this.mazoCarrera=new Mazo();
        this.mazoUniversitario=new Mazo();

    }

    public void llenarMazoCarrera(){
        Ramo r1 = new Ramo("Mate 1", "¿Creias que eras bueno para las matematicas? lo veremos... Pero tranquilo, en el peor de los casos, al menos tendras una leccion de humildad HAHAHA", departamento.MATEMATICA);
        Ramo r2 = new Ramo("Mate 2", "Vaya vaya, pasaste mate 1, con sus derivadas, veamos si puedes conmigo, yo tengo de mi lado a las integrales y espacios vectoriales... ¿Tu a quien tienes de tu lado?", departamento.MATEMATICA);
        Ramo r3 = new Ramo("Mate 3", "Okay, demostraste que al menos eres digno de cursarme, pero... ¿tendras lo suficiente para aprobarme? Lo veremos pronto", departamento.MATEMATICA);

        Ramo r4 = new Ramo("Etica", "¿A si que quieres ser un aporte para la sociedad, a pesar de que sabes como es? Preparate para ser forjado a base de lecciones de filosofos de antaño", departamento.HUMANISTA);
        Ramo r5 = new Ramo("Historia", "¿Eres de los que le gusta aportar con los datos curiosos? Yo te entrenare, espero que tengas la memoria suficiente para recordarlos todos", departamento.HUMANISTA);
        Ramo r6 = new Ramo("Vision inmanente del quehacer humano", "¿Quieres saber que es lo que te enseñare?... Yo tambien :(", departamento.HUMANISTA);

        Ramo r7 = new Ramo("Estructuras Discretas", "¿Sabes lo que es un grafo? No te preocupes, despues de las amanecidas, planas y planas de LaTeX, no se te olvidaran", departamento.INFORMATICA);
        Ramo r8 = new Ramo("ORGSIS", "¿Crees que tu informacion en tu computador esta a salvo? Creeme que no, al igual que tu salud mental en esta u, tendras que cuidarla mejor", departamento.INFORMATICA);
        Ramo r9 = new Ramo("LP", "Preparate para rushear el aprendizaje de cada lenguaje, y a diferencia de EDD, aqui no tienes compañeros que te salven", departamento.INFORMATICA);
        Ramo r10 = new Ramo("Estructuras de Datos (EDD)", "Si aun crees que un puntero es una lucesita roja, no la pasaras muy bien en este ramo, Python fue lindo, pero aqui las cosas son distintas... pero hey, al menos tienes compañeros que te apoyen", departamento.INFORMATICA);

        mazoCarrera.putBack(r1);
        mazoCarrera.putBack(r2);
        mazoCarrera.putBack(r3);
        mazoCarrera.putBack(r4);
        mazoCarrera.putBack(r5);
        mazoCarrera.putBack(r6);
        mazoCarrera.putBack(r7);
        mazoCarrera.putBack(r8);
        mazoCarrera.putBack(r9);
        mazoCarrera.putBack(r10);
        mazoCarrera.shuffle();
    }

    public void llenarMazoUniversitario(){
        Estudio E1 = new Estudio("Instrospeccion del chacra", "Carta para recorrer tus interiores encontrando la razon de tu sufrimiento en medio de tu estudio (HINT: comienza con US y termina con M)", 2, departamento.HUMANISTA);
        Estudio E2 = new Estudio("Resistirse a cerrito", "Despues de 10 minutos estudiando, lograste dominar tu tentacion de ir a divertirte", 3, departamento.HUMANISTA);
        Estudio E3 = new Estudio("Sandwich del negocio al lado del casino", "Ideal para mejorar la eficiencia del estudio, panza llena = baterias llenas", 2, departamento.HUMANISTA);
        Estudio E4 = new Estudio("Biblio", "Hey, tuviste suerte! no perdera tiempo imprimiendo los textos, porque ya estan en biblioteca", 3, departamento.HUMANISTA);
        Estudio E5 = new Estudio("Visita a 'Don Fede'", "Para no quemarte tus ojos, decides imprimir los textos", 2, departamento.HUMANISTA);
        Estudio E6 = new Estudio("Audifonos + chayanne", "No hay certamen que te supere si estudias con el soundtrack adecuado, certamen, preparate, aqui vamos", 4, departamento.HUMANISTA);

        Estudio M1 = new Estudio("San Wolfram", "Independiente de en que mate(incluso si no es mate, ayuda) estes, tener esto en tu mano, aumenta tus probabilidades de pasar el ramo", 3, departamento.MATEMATICA);
        Estudio M2 = new Estudio("CIAC", "¿Muy perdido con la materia?¿Ni a tu profe le entiendes? Una tutoria del CIAC es lo que te salvara", 2, departamento.MATEMATICA);
        Estudio M3 = new Estudio("Biblioteca", "Stewart, Thomas, etc. los libros para aprender no faltan, toma tu cafe y cuaderno y preparate para matraquear", 2, departamento.MATEMATICA);
        Estudio M4 = new Estudio("Lenguaje formal", "Venir desde el colegio y responder una prueba de desarrollo no es facil, con esto no solo disminuyes errores, si no que hasta salvas puntitos", 2, departamento.MATEMATICA);
        Estudio M5 = new Estudio("Teorema de Weierstrass", "Lo escribi bien? ni idea, pero el tema es que hay preguntas que se responden en un paso al aprender y manejar este teorema que ni si quiera sabemos como se pronuncia xd", 3, departamento.MATEMATICA);
        Estudio M6 = new Estudio("Ver las clases de Juan Muñoz", "Si existiera Dumbledore en la vida real, seria Juanito Muñoz, logra que pases aunque seas mas duro que fiesta de Maradona", 4, departamento.MATEMATICA);

        Estudio I1 = new Estudio("StackOverflow", "Desde progra hasta la titulacion, un amigo infalible, ojo eso si, no copies codigo que no entiendes, o puede salirte en contra", 2, departamento.INFORMATICA);
        Estudio I2 = new Estudio("W3schools", "Si quieres aprender algo desde 0, este es el lugar, ideal cuando no has prestado atencion a clases", 2, departamento.INFORMATICA);
        Estudio I3 = new Estudio("ResumenesDeLaGabi", "A veces un compañero explica mejor que el mismo profe, este studygram y su admin logran salvar ramos enteros con sus post", 3, departamento.INFORMATICA);
        Estudio I4 = new Estudio("Editor de texto", "Entre las extensiones y los temas oscuros, haran que te den ganas de estudiar, o al menos no te las quitaran", 2, departamento.INFORMATICA);
        Estudio I5 = new Estudio("LaTeX", "Sansano que se respeta, lo hacen sufrir con LaTeX, pero una vez lo dominas, los profes amaran las entregas de tus trabajos", 3, departamento.INFORMATICA);
        Estudio I6 = new Estudio("Jflap", "Si hay un trukazo para los automatas, es este software, no pierdas tiempo comprobando a mano tus resultados o haciendo comparaciones, con esto, solo dedicate a aprender", 2, departamento.INFORMATICA);
        Estudio I7 = new Estudio("Biblioteca", "Mesas, una sala, pizarra, plumones y amigos, tienes el kit completo para una provechosa tarde de estudios", 4, departamento.INFORMATICA);
        Estudio I8 = new Estudio("CIAC", "Un intensivo siempre es bueno para confirmar, reforzar o adquirir conocimientos, eso si, sale a respirar aire limpio cada un rato", 3, departamento.INFORMATICA);

        Evento ev1 = new Evento("RAV", "Rebaja Academica Voluntaria, elige un ramo, para que se mezcle con el mazo de carrera", efecto.RAV);
        Evento ev2 = new Evento("Cambio de coordinacion", "Debes elegir un ramo, el cual contara con 50% de probabilidades de que sus creditos aumenten en 3 y 50% de probabilidades de que disminuyan en 3", efecto.CDC);
        Evento ev3 = new Evento("Buff Humanista", "Aumenta en un 25% el puntaje maximo que pueden entregar todas las cartas de estudio a un ramo Humanista en el tablero durante este turno.", efecto.BUFF);
        Evento ev4 = new Evento("Buff Matematico", "Aumenta en un 25% el puntaje maximo que pueden entregar todas las cartas de estudio a un ramo de Matematica en el tablero durante este turno.", efecto.BUFF);
        Evento ev5 = new Evento("Buff Informatico", "Aumenta en un 25% el puntaje maximo que pueden entregar todas las cartas de estudio a un ramo de Informatica en el tablero durante este turno.", efecto.BUFF);

        mazoUniversitario.putBack(E1);
        mazoUniversitario.putBack(E2);
        mazoUniversitario.putBack(E3);
        mazoUniversitario.putBack(E4);
        mazoUniversitario.putBack(E5);
        mazoUniversitario.putBack(E6);

        mazoUniversitario.putBack(M1);
        mazoUniversitario.putBack(M2);
        mazoUniversitario.putBack(M3);
        mazoUniversitario.putBack(M4);
        mazoUniversitario.putBack(M5);
        mazoUniversitario.putBack(M6);

        mazoUniversitario.putBack(I1);
        mazoUniversitario.putBack(I2);
        mazoUniversitario.putBack(I3);
        mazoUniversitario.putBack(I4);
        mazoUniversitario.putBack(I5);
        mazoUniversitario.putBack(I6);
        mazoUniversitario.putBack(I7);
        mazoUniversitario.putBack(I8);

        mazoUniversitario.putBack(ev1);
        mazoUniversitario.putBack(ev2);
        mazoUniversitario.putBack(ev3);
        mazoUniversitario.putBack(ev4);
        mazoUniversitario.putBack(ev5);

        mazoUniversitario.shuffle();
    }
    
    public static void main(String[] args){
        
    }
}
