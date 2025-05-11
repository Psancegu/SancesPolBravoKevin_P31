import org.junit.jupiter.api.Test;
import prog2.model.GeneradorVapor;
import prog2.model.PaginaIncidencies;
import prog2.vista.CentralUBException;

import static org.junit.jupiter.api.Assertions.*;

class GeneradorVaporTest {
    GeneradorVapor ge = new GeneradorVapor();
    @Test
    void activa() {
        ge.activa();
        ge.activa();
        assertTrue(ge.getActivat());
    }

    @Test
    void desactiva() {
        ge.desactiva();
        assertFalse(ge.getActivat());
    }

    @Test
    void getActivat() {
        assertTrue(ge.getActivat());
    }

    @Test
    void revisa() { //da la salida esperada pero da error
        ge.desactiva();
        PaginaIncidencies pe = new PaginaIncidencies(1);
        try {
            ge.revisa(pe);
            assertEquals(pe,"# Pàgina Incidències \n" +
                    "- Dia: 1\n" +
                    "- Descripció Incidència: El generador de vapor està desactivat.\n");
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getCostOperatiu() {
        assertEquals(25.0F, ge.getCostOperatiu());
        ge.desactiva();
        assertEquals(0.0F, ge.getCostOperatiu());
    }

    @Test
    void calculaOutput() {

        assertEquals(0.9F,ge.calculaOutput(1.0F));
        ge.desactiva();
        assertEquals(25.0F,ge.calculaOutput(1.0F));
    }
}