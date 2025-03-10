package org.example;

import java.util.ArrayList;
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

    public Ruleta(ArrayList<String> jugadores) {
        this.tambor = jugadores;
        this.random = new Random();
        this.posicionTamborActual = 0;
        this.posicionBalaActual = random.nextInt(jugadores.size());
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

    public boolean disparar() {
        boolean acertado = (posicionTamborActual == posicionBalaActual);


        posicionTamborActual = (posicionTamborActual + 1) % tambor.size();

        if (acertado) {
            nuevoAleatorio();
        }

        return acertado;
    }

    private void nuevoAleatorio() {
        posicionBalaActual = random.nextInt(tambor.size());
    }


    public void mostrarEstado() {
        System.out.println("Estado actual");
        System.out.println("Jugador en turno: " + tambor.get(posicionTamborActual));
        System.out.println("Posición del tambor: " + posicionTamborActual);
        System.out.println("Posición de la bala: " + posicionBalaActual);
    }

    }


