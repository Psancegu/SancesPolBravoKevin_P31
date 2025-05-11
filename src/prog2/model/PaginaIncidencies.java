package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe PaginaIncidencies que representa una pàgina dins la bitàcola de la central.
 * Guarda el registre de les incidències detectades durant el funcionament.
 *
 * @author Pol i Kevin
 */
public class PaginaIncidencies extends PaginaBitacola implements Serializable {
    private ArrayList<String> incidencies;

    /**
     * Constructor de la classe PaginaIncidencies.
     *
     * @param dia Dia en què es registra la informació d'incidències.
     */
    public PaginaIncidencies(int dia) {
        super(dia);
        incidencies = new ArrayList<>();
    }

    /**
     * Afegeix una nova incidència a la pàgina.
     *
     * @param descIncidencia Descripció de la incidència registrada.
     */
    public void afegeixIncidencia(String descIncidencia) {
        incidencies.add(descIncidencia);
    }

    /**
     * Retorna una llista de les incidències registrades.
     *
     * @return Cadena amb les incidències registrades o un missatge indicant que no n'hi ha cap.
     */
    public String getIncidencies() {
        if (incidencies.isEmpty()) {
            return "- No hi ha cap incidència";
        }

        StringBuilder total = new StringBuilder();
        Iterator<String> it = incidencies.iterator();
        while (it.hasNext()) {
            String aux = it.next();
            total.append("- Descripció Incidència: ").append(aux).append("\n");
        }
        return total.toString();
    }

    /**
     * Retorna una representació en text de la pàgina d'incidències.
     *
     * @return Cadena amb la informació de les incidències registrades.
     */
    @Override
    public String toString() {
        return "# Pàgina Incidències \n" + "- Dia: " + getDia() + "\n" + getIncidencies();
    }
}
