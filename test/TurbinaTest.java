import org.junit.jupiter.api.Test;
import prog2.model.PaginaIncidencies;
import prog2.model.Turbina;
import prog2.vista.CentralUBException;

import static org.junit.jupiter.api.Assertions.*;

class TurbinaTest {
    Turbina turbina = new Turbina();
    @Test
    void activa() {
        turbina.desactiva();
        assertFalse(turbina.getActivat());
        try {
            turbina.activa();
            assertTrue(turbina.getActivat());
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void desactiva() {
        try {
            turbina.activa();
            turbina.desactiva();
            assertFalse(turbina.getActivat());
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getActivat() {
        assertTrue(turbina.getActivat());
    }

    @Test
    void revisa() {//da la salida esperada
        PaginaIncidencies paginaIncidencias = new PaginaIncidencies(1);
        try {
            turbina.desactiva();
            turbina.revisa(paginaIncidencias);
            assertEquals("# Pàgina Incidències \n" +
                    "- Dia: 1\n" +
                    "- Descripció Incidència: El generador de vapor està desactivat durant la revisió.\n",paginaIncidencias);
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getCostOperatiu() {
        assertEquals(20.0F, turbina.getCostOperatiu());
        turbina.desactiva();
        assertEquals(0.0F, turbina.getCostOperatiu());
    }

    @Test
    void calculaOutput() {
        assertEquals(0.0F,turbina.calculaOutput(50.0F));
        assertEquals(300.0F,turbina.calculaOutput(150.0F));
    }
}