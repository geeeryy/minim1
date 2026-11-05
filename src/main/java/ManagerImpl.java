import java.util.*;

import models.Dron;

import models.Pilot;
import models.Vuelo;
import org.apache.log4j.Logger;

public class ManagerImpl implements Manager {
    private static Manager instance;
    protected List<Dron> drones;
    protected List<Pilot> pilotos;
    protected List<Vuelo> vuelos;
    protected Queue<Dron> colaMantenimiento;
    final static Logger logger = Logger.getLogger(ManagerImpl.class);

    public ManagerImpl(List<Dron> drones, List<Pilot> pilotos, List<Vuelo> vuelos) {
        this.drones = drones;
        this.pilotos = pilotos;
        this.vuelos = vuelos;
        this.colaMantenimiento=new LinkedList<>();
    }

    public ManagerImpl(){
        this.pilotos = new ArrayList<>();
        this.drones = new ArrayList<>();
        this.vuelos = new ArrayList<>();
        this.colaMantenimiento = new LinkedList<>();
    }

    public static Manager getInstance(){
        if (instance==null) instance = new ManagerImpl();
        return instance;
    }

    @Override
    public int size() {
        int a = this.drones.size();
        logger.info("Número drones = " + a);
        return a;
    }
    @Override
    public Dron addDron(int id, String nombre, String fabricante, int modelo) {
        Dron newDron = new Dron(id, nombre, fabricante, modelo);
        this.drones.add(newDron);
        logger.info("Dron añadido");
        return newDron;
    }
    @Override
    public Pilot addPiloto(int id, String nombre, String apellido){
        Pilot newPiloto = new Pilot(id, nombre, apellido);
        this.pilotos.add(newPiloto);
        logger.info("Piloto añadido");
        return newPiloto;
    }
    public List<Dron> listarDronesPorHorasDeVuelo(){
        List<Dron> dronesHoras = new ArrayList<>(this.drones);
        dronesHoras.sort((d1, d2) -> d2.getHoras() - d1.getHoras());
        logger.info("Consulta drones: " + dronesHoras);
        return dronesHoras;
    }
    public List<Pilot> listarPilotosPorHorasDeVuelo(){
        List<Pilot> pilotosHoras = new ArrayList<>(this.pilotos);
        pilotosHoras.sort((p1, p2) -> p2.getHoras() - p1.getHoras());
        logger.info("Consulta pilotos: " + pilotosHoras);
        return pilotosHoras;
    }
}
