package prog2.model;

import prog2.vista.CentralUBException;

import java.io.Serializable;

/**
 * Classe Reactor que representa el reactor nuclear de la central.
 * Gestiona el seu estat, la temperatura i els càlculs de potència.
 *
 * @author Pol i Kevin
 */
public class Reactor implements InComponent, Serializable {
    private boolean active;
    private float temperatura;

    /**
     * Constructor de la classe Reactor.
     * Inicialitza el reactor com a desactivat per defecte.
     */
    public Reactor() {
        active = false;
    }

    /**
     * Retorna la temperatura actual del reactor.
     *
     * @return Temperatura del reactor.
     */
    public float getTemperatura() {
        return temperatura;
    }

    /**
     * Estableix una nova temperatura per al reactor.
     *
     * @param temperatura Nova temperatura del reactor.
     */
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Activa el reactor si la temperatura és segura.
     *
     * @throws CentralUBException Si la temperatura supera els 1000.0 graus.
     */
    @Override
    public void activa() throws CentralUBException {
        if (temperatura >= 1000.0F) {
            throw new CentralUBException("No es pot activar: Temperatura > 1000.0");
        } else {
            active = true;
        }
    }

    /**
     * Desactiva el reactor.
     */
    @Override
    public void desactiva() {
        active = false;
    }

    /**
     * Retorna si el reactor està activat.
     *
     * @return True si el reactor està activat, false en cas contrari.
     */
    @Override
    public boolean getActivat() {
        return active;
    }

    /**
     * Revisa l'estat del reactor i registra incidències si cal.
     *
     * @param p Pàgina d'incidències on s'afegirà la incidència si el reactor està desactivat o supera la temperatura màxima.
     * @throws CentralUBException Si es detecta una anomalia.
     */
    @Override
    public void revisa(PaginaIncidencies p) throws CentralUBException {
        if (temperatura >= 1000.0F && active) {
                desactiva();
                p.afegeixIncidencia("El reactor està desactivat perquè supera la temperatura màxima");
                throw new CentralUBException("El reactor està desactivat perquè supera la temperatura màxima");
        }
        else{
            return;
        }
    }

    /**
     * Retorna el cost operatiu del reactor.
     *
     * @return Cost operatiu si està activat, 0.0 si està desactivat.
     */
    @Override
    public float getCostOperatiu() {
        if (!active) {
            return 0.0F;
        } else {
            return 35.0F;
        }
    }

    /**
     * Calcula la potència de sortida en funció de la temperatura i la inserció de barres.
     *
     * @param input Percentatge d'inserció de barres.
     * @return Valor de sortida de potència del reactor.
     */
    public float calculaOutput(float input) {
        if (!active) {
            return 0.0F;
        } else {
            return (100.0F - input) * 10.0F;
        }
    }


    /**
     * Retorna una representació en text de l'estat del reactor.
     *
     * @return Cadena amb la temperatura i el seu estat d'activació.
     */
    @Override
    public String toString() {
        return "Temperatura Reactor: " + getTemperatura() + ", Activa: " + getActivat();
    }
}
