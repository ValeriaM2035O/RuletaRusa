package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta {

    private ArrayList<String> tambor;
    private int posicionBalaActual;
    private int posicionTamborActual;
    private Random random;

    public Ruleta() {
    }

    public Ruleta(ArrayList<String> tambor, int posicionBalaActual, int posicionTamborActual, Random random) {
        this.tambor = tambor;
        this.posicionBalaActual = posicionBalaActual;
        this.posicionTamborActual = posicionTamborActual;
        this.random = random;
    }

    public ArrayList<String> getTambor() {
        return tambor;
    }

    public void setTambor(ArrayList<String> tambor) {
        this.tambor = tambor;
    }

    public int getPosicionBalaActual() {
        return posicionBalaActual;
    }

    public void setPosicionBalaActual(int posicionBalaActual) {
        this.posicionBalaActual = posicionBalaActual;
    }

    public int getPosicionTamborActual() {
        return posicionTamborActual;
    }

    public void setPosicionTamborActual(int posicionTamborActual) {
        this.posicionTamborActual = posicionTamborActual;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "Ruleta{" +
                "tambor=" + tambor +
                ", posicionBalaActual=" + posicionBalaActual +
                ", posicionTamborActual=" + posicionTamborActual +
                ", random=" + random +
                '}';
    }

    public boolean disparar(ArrayList<String> tambor, int posicionBalaActual, int posicionTamborActual, Random random, int turno) {

        if (posicionBalaActual == posicionTamborActual) {
            System.out.println("Jugador muerto" + tambor.get(posicionTamborActual));
            tambor.remove(posicionTamborActual);

            if (!tambor.isEmpty()) {
                posicionBalaActual = random.nextInt(tambor.size());
                System.out.println("Nueva posición de la bala: " + posicionBalaActual);
                cambiarTurno();
                return true;
            } else {
                System.out.println("No hay jugadores en el tambor.");
                return false;
            }
        } else {
            System.out.println("Pasa el arma al siguiente.");
            cambiarTurno();
            return false;
        }
    }

    private void cambiarTurno() {
        if (!tambor.isEmpty()) {
            posicionTamborActual = (posicionTamborActual + 1) % tambor.size();
            System.out.println("Turno del jugador: " + tambor.get(posicionTamborActual));
        } else {
            System.out.println("No hay más jugadores.");
        }

    }

}

