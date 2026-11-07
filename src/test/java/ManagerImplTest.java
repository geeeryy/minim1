import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import models.Dron;
import models.Pilot;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ManagerImplTest {
    private Manager mng;
    @Before
    public void Up() throws Exception{
        mng = ManagerImpl.getInstance();

        mng.addDron(1, "Dron 1", "F1", 1);
        mng.addDron(2, "Dron 2", "F2", 2);
        mng.addDron(3, "Dron 3", "F3", 3);

        mng.addPiloto(1, "A", "aa");
        mng.addPiloto(2, "B", "bb");
        mng.addPiloto(3, "C", "cc");
    }
    @After
    public void Down(){
        this.mng = null;
    }
    @Test
    public void testAddPiloto() throws Exception {
        Pilot piloto = mng.addPiloto(4, "D", "dd");
        assertNotNull(piloto);
        assertEquals(4, piloto.getId());
        assertEquals("D", piloto.getNombre());
        assertEquals("dd", piloto.getApellido());
    }
    @Test
    public void testAddDron() throws Exception {
        assertEquals(3, mng.size());
        Dron dron = mng.addDron(4, "Dron 4", "F4", 4);
        assertNotNull(dron);
        assertEquals(4, dron.getId());
        assertEquals("Dron 4", dron.getNombre());
        assertEquals("F4", dron.getFabricante());
        assertEquals(4, dron.getModelo());
        assertEquals(4, mng.size());
    }
    @Test
    public void testGuardarDronEnAlmacen() throws Exception {
        Dron dron = mng.addDron(4, "Dron 4", "F4", 4);
        mng.guardarDronEnAlmacen(4);
        assertTrue(dron.getMant());
    }
    @Test
    public void testRepararDronEnAlmacen() throws Exception {
        Dron dron = mng.addDron(4, "Dron 4", "F4", 4);
        mng.guardarDronEnAlmacen(4);
        mng.repararDronEnAlmacen();
        assertFalse(dron.getMant());
    }
    @Test
    public void testAddPlanVuelo() throws Exception {
        Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2026");
        mng.addPlanVuelo(3,fecha,10, 0, 1000, 2);
    }
}
