package prog2.model;

import prog2.vista.CentralUBException;

import java.io.Serializable;

/**
 * Classe GeneradorVapor que representa el generador de vapor dins la central.
 * Controla el seu estat, el cost operatiu i el processament de l'entrada.
 *
 * @author Pol i Kevin
 */
public class GeneradorVapor implements InComponent, Serializable {
    private boolean activa;

    /**
     * Constructor de la classe GeneradorVapor.
     * Inicialitza el generador com activat per defecte.
     */
    public GeneradorVapor() {
        activa = true;
    }

    /**
     * Activa el generador de vapor.
     */
    @Override
    public void activa() {
        activa = true;
    }

    /**
     * Desactiva el generador de vapor.
     */
    @Override
    public void desactiva() {
        activa = false;
    }

    /**
     * Retorna si el generador de vapor està activat.
     *
     * @return True si el generador està activat, false en cas contrari.
     */
    @Override
    public boolean getActivat() {
        return activa;
    }

    /**
     * Revisa l'estat del generador de vapor i registra una incidència si està desactivat.
     *
     * @param p Pàgina d'incidències on s'afegirà la incidència si el generador està desactivat.
     * @throws CentralUBException Si es detecta una anomalia.
     */
    @Override
    public void revisa(PaginaIncidencies p) throws CentralUBException {
        if (!activa) {
            p.afegeixIncidencia("El generador de vapor està desactivat.");
        }
    }

    /**
     * Retorna el cost operatiu del generador de vapor.
     *
     * @return Cost operatiu si està activat, 0.0 si està desactivat.
     */
    @Override
    public float getCostOperatiu() {
        return activa ? 25.0F : 0.0F;
    }

    /**
     * Calcula la sortida del generador de vapor en funció de l'entrada.
     *
     * @param input Valor d'entrada al generador.
     * @return Valor de sortida, aplicant la conversió segons l'estat del generador.
     */
    @Override
    public float calculaOutput(float input) {
        return activa ? input * 0.9F : 25.0F;
    }
}
