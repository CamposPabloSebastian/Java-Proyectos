package patatascalientes;

import javax.swing.JMenuItem;

public class PatatasCalientes {

    public static void main(String[] args) {

        int contIntentos = 3, contIntentosPregunta = 2;
        System.out.println("PATATAS CALIENTES");
        System.out.println("Tienes 3 vidas y 1 intento mas por pregunta si fallas.");
        Preguntas jugar = new Preguntas();
        jugar.comenzarJuego();
        System.out.println("Comenzemos...");

        do {
            jugar.realizarPregunta();
            boolean resultado = jugar.ingresarRespuesta();
            if (resultado) {
                System.out.println("Correcto");
            } else {
                contIntentos--;
                contIntentosPregunta--;
                System.out.println("Incorrecto. Te quedan " + contIntentos + " vida/s." );
                while (contIntentosPregunta > 0) {
                    if (jugar.mayorMenor(contIntentos)) {
                        System.out.println("el valor es mayor al introducido");
                    } else {
                        System.out.println("el valor es menor al introducido");
                    }
                    System.out.println("Intentalo nuevamente, tienes " + contIntentosPregunta + " mas.");
                    System.out.println("Ingrese un nuevo valor");
                    resultado = jugar.ingresarRespuesta();
                    if (resultado) {
                        System.out.println("Correcto");
                        break;
                    } else {
                        System.out.println("Incorrecto.");
                        contIntentosPregunta--;
                    }
                }
                contIntentosPregunta = 2;
            }
        } while (contIntentos != 0 && jugar.hayPreguntas());
        
        jugar.resultados(contIntentos);
    }
}

/* //Esta es un 2da opcion pero sin funciones
int num1 = 50,num2 = 120, cantIntentos = 3,cantPorPreg = 2, cantidadSalientes = 0;
        
        String[] preguntas = new String[5];
        int respuesta[] = new int[5];
        boolean pregHechas[] = new boolean[preguntas.length];

        preguntas[0] = "en que año nacio pablo?";
        preguntas[1] = "cuantos años tiene pablo?";
        preguntas[2] = "en que año estamos?";
        preguntas[3] = "cuanto pago por una moto?";
        preguntas[4] = "que cilindrada puedo manejar?";

        respuesta[0] = 1991;
        respuesta[1] = 29;
        respuesta[2] = 2020;
        respuesta[3] = 3500;
        respuesta[4] = 125;

        boolean bandera = true;

        do {
            int preguntaNumero = (int) Math.floor(Math.random() * 5); //genera mi num aleatorio entre 0 y 4 incluidos
            if (pregHechas[preguntaNumero] == false) {
                cantidadSalientes++;
                System.out.println("\npreg num " + preguntaNumero);
                System.out.println(preguntas[preguntaNumero]);
                System.out.println("ingresa tu respuesta");
                Scanner lector = new Scanner(System.in);
                int eleccion = lector.nextInt();

                if (respuesta[preguntaNumero] == eleccion) {
                    System.out.println("correcto");
                    System.out.println("la respuesta es " + respuesta[preguntaNumero]);
                    pregHechas[preguntaNumero] = true;
                } else {
                    System.out.println("incorrecto");
                    cantPorPreg--;

                    while (cantPorPreg > 0 && !pregHechas[preguntaNumero]) {

                        if (respuesta[preguntaNumero] < eleccion) {
                            System.out.println("la respuesta es menor a " + eleccion);
                        } else {
                            System.out.println("la respuesta es mayor a " + eleccion);
                        }

                        System.out.println("ingresa una nueva respuesta");
                        eleccion = lector.nextInt();

                        if (respuesta[preguntaNumero] == eleccion) {
                            System.out.println("correcto");
                            System.out.println("la respuesta es " + respuesta[preguntaNumero]);
                            pregHechas[preguntaNumero] = true;
                        } else {
                            System.out.println("incorrecto");
                            System.out.println("la respuesta correcta era " + respuesta[preguntaNumero]);
                            cantPorPreg--;
                            cantIntentos--;
                        }
                    }
                    cantPorPreg = 2;
                }
                if (cantIntentos != 0 && cantidadSalientes != pregHechas.length) {
                    System.out.println("tienes aun " + cantIntentos + " intentos");
                } else {
                    bandera = false;
                }
            }

        } while (bandera);

        switch (cantIntentos) {
            case 0:
                System.out.println("PERDISTE");
                break;
            case 3:
                System.out.println("Eres un genio. Saliste invicto");
                break;
            default:
                System.out.println("ganaste con " + cantIntentos + " disponibles");
                break;
        }
 */ /*
        // Retorna un número aleatorio entre 0 (incluido) y 1 (excluido)
        System.out.println(Math.random());
        // Retorna un número aleatorio entre 0 (incluido) y 30 (excluido)
        System.out.println(Math.random()* 30);
        // Retorna un número aleatorio entre min (incluido) y max (excluido)
        System.out.println(Math.random() * (5 - 2) + 2  ); //Math.random() * (max - min) + min;
        double num = 23.473;
        System.out.println(Math.ceil(num)); //decimal (redondea hacia arriba a entero)
        System.out.println(Math.floor(num)); //decimal (redondea hacia abajo a entero)
        System.out.println(Math.round(num)); //devuleve redondea a entero hacia arriba
        System.out.println(Math.rint(num)); //decimal (redondea hacia arriba a entero)
 */
