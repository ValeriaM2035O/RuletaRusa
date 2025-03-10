package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> jugadores = new ArrayList<>();

        System.out.println("Ingrese el nombre de los jugadores (MINIMO 2)");
        while (true) {
            System.out.println("Nombre:");
            String nombre = scanner.nextLine();
            if (nombre.isEmpty()){
                break;
            }
            jugadores.add(nombre);
        }

        if (jugadores.size() < 2) {
            System.out.println("Deben haber al menos 2 jugadores.") ;
        } else {
            System.out.println("Jugadores registrados: " + jugadores);
        }


        Ruleta juego = new Ruleta(jugadores);

        while (true) {
            juego.mostrarEstado();

            System.out.println("\n¿Quieres disparar? (s/n)");
            String accion = scanner.nextLine().toLowerCase();

            if (accion.equals("n")) break;

            String jugadorActual = juego.getTambor().get(juego.getPosicionTamborActual());

            if (juego.disparar()) {
                System.out.println("¡PUM! " + jugadorActual + " ha muerto");
                break;
            } else {

                System.out.println("¡QUE SUERTE! " + jugadorActual + " sobrevive");
            }
        }
            }
    }
