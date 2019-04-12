package com.company;

import java.util.TreeSet;

public class Equipo implements Comparable {

    private String nombre;
    private TreeSet<Persona> listaMiembros = new TreeSet<>();
    private double eloTotal;

    public Equipo(String nombre) throws InvalidValueException {
        compruebaYLanza(nombre);
        this.nombre = nombre;
        this.listaMiembros = getListaMiembrosInicial();
        if (eloTotal<0)throw new InvalidValueException("El ingenio tiene que ser mayor que 0");
        this.eloTotal = getEloTotal();
    }

    public Equipo(String nombre, TreeSet<Persona> listaMiembros) throws InvalidValueException {
        if (nombre == null) throw new InvalidValueException("El nombre no puede ser nulo.");
        this.nombre = nombre;
        compruebaYLanza(listaMiembros);
        if (listaMiembros.size() != 5) {
            throw new InvalidValueException("La lista de miembros tiene que ser compuesta por 5 personas.");
        } else this.listaMiembros = listaMiembros;

    }


    public String getNombre() {
        return nombre;

    }

    private String getNombrePersona() {
        String[] nombres = {"Andrea", "David", "Baldomero", "Enriqueta", "Kaori", "Asami", "Barry", "Bort",
                "Bartolomé", "Max", "Batu", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Mariana",
                "Caritina", "Carlota", "Sandra"};
        return nombres[(int) (Math.random() * nombres.length)];
    }

    private String getApellidoPersona() {
        String[] apellidos = {"Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
                "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
                "Grigalva"};
        return apellidos[(int) (Math.random() * apellidos.length)];
    }

    private TreeSet<Persona> getListaMiembrosInicial() throws InvalidValueException {
        for (int i = 0; i < 5; i++) {
            if ((int) (Math.random() * 100) % 2 == 0) {
                listaMiembros.add(new Carry(getNombrePersona(), getApellidoPersona(), getRandomWithRangePersona(), getRandomWithRangePersona()));
            } else
                listaMiembros.add(new Coach(getNombrePersona(), getApellidoPersona(), getRandomWithRangePersona(), getRandomWithRangePersona()));

        }
        return listaMiembros;
    }

    private double getRandomWithRangePersona() {
        double range = (100 - 1);
        return (Math.random() * range) + 1;
    }

    public double getEloTotal() {
        eloTotal = 0;
        for (Persona item : listaMiembros) {
            eloTotal += item.getElo();
        }
        return eloTotal;
    }


    public TreeSet<Persona> getListaMiembros() {
        return listaMiembros;
    }


    @Override
    public int compareTo(Object o) {
        Equipo equipo = (Equipo) o;
        return Double.compare(equipo.getEloTotal(), getEloTotal());
    }

    private void compruebaYLanza(Object atributo) throws InvalidValueException {
        if (atributo == null) throw new InvalidValueException("El " + atributo + " no puede ser nulo.");
    }
}
