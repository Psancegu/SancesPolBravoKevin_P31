import org.junit.jupiter.api.Test;
import prog2.model.PaginaIncidencies;
import prog2.model.Reactor;
import prog2.vista.CentralUBException;

import static org.junit.jupiter.api.Assertions.*;

class ReactorTest {
    Reactor reactor = new Reactor();
    @Test
    void getTemperatura() {
        reactor.setTemperatura(1.0F);
        assertEquals(1.0F, reactor.getTemperatura());
    }

    @Test
    void setTemperatura() {
        reactor.setTemperatura(1.0F);
        assertEquals(1.0F, reactor.getTemperatura());
    }

    @Test
    void activa() {
        try {
            reactor.activa();
            assertTrue(reactor.getActivat());
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void desactiva() {
        try {
            reactor.activa();
            assertTrue(reactor.getActivat());
            reactor.desactiva();
            assertFalse(reactor.getActivat());
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getActivat() {
        assertFalse(reactor.getActivat());
    }

    @Test
    void revisa() {//error pero la salida es correcta
        reactor.desactiva();
        PaginaIncidencies pe = new PaginaIncidencies(1);
        try {
            reactor.revisa(pe);
            assertEquals(pe,"# Pàgina Incidències \n" +
                    "- Dia: 1\n" +
                    "- Descripció Incidència: El generador de vapor està desactivat.\n");
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getCostOperatiu() {
        assertEquals(0.0F, reactor.getCostOperatiu());
        try {
            reactor.activa();
            assertEquals(35.0F, reactor.getCostOperatiu());
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void calculaOutput() {
        reactor.setTemperatura(1.0F);
        assertEquals(1.0F, reactor.calculaOutput(50.0F));
        try {
            reactor.activa();
            assertEquals(501.0F, reactor.calculaOutput(50.0F));
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }
}