package models;

import java.util.ArrayList;
import java.util.List;

public class Dron  {
   int id;
   String nombre;
   String fabricante;
   int modelo;
   int horas;
   boolean mant;
   List<Vuelo> vuelos;


    public Dron(int id, String nombre, String fabricante, int modelo) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.horas = 0;
        this.mant=false;
        this.vuelos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isMant() {
        return mant;
    }

    public void setMant(boolean mant) {
        this.mant = mant;
    }
    public void setVuelos(List<Vuelo> vuelos){
        this.vuelos = vuelos;
    }
    public void añadirReserva(Vuelo reserva){
        this.vuelos.add(reserva);
    }
    public static Dron buscarDronPorId(List<Dron> drones, int  dronId) {
        for (Dron dron : drones) {
            if (dron.getId()==(dronId)) {
                return dron;
            }
        }
        return null;
    }
}
