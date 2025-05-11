import org.junit.jupiter.api.Test;
import prog2.model.*;
import prog2.vista.CentralUBException;

import static org.junit.jupiter.api.Assertions.*;
import static prog2.model.Dades.GUANYS_INICIALS;
import static prog2.model.Dades.VAR_UNIF_SEED;

class DadesTest {
    Dades dades;

    {
        try {
            dades = new Dades();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getInsercioBarres() {
        assertEquals(100,dades.getInsercioBarres());
    }

    @Test
    void setInsercioBarres() {
        try {
            dades.setInsercioBarres(50);
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(50,dades.getInsercioBarres());
    }

    @Test
    void activaReactor() {
        Reactor reactor = this.dades.mostraReactor();
        try {
            dades.activaReactor();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(reactor.getActivat(),true);
    }

    @Test
    void desactivaReactor() {
        Reactor reactor = this.dades.mostraReactor();
        try {
            dades.activaReactor();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(reactor.getActivat(),true);
        dades.desactivaReactor();
        assertEquals(reactor.getActivat(),false);
    }

    @Test
    void mostraReactor() {
        Reactor reactor = this.dades.mostraReactor();
        assertEquals(reactor,this.dades.mostraReactor());
    }

    @Test
    void activaBomba() {
        VariableUniforme variableUniforme= new VariableUniforme(VAR_UNIF_SEED);
        BombaRefrigerant b = new BombaRefrigerant(variableUniforme,5);
        try {
            SistemaRefrigeracio sis = dades.mostraSistemaRefrigeracio();
            sis.afegirBomba(b);
            dades.activaBomba(5);
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(b.getActivat(),true);
    }

    @Test
    void desactivaBomba() {
        VariableUniforme variableUniforme= new VariableUniforme(VAR_UNIF_SEED);
        BombaRefrigerant b = new BombaRefrigerant(variableUniforme,5);
        try {
            SistemaRefrigeracio sis = dades.mostraSistemaRefrigeracio();
            sis.afegirBomba(b);
            dades.activaBomba(5);
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(b.getActivat(),true);
        dades.desactivaBomba(5);
        assertEquals(b.getActivat(),false);
    }

    @Test
    void activarTotesBombes() {
        try {
            dades.activarTotesBombes();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        SistemaRefrigeracio sis = dades.mostraSistemaRefrigeracio();
        assertEquals(sis.getActivat(),true);
    }

    @Test
    void desactivarTotesBombes() {
        try {
            dades.activarTotesBombes();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        SistemaRefrigeracio sis = dades.mostraSistemaRefrigeracio();
        try {
            dades.desactivarTotesBombes();
        } catch (CentralUBException e) {
            throw new RuntimeException(e);
        }
        assertEquals(sis.getActivat(),false);
    }

    @Test
    void mostraSistemaRefrigeracio() {
        SistemaRefrigeracio sis = dades.mostraSistemaRefrigeracio();
        assertEquals(sis,this.dades.mostraSistemaRefrigeracio());
    }

    @Test
    void calculaPotencia() {

        assertEquals(0,dades.calculaPotencia());
    }

    @Test
    void getGuanysAcumulats() {
        assertEquals(dades.getGuanysAcumulats(),GUANYS_INICIALS);
    }

    @Test
    void mostraEstat() {
    }

    @Test
    void mostraBitacola() {
    }

    @Test
    void mostraIncidencies() {
    }

    @Test
    void getPercDemanda() {
    }

    @Test
    void finalitzaDia() {
    }
}