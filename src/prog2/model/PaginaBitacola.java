package prog2.model;

import java.io.Serializable;

/**
 * Classe PaginaBitacola que representa una pàgina dins la bitàcola de la central.
 * Conté la informació del dia en què s'ha registrat.
 *
 * @author Pol i Kevin
 */
public class PaginaBitacola implements Serializable {
    private int dia;

    /**
     * Constructor per defecte de la classe PaginaBitacola.
     * Inicialitza el dia a 0.
     */
    public PaginaBitacola() {
        this.dia = 0;
    }

    /**
     * Constructor que permet establir el dia de la pàgina de bitàcola.
     *
     * @param dia Dia associat a la pàgina de bitàcola.
     */
    public PaginaBitacola(int dia) {
        this.dia = dia;
    }

    /**
     * Retorna el dia associat a la pàgina de bitàcola.
     *
     * @return Dia registrat en la pàgina.
     */
    public int getDia() {
        return dia;
    }
}
