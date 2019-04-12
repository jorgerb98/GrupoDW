package com.company;

import java.util.TreeSet;

public class Gestor{

    private TreeSet<Equipo> listaEquipos;
    private TreeSet<Persona> listaParticipantes;
    private TreeSet<String> nombres =new TreeSet<>();

    public Gestor(TreeSet<Equipo> listaEquipos) throws InvalidValueException {
        if (listaEquipos==null)throw new InvalidValueException("La lista de equipos no puede ser null");
        if (listaEquipos.size()!=20){
            throw new InvalidValueException("Tiene que haber 20 equipos.");
        }else this.listaEquipos = listaEquipos;
        this.listaParticipantes = new TreeSet<>();
        for (Equipo item: listaEquipos){
            listaParticipantes.addAll(item.getListaMiembros());
        }
    }

    public Gestor() throws InvalidValueException {
        listaEquipos = new TreeSet<>();
        this.listaParticipantes = new TreeSet<>();
        nombres.add("Lobos");
        nombres.add("Impalas");
        nombres.add("Águilas");
        nombres.add("Hienas");
        nombres.add("Llamas");
        nombres.add("Camellos");
        nombres.add("Ardillas");
        nombres.add("Gorilas");
        nombres.add("Osos");
        nombres.add("Linces");
        nombres.add("Toros");
        nombres.add("Jaguares");
        nombres.add("Rinocerontes");
        nombres.add("Jirafas");
        nombres.add("Cobras");
        nombres.add("Tiburones");
        nombres.add("Leones");
        nombres.add("Babuinos");
        nombres.add("Canguros");
        nombres.add("Tigres");
        generarlistaMiembrosAutomatico();
    }


    private Equipo getEquipo() throws InvalidValueException {

        String nombre = nombres.first();

        Equipo x = new Equipo(nombre);

        if (listaEquipos.contains(x)) {
            getEquipo();
        } else {
            nombres.remove(nombre);
            listaEquipos.add(x);
            listaParticipantes.addAll(x.getListaMiembros());
            return x;
        }
        return null;
    }

    private void generarlistaMiembrosAutomatico() throws InvalidValueException {
        while (listaEquipos.size() != 20) {
            if (getEquipo()==null)throw new InvalidValueException("El equipo introducido es nulo");
            else getEquipo();
        }
    }




    public StringBuffer getMejoresEquipos(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("Lista de los 5 mejores equipos:\n");
            int i =1;
            for (Equipo item: listaEquipos){
                buffer.append("Posición ").append(i).append(": ");
                buffer.append("Equipo: ");
                buffer.append(item.getNombre());
                buffer.append(" | Con el nivel de habilidad: ");
                buffer.append(item.getEloTotal());
                buffer.append("\n");
                i++;
                if (i==6){
                    return buffer;
                }

        }
        return buffer;
    }

    public StringBuffer getMejoresJugadores(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("Lista de los 5 mejores Jugadores:\n");
        int i =1;
            for (Persona item: listaParticipantes){
                buffer.append("Posición ").append(i).append(": ");
                i++;
                buffer.append(item.getInfo());
                buffer.append("\n");
                if (i==6){
                    return buffer;
                }

            }


        return buffer;
    }

    public StringBuffer getEmparejamientos (){
        StringBuffer buffer = new StringBuffer();
        int aux = 1;
        int aux2 = 1;
        buffer.append("-EMPAREJAMIENTOS-\n");
        for(Equipo item : listaEquipos){
            if (aux%2==0){
                buffer.append(" vs ");
                buffer.append(item.getNombre()).append("(").append((int) item.getEloTotal()).append(")");
                buffer.append("\n");
                aux ++;
            }else {
                buffer.append("Emparejamiento numero ").append(aux2).append(": ");
                buffer.append(item.getNombre()).append("(").append((int) item.getEloTotal()).append(")");
                aux2++;
                aux ++;

            }

        }
        return buffer;
    }


}
