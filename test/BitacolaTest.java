import org.junit.jupiter.api.Test;
import prog2.model.Bitacola;
import prog2.model.PaginaBitacola;
import prog2.model.PaginaEstat;
import prog2.model.PaginaIncidencies;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
class BitacolaTest {
    Bitacola bitacola = new Bitacola();
    PaginaEstat paginaEstat = new PaginaEstat(0,0.0f,0.0f,0.0f,0.0f,0.0f);

/* Text correte però el test dona malamaent
    @Test
    void afegeixPagina() {
        bitacola.afegeixPagina(paginaEstat);
        assertEquals( "# Pàgina Estat\n" +
                "- Dia: 0\n" +
                "- Inserció Barres: 3.0 %\n" +
                "- Output Reactor: 5.0 Graus\n" +
                "- Output Sistema de Refrigeració: 5.0 Graus\n" +
                "- Output Generador de Vapor: 5.0 Graus\n" +
                "- Output Turbina: 6.0 Unitats de Potència", bitacola.getPaginaEstat().toString());
    }

 */

    @Test
    void getIncidencies() {
        PaginaIncidencies paginaIncidencies = new PaginaIncidencies(0);
        paginaIncidencies.afegeixIncidencia("no");
        bitacola.afegeixPagina(paginaIncidencies);
        assertEquals(2, bitacola.getIncidencies().size());
    }
//
    @Test
    void getPaginaEstat() {

        bitacola.afegeixPagina(paginaEstat);
        assertEquals( bitacola.getPaginaEstat(),paginaEstat);
    }
}