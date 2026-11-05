package models;

import java.util.Date;

public class Vuelo {
    int dronId;
    int pilotId;
    Date fecha;
    int horas;
    String pos0;
    String pos1;

    public Vuelo(int dronId, Date fecha, int horas, String pos0, String pos1, int pilotId){
        this.dronId = dronId;
        this.fecha = fecha;
        this.horas = horas;
        this.pos0 = pos0;
        this.pos1 = pos1;
        this.pilotId = pilotId;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDronId() {
        return dronId;
    }

    public void setDronId(int dronId) {
        this.dronId = dronId;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public String getPos0() {
        return pos0;
    }

    public void setPos0(String pos0) {
        this.pos0 = pos0;
    }

    public String getPos1() {
        return pos1;
    }

    public void setPos1(String pos1) {
        this.pos1 = pos1;
    }

}
