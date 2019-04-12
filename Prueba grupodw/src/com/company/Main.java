package com.company;




public class Main {

    public static void main(String[] args) throws InvalidValueException {

        Gestor gestor = new Gestor();
        System.out.println(gestor.getMejoresEquipos());
        System.out.println(gestor.getMejoresJugadores());
        System.out.println(gestor.getEmparejamientos());

    }
}
