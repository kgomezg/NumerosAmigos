/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosamigos;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kevin Camilo Gómez González - kgomezg81832@universidadean.edu.co
 * @date 2020.08.10
 * @desc
 */
public class Operador {

    private static final int LIMITEINT = Integer.MAX_VALUE;
    private static int LIMITEUSUARIO = 0, contadorAmigos = 0;
    private List<Integer> numerosA = new ArrayList<Integer>();
    private Scanner _entrada = new Scanner(System.in);

    public void Operador() {
        limpiar();
    }

    public void _start() {

        imprimir("Escriba la cantidad de números amigos que quiere listar.");
        LIMITEUSUARIO = _entrada.nextInt();

        _procesar();
    }

    public void _procesar() {

        imprimir("");
        imprimir("Decidio imprimir los " + LIMITEUSUARIO + " números amigos.");
        imprimir("Se procesara la información, puede ser que se demore en imprimir los valores mientras realiza el proceso.");

        for (int i = 0; i < LIMITEINT; i++) {

            int numeroA = 0, numeroB = 0;

            for (int divisorA = 0; divisorA < i; divisorA++) {
                if (divisorA > 0) {
                    if (i % divisorA == 0) {
                        numeroB += divisorA;
                    }
                }
            }

            for (int divisorB = 0; divisorB < numeroB; divisorB++) {
                if (divisorB > 0) {
                    if (numeroB % divisorB == 0) {
                        numeroA += divisorB;
                    }
                }
            }

            if (contadorAmigos < LIMITEUSUARIO) {
                if (numeroA == numeroB) {
                } else if (numeroA == i && !(numerosA.contains(numeroA) || numerosA.contains(numeroB))) {
                    contadorAmigos++;
                    imprimir("Par " + contadorAmigos + " | A: " + numeroA + " | B : " + numeroB);
                    numerosA.add(numeroA);
                }
            } else {
                System.exit(0);
            }
        }
    }

    public static void imprimir(String mensaje) {
        System.out.println(mensaje + "\r");
    }

    public static void limpiar() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        } catch (AWTException e) {
            imprimir(e.getMessage());
        }
    }

}
