package com.company;

public abstract class Persona implements Comparable {
    protected String nombre;
    protected String apellido;
    protected double ingenio;
    protected double rapidez;

    Persona(String nombre, String apellido, double ingenio, double rapidez) throws InvalidValueException {
        compruebaYLanza(nombre);
        this.nombre = nombre;

        compruebaYLanza(apellido);
        this.apellido = apellido;

        if (ingenio<0)throw new InvalidValueException("El ingenio tiene que ser mayor que 0");
        this.ingenio = ingenio;

        if (rapidez<0)throw new InvalidValueException("La rapidez tiene que ser mayor que 0");
        this.rapidez = rapidez;
     }


     protected double getIngenio(){
        return ingenio;
     }

     protected double getRapidez(){
        return rapidez;
     }

     public abstract double getElo();

    protected StringBuffer getInfo() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Nombre: ");
        buffer.append(nombre);
        buffer.append(" | Apellido: ");
        buffer.append(apellido);
        buffer.append(" | Ingenio: ");
        buffer.append(ingenio);
        buffer.append(" | Rapidez: ");
        buffer.append(rapidez);
        buffer.append(" | Elo: ");
        buffer.append(getElo());
        return buffer;
    }

     @Override
     public int compareTo(Object o) {
        Persona persona = (Persona) o;
        if(persona.getElo()>getElo())return 1;
        else if(persona.getElo()<getElo())return -1;
        else return 0;
     }
     private void compruebaYLanza(String atributo) throws InvalidValueException {
        if (atributo == null)throw new InvalidValueException("El "+ atributo+ " no puede ser nulo.");
     }
 }
