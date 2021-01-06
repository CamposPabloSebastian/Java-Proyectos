/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patatascalientes;

import java.util.Scanner;

/**
 *
 * @author pscam
 */
public class Preguntas {

    private int preguntActual;
    private String[] preguntas = new String[5];
    private int respuesta[] = new int[preguntas.length];
    private boolean pregHechas[] = new boolean[preguntas.length];

    public void comenzarJuego() {
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
    }

    private int buscarIndiceFalse() {

        boolean estado = true;
        while (estado) {
            preguntActual = (int) Math.floor(Math.random() * 5); //genera mi num aleatorio entre 0 y 4 incluidos
            if (pregHechas[preguntActual] == false) {
                pregHechas[preguntActual] = true;
                estado = false;
            }
        }
        return preguntActual;
    }

    public boolean preguntaRealizada() {
        return pregHechas[preguntActual];
    }

    public void realizarPregunta() {
        if (comprobarPregSinRealizar()) {
            System.out.println(preguntas[buscarIndiceFalse()]);
        } else {
            System.out.println("NO HAY MAS PREGUNTAS");
        }
    }

    public boolean ingresarRespuesta() {
        Scanner leerDato = new Scanner(System.in);
        int dato = leerDato.nextInt();
        return resultadoRespuesta(dato);
    }

    private boolean resultadoRespuesta(int valor) {
        return (valor == respuesta[preguntActual]);
    }

    public boolean mayorMenor(int valor) {
        return respuesta[preguntActual] > valor;
    }

    private boolean comprobarPregSinRealizar() {
        int contiene = 0;
        for (int i = 0; i < pregHechas.length; i++) {
            if (pregHechas[i] == false) {
                contiene++;
            }
        }
        return contiene > 0;
    }

    public boolean hayPreguntas() {
        int contiene = 0;
        for (int i = 0; i < pregHechas.length; i++) {
            if (pregHechas[i] == false) {
                contiene++;
                break;
            }
        }
        return contiene > 0;
    }

    public void resultados(int intentos) {
        System.out.println("Juego terminado");
        if (intentos == 0) {
            System.out.println("PERDISTE");
        } else {
            System.out.println("G A N A S T E . . . ! ! !");
            if (intentos == 3) {
                System.out.println("Saliste invicto");
            } else {
                System.out.println("Te quedaron " + intentos + " vidas");
            }
        }
    }

}
