import org.junit.jupiter.api.Test;
import prog2.model.BombaRefrigerant;
import prog2.model.VariableUniforme;
import prog2.vista.CentralUBException;

import static org.junit.jupiter.api.Assertions.*;
import static prog2.model.Dades.VAR_UNIF_SEED;

class BombaRefrigerantTest {
    VariableUniforme variableUniforme= new VariableUniforme(VAR_UNIF_SEED);
    BombaRefrigerant b = new BombaRefrigerant(variableUniforme,1);
    @Test
    void getId() {
        assertEquals(1,b.getId());
    }

    @Test
    void activa() {
        try {
            b.activa();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(true,b.getActivat());
    }

    @Test
    void desactiva() {
        try {
            b.activa();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        b.desactiva();
        assertEquals(false,b.getActivat());
    }

    @Test
    void getActivat() {
        assertEquals(false,b.getActivat());
    }

    @Test
    void revisa() {
    }

    @Test
    void getForaDeServei() {
        assertFalse(b.getForaDeServei());
    }

    @Test
    void getCapacitat() {

        assertEquals(0.0F,b.getCapacitat());
        try {
            b.activa();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(250.0F,b.getCapacitat());
    }

    @Test
    void getCostOperatiu() {
        assertEquals(0.0F,b.getCostOperatiu());
        try {
            b.activa();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(130.0F,b.getCostOperatiu());
    }

    @Test
    void testToString() {
        assertEquals("Id=1, Activat=false, Fora de servei=false", b.toString());
    }
}
