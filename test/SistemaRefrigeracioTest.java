import org.junit.jupiter.api.Test;
import prog2.model.BombaRefrigerant;
import prog2.model.SistemaRefrigeracio;
import prog2.model.VariableUniforme;
import prog2.vista.CentralUBException;

import static org.junit.jupiter.api.Assertions.*;
import static prog2.model.Dades.VAR_UNIF_SEED;

class SistemaRefrigeracioTest {
    SistemaRefrigeracio sis = new SistemaRefrigeracio();
    VariableUniforme variableUniforme= new VariableUniforme(VAR_UNIF_SEED);
    BombaRefrigerant b0 = new BombaRefrigerant(variableUniforme, 0);
    BombaRefrigerant b1 = new BombaRefrigerant(variableUniforme, 1);
    BombaRefrigerant b2 = new BombaRefrigerant(variableUniforme, 2);
    BombaRefrigerant b3 = new BombaRefrigerant(variableUniforme, 3);
    @Test
    void afegirBomba() {
        sis.afegirBomba(b0);
        sis.afegirBomba(b1);
        sis.afegirBomba(b2);
        sis.afegirBomba(b3);

    }

    @Test
    void activa() {
        sis.afegirBomba(b0);
        sis.afegirBomba(b1);
        sis.afegirBomba(b2);
        sis.afegirBomba(b3);
        try {
            sis.activa();
            assertTrue(b0.getActivat());
            assertTrue(b1.getActivat());
            assertTrue(b2.getActivat());
            assertTrue(b3.getActivat());
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void desactiva() {
        sis.afegirBomba(b0);
        sis.afegirBomba(b1);
        sis.afegirBomba(b2);
        sis.afegirBomba(b3);
        try {
            sis.activa();
            assertTrue(b0.getActivat());
            assertTrue(b1.getActivat());
            assertTrue(b2.getActivat());
            assertTrue(b3.getActivat());
            sis.desactiva();
            assertFalse(b0.getActivat());
            assertFalse(b1.getActivat());
            assertFalse(b2.getActivat());
            assertFalse(b3.getActivat());
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getActivat() {
        sis.afegirBomba(b0);
        sis.afegirBomba(b1);
        sis.afegirBomba(b2);
        sis.afegirBomba(b3);
        assertFalse(sis.getActivat());
    }

    @Test
    void revisa() {
    }

    @Test
    void getCostOperatiu() {
        sis.afegirBomba(b0);
        sis.afegirBomba(b1);
        sis.afegirBomba(b2);
        sis.afegirBomba(b3);
        try {
            sis.activa();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(520.0F, sis.getCostOperatiu());
    }

    @Test
    void calculaOutput() {
        sis.afegirBomba(b0);
        sis.afegirBomba(b1);
        sis.afegirBomba(b2);
        sis.afegirBomba(b3);
        try {
            sis.activa();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(1.0F ,sis.calculaOutput(1.0F));

    }

    @Test
    void testToString() {
    }
}