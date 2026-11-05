import models.Dron;
import models.Pilot;
import models.Vuelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public interface Manager {

    int size();
    Dron addDron(int id, String nombre, String fabricante, int modelo);
    Pilot addPiloto(int id, String nombre, String apellido);
    List<Dron> listarDronesPorHorasDeVuelo();
    List<Pilot> listarPilotosPorHorasDeVuelo();
    void guardarDronEnAlmacen(String dronId);
    Dron repararDronEnAlmacen();
    void addReservaPlanVuelo(String dronId, Date fecha, int duracion, String pos0, String pos1, String pilotId);
    List<Vuelo> listarReservasPorPiloto(String pilotId);
    List<Vuelo> listarPlanesVueloPorDron(String dronId);
}
