import java.util.*;

import models.Dron;

import models.Pilot;
import models.Vuelo;
import org.apache.log4j.Logger;

public class ManagerImpl implements Manager {
    final static Logger logger = Logger.getLogger(ManagerImpl.class);
    private static Manager instance;
    protected List<Dron> drones;
    protected List<Pilot> pilotos;
    protected List<Vuelo> vuelos;
    protected Queue<Dron> colaMantenimiento;

    public ManagerImpl(List<Dron> drones, List<Pilot> pilotos, List<Vuelo> vuelos) {
        this.drones = drones;
        this.pilotos = pilotos;
        this.vuelos = vuelos;
        this.colaMantenimiento = new LinkedList<>();
    }

    public ManagerImpl() {
        this.pilotos = new ArrayList<>();
        this.drones = new ArrayList<>();
        this.vuelos = new ArrayList<>();
        this.colaMantenimiento = new LinkedList<>();
    }

    public static Manager getInstance() {
        if (instance == null) instance = new ManagerImpl();
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
    public Pilot addPiloto(int id, String nombre, String apellido) {
        Pilot newPiloto = new Pilot(id, nombre, apellido);
        this.pilotos.add(newPiloto);
        logger.info("Piloto añadido");
        return newPiloto;
    }

    @Override
    public List<Dron> listarDronesPorHorasDeVuelo() {
        List<Dron> dronesHoras = new ArrayList<>(this.drones);
        dronesHoras.sort((d1, d2) -> d2.getHoras() - d1.getHoras());
        logger.info("Consulta drones: " + dronesHoras);
        return dronesHoras;
    }

    @Override
    public List<Pilot> listarPilotosPorHorasDeVuelo() {
        List<Pilot> pilotosHoras = new ArrayList<>(this.pilotos);
        pilotosHoras.sort((p1, p2) -> p2.getHoras() - p1.getHoras());
        logger.info("Consulta pilotos: " + pilotosHoras);
        return pilotosHoras;
    }

    @Override
    public void guardarDronEnAlmacen(int identificadorDron) {
        for (Dron dron : this.drones) {
            if (dron.getId() == (identificadorDron)) {
                dron.setMant(true);
                this.colaMantenimiento.add(dron);
                logger.info("Nuevo dron en mantenimiento");
                break;
            }
        }
    }

    @Override
    public Dron repararDronEnAlmacen() {
        if (!this.colaMantenimiento.isEmpty()) {
            Dron dron = this.colaMantenimiento.poll();
            dron.setMant(false);
            logger.info("Realizado mantenimiento del dron");
            return dron;
        }
        return null;
    }

    public void addPlanVuelo(int idDron, Date fecha, int duracion, int pos0, int pos1, int identificadorPiloto) {
        Dron dron = null;
        Pilot piloto = null;
        for (Dron dron2 : this.drones) {
            if (dron2.getId() == idDron) {
                dron = dron2;
                break;
            }
        }
        for (Pilot piloto2 : this.pilotos) {
            if (piloto2.getId() == identificadorPiloto) {
                piloto = piloto2;
                break;
            }
        }
        if (dron == null || piloto == null) {
            logger.info("No encontrado");
            return;
        } else if (dron.getMant()) {
            logger.info("Dron en mantenimiento");
        }

        Date Fecha = new Date(fecha.getTime() + duracion * 60 * 60 * 1000L);
        for (Vuelo vuelo : this.vuelos) {
            if (vuelo.getDronId() == dron.getId() || vuelo.getPilotId() == (piloto.getId())) {
                Date Duracion2 = new Date(vuelo.getFecha().getTime() + vuelo.getHoras() * 60 * 60 * 1000L);
                if ((fecha.before(Duracion2) && Fecha.after(vuelo.getFecha()))) {
                    logger.info("Ya tiene asignado una reserva en ese tiempo");
                }
            }
        }
        Vuelo newVuelo = new Vuelo(dron.getId(), fecha, duracion, pos0, pos1, piloto.getId());
        this.vuelos.add(newVuelo);
        dron.addVuelo(newVuelo);
        piloto.addVuelo(newVuelo);
        logger.info("Nuevo vuelo registrado");
    }

    @Override
    public List<Vuelo> listarVuelosPorPiloto(int idPiloto) {
        List<Vuelo> vPiloto = new ArrayList<>();
        for (Vuelo v : this.vuelos) {
            if (v.getPilotId() == idPiloto)
                vPiloto.add(v);
        }
        return vPiloto;
    }

    @Override
    public List<Vuelo> listarVuelosPorDron(int idDron) {
        List<Vuelo> vDron = new ArrayList<>();
        for (Vuelo v : this.vuelos) {
            if (v.getDronId() == idDron)
                vDron.add(v);
        }
        return vDron;
    }
}
