package com.company;

public class Carry extends Persona {


    public Carry(String nombre, String apellido, double ingenio, double rapidez) throws InvalidValueException {
        super(nombre, apellido, ingenio, rapidez);
    }

    @Override
    public StringBuffer getInfo() {
        return super.getInfo();
    }

    @Override
    public double getElo() {
        return (getRapidez() * 2)+(getIngenio()*0.5);
    }


}
