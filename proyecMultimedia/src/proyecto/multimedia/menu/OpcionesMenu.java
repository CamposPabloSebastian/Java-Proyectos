package proyecto.multimedia.menu;

import java.util.Scanner;
import validaciones.Validar;
import proyecto.multimedia.objetos.*;

/**
 * clase que trabaja la interacion con el usuario
 * @author pscam
 */
public class OpcionesMenu {

    private static final int TAMAÑO_MAXIM0 = 25; // constante para definir el tamaño maximo del array
    private Scanner sc = new Scanner(System.in);
    private EstanteriaMultimedia biblioteca = new EstanteriaMultimedia(TAMAÑO_MAXIM0);
    private final Validar validar = new Validar();

    /**
     * construnctor por defecto (no es necesario definirlo)
     */
    public OpcionesMenu() {

    }

    /**
     * Metodo que muestra el menu principal para seleccionar las funciones que
     * deseamos realizar 0 Carga los elementos ya definidos y los guarda en un
     * fichero 1 cargar nuevo cd fotos 2 cargar nuevo cd videos 3 cargar nuevo
     * disco 4 cargar nueva pelicula 5 listar los elementos, listado completo o
     * filtrando por tipo
     */
    public void menu() {
        biblioteca = new EstanteriaMultimedia(TAMAÑO_MAXIM0);
        biblioteca.leerObjetos();
        System.out.println("El array tiene 25 lugares, de los cuales 20 son utilizados"
                + " al INICIAR PROGRAMA, restan 5 para agregar luego.\n"
                + "Solo INICIAR PROGRAMA una vez para crear fichero"
                + " y cargar los objetos previamente creados.\n");
        System.out.println("0- INICIAR PROGRAMA.\n"
                + "1- Cargar CD Fotos\n2- Cargar CD Video\n3- Cargar Disco\n"
                + "4- Cargar Pelicula\n5- Leer fichero y mostrar listado");
        int opcion = pedirDatoEntero();
        String titulo, autor;
        switch (opcion) {
            case 0:
                cardarDatos();
                biblioteca.guardarObjetos();
                break;

            case 1:
                System.out.println("Cargar titulo");
                titulo = pedirDato();
                System.out.println("Cargar autor");
                autor = pedirDato();
                CD_Fotos cdf = new CD_Fotos(titulo, autor, 0, 0);
                if (!biblioteca.comprobarExistencia(cdf)) {
                    if (biblioteca.add(cdf)) {
                        biblioteca.guardarObjetos();
                        System.out.println("CD Fotos cargado");
                    }
                } else {
                    System.out.println("CD Fotos ya existe");
                }
                break;

            case 2:
                System.out.println("Cargar titulo");
                titulo = pedirDato();
                System.out.println("Cargar autor");
                autor = pedirDato();
                CD_Videos cdv = new CD_Videos(titulo, autor, 0, 0);
                if (!biblioteca.comprobarExistencia(cdv)) {
                    if (biblioteca.add(cdv)) {
                        biblioteca.guardarObjetos();
                        System.out.println("CD Video cargado");
                    }
                } else {
                    System.out.println("CD Video ya existe");
                }
                break;

            case 3:
                System.out.println("Cargar titulo");
                titulo = pedirDato();
                System.out.println("Cargar autor");
                autor = pedirDato();
                Disco d = new Disco(titulo, autor, 0, null);
                if (!biblioteca.comprobarExistencia(d)) {
                    if (biblioteca.add(d)) {
                        biblioteca.guardarObjetos();
                        System.out.println("Disco cargado");
                    } else {
                        System.out.println("Disco ya existe");
                    }
                }
                break;

            case 4:
                System.out.println("Cargar titulo");
                titulo = pedirDato();
                System.out.println("Cargar autor");
                autor = pedirDato();
                Pelicula p = new Pelicula(titulo, autor, 0, null);
                if (!biblioteca.comprobarExistencia(p)) {
                    if (biblioteca.add(p)) {
                        biblioteca.guardarObjetos();
                        System.out.println("Pelicula cargada");
                    } else {
                        System.out.println("Pelicula ya existe");
                    }
                }
                break;

            case 5:
                imprimirObjetos();
                System.out.println("El tamaño del tu biblioteca es de " + TAMAÑO_MAXIM0 + " elementos");
                System.out.println("Te quedan " + (TAMAÑO_MAXIM0 - biblioteca.size()) + " espacios libres");
                break;

        }
    }

    /**
     * metodo privado que imprime los objetos de la forma selecionada. 1
     * filtrando por cd foto 2 filtrando por cd video 3 filtrando por disco 4
     * filtrando por pelicula 5 lista completa contenida en el fichero
     */
    private void imprimirObjetos() {

        System.out.println("QUE LISTA MOSTRAR?\n1- CD Fotos\n2- CD Videos\n3- Disco\n4- Peliculas\n"
                + "5- Lista Completa");
        int opcion = pedirDatoEntero();

        switch (opcion) {
            case 1:
                System.out.println("Lista de CD Fotos");
                for (Multimedia e : biblioteca) {
                    if (e instanceof CD_Fotos) {
                        System.out.println(e);
                    }
                }
                break;
            case 2:
                System.out.println("Lista de CD Videos");
                for (Multimedia e : biblioteca) {
                    if (e instanceof CD_Videos) {
                        System.out.println(e);
                    }
                }
                break;
            case 3:
                System.out.println("Lista de Discos");
                for (Multimedia e : biblioteca) {
                    if (e instanceof Disco) {
                        System.out.println(e);
                    }
                }
                break;
            case 4:
                System.out.println("Lista de Peliculas");
                for (Multimedia e : biblioteca) {
                    if (e instanceof Pelicula) {
                        System.out.println(e);
                    }
                }
                break;
            case 5:
                System.out.println("Lista completa");
                for (Multimedia e : biblioteca) {
                    System.out.println(e);
                }
                break;
        }
    }

    /**
     * metodo que pide dato al usuario y valida que sea numero, permite 3
     * intentos
     *
     * @return numero entero o -1 si es incorrecto
     */
    public int pedirDatoEntero() {
        boolean numCorrecto;
        int intentos = 2;
        String numero = null;
        do {
            numero = sc.nextLine().trim();
            numCorrecto = validar.esNumero(numero);
            if (!numCorrecto) {
                System.out.println("Ingrese opcion valida.");
            }
        } while (!numCorrecto || intentos == 0);

        return Integer.parseInt(numero);
    }

    /**
     * metodo que pide dato String al usuario y lo pasa a minuscula
     * @return String ingresado
     */
    private String pedirDato() {
        return sc.nextLine().trim().toLowerCase();
    }

    /**
     * metodo que añada al array los elementos previamente creados.
     */
    private void cardarDatos() {
        Pelicula peli1 = new Pelicula("TORRENTE 1", "no se", 98, "serna");
        Pelicula peli2 = new Pelicula("TORRENTE 2", "no se", 88, "serna");
        Pelicula peli3 = new Pelicula("TORRENTE 3", "no se", 67, "serna");
        Pelicula peli4 = new Pelicula("TORRENTE 4", "no se", 34, "serna");
        Pelicula peli5 = new Pelicula("TORRENTE 5", "no se", 128, "serna");
        biblioteca.add(peli1);
        biblioteca.add(peli2);
        biblioteca.add(peli3);
        biblioteca.add(peli4);
        biblioteca.add(peli5);

        Disco disc1 = new Disco("COLD PLAY", "martin", 0, "Rock");
        Disco disc2 = new Disco("LA BERSUIT", "cordera", 0, "rock");
        Disco disc3 = new Disco("LOS PIOJS", "ciro", 0, "punk");
        Disco disc4 = new Disco("CALAMARO", "calamaro", 0, "poop");
        Disco disc5 = new Disco("FITO PAEZ", "fito", 0, "pop");
        biblioteca.add(disc1);
        biblioteca.add(disc2);
        biblioteca.add(disc3);
        biblioteca.add(disc4);
        biblioteca.add(disc5);

        CD_Fotos fotos1 = new CD_Fotos("VACAS 2010", "yo", 12, 12);
        CD_Fotos fotos2 = new CD_Fotos("VACAS 2011", "yo", 45, 556);
        CD_Fotos fotos3 = new CD_Fotos("VACAS 2012", "yo", 5, 9);
        CD_Fotos fotos4 = new CD_Fotos("VACAS 2013", "yo", 14, 32);
        CD_Fotos fotos5 = new CD_Fotos("VACAS 2013", "yo", 34, 234);
        biblioteca.add(fotos1);
        biblioteca.add(fotos2);
        biblioteca.add(fotos3);
        biblioteca.add(fotos4);
        biblioteca.add(fotos5);

        CD_Videos video1 = new CD_Videos("VACAS 2015", "yo", 10, 4);
        CD_Videos video2 = new CD_Videos("VACAS 2016", "yo", 5, 5);
        CD_Videos video3 = new CD_Videos("VACAS 2017", "yo", 20, 5);
        CD_Videos video4 = new CD_Videos("VACAS 2018", "yo", 12, 2);
        CD_Videos video5 = new CD_Videos("VACAS 2019", "yo", 30, 6);
        biblioteca.add(video1);
        biblioteca.add(video2);
        biblioteca.add(video3);
        biblioteca.add(video4);
        biblioteca.add(video5);
    }
}
