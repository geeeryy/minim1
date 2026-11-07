package models;
import java.util.ArrayList;
import java.util.List;

public class Pilot {
    int id;
    String nombre;
    String apellido;
    int horas;
    List<Vuelo> vuelos;

    public Pilot(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.horas = 0;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    public static Pilot buscarPilotoPorId(List<Pilot> pilotos, int  pilotoId){
        for(Pilot piloto : pilotos){
            if(piloto.getId()==pilotoId) {
                return piloto;
            }
        }
        return null;
    }
    public void setVuelos(List<Vuelo> vuelos){
        this.vuelos = vuelos;
    }
    public void addVuelo(Vuelo vuelo){
        this.vuelos.add(vuelo);
    }
}
