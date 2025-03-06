package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> jugadores = new ArrayList<>();

        System.out.println("Ingrese el nombre de los jugadores");
        while (true) {
            System.out.println("Nombre:");
            String nombre = scanner.nextLine();
            if (nombre.isEmpty()){
                break;
            }
            jugadores.add(nombre);
        }

        if (jugadores.size() < 2) {
            System.out.println("Deben haber al menos 2 jugadores.");
        } else {
            System.out.println("Jugadores registrados: " + jugadores);
        }


        boolean finDelJuego = false;
        int turno = 0;

        while (!finDelJuego) {
            System.out.println("Turno de " + jugadores.get(turno));

            System.out.println(jugadores.get(turno) + " presiona el gatillo...");


            if (!finDelJuego) {
                turno = (turno + 1) % jugadores.size();
            }
        }

        System.out.println("Fin del juego.");
    }
}