package com.company;

public class Coach extends Persona{


    public Coach(String nombre, String apellido, double ingenio, double rapidez) throws InvalidValueException {
        super(nombre, apellido, ingenio, rapidez);
    }



    @Override
    public StringBuffer getInfo() {
        return super.getInfo();
    }

    @Override
    public double getElo() {
        return (getRapidez() * 0.2)+(getIngenio()*3);

    }
}
