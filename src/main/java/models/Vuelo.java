package models;

import java.util.Date;

public class Vuelo {
    int dronId;
    int pilotId;
    Date fecha;
    int horas;
    int pos0;
    int pos1;

    public Vuelo(int dronId, Date fecha, int horas, int pos0, int pos1, int pilotId){
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

    public int getPos0() {
        return pos0;
    }

    public void setPos0(int pos0) {
        this.pos0 = pos0;
    }

    public int getPos1() {
        return pos1;
    }

    public void setPos1(int pos1) {
        this.pos1 = pos1;
    }

}
