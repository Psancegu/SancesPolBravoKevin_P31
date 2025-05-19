/**
 * Classe Bitacola que gestiona un registre de les diferents pàgines d'informació.
 * Permet afegir i recuperar dades sobre l'estat, incidències i economia del sistema.
 *
 * @author Pol i Kevin
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bitacola implements InBitacola, Serializable {
    private ArrayList<PaginaBitacola> paginesBitacola;

    /**
     * Constructor de la classe Bitacola.
     * Inicialitza la bitàcola amb les primeres pàgines per defecte.
     */
    public Bitacola() {
        this.paginesBitacola = new ArrayList<>();
    }

    /**
     * Afegeix una pàgina a la bitàcola.
     *
     * @param p Pàgina a afegir.
     */
    @Override
    public void afegeixPagina(PaginaBitacola p) {
        paginesBitacola.add(p);
    }

    /**
     * Obté la llista de pàgines d'incidències registrades.
     *
     * @return Llista de pàgines d'incidències.
     */
    @Override
    public List<PaginaIncidencies> getIncidencies() {
        List<PaginaIncidencies> aux = new ArrayList<>();

        Iterator<PaginaBitacola> it = paginesBitacola.iterator();
        while (it.hasNext()) {
            PaginaBitacola p = it.next();
            if (p instanceof PaginaIncidencies) {
                aux.add((PaginaIncidencies) p);
            }
        }
        return aux;
    }

    /**
     * Obté la pàgina d'estat més recent.
     *
     * @return Pàgina d'estat actual.
     */
    public PaginaEstat getPaginaEstat() {
        Iterator<PaginaBitacola> it = paginesBitacola.iterator();
        PaginaEstat retornar = null;
        PaginaBitacola aux = it.next();
        while (it.hasNext()) {
            if (aux instanceof PaginaEstat) {
                retornar = (PaginaEstat) aux;
            }
            it.next();
        }
        return retornar;
    }

    /**
     * Genera una representació en text de la bitàcola.
     *
     * @return Cadena amb el contingut de la bitàcola.
     */
    public String generateToString() {
        StringBuilder aux = new StringBuilder();
        Iterator<PaginaBitacola> it = paginesBitacola.iterator();
        while (it.hasNext()) {
            PaginaBitacola p = it.next();
            aux.append(p.toString()).append("\n\n");
        }
        return aux.toString();
    }

    /**
     * Retorna la representació en text de la bitàcola.
     *
     * @return Cadena amb la informació de la bitàcola.
     */
    @Override
    public String toString() {
        return generateToString();
    }
}
