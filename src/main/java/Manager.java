import models.Dron;
import models.Pilot;
import models.Vuelo;

import java.util.List;
import java.util.Date;

public interface Manager {

    int size();
    Dron addDron(int id, String nombre, String fabricante, int modelo);
    Pilot addPiloto(int id, String nombre, String apellido);
    List<Dron> listarDronesPorHorasDeVuelo();
    List<Pilot> listarPilotosPorHorasDeVuelo();
    void guardarDronEnAlmacen(int dronId);
    Dron repararDronEnAlmacen();
    void addPlanVuelo(int dronId, Date fecha, int duracion, int pos0, int pos1, int pilotId);
    List<Vuelo> listarVuelosPorPiloto(int pilotId);
    List<Vuelo> listarVuelosPorDron(int dronId);
}
