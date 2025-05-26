/**
 * Classe BombaRefrigerant que representa una bomba de refrigeració del sistema.
 * Gestiona el seu estat, identificador i capacitat operativa.
 *
 * @author Pol i Kevin
 */
package prog2.model;

import prog2.vista.CentralUBException;

import java.io.Serializable;

public class BombaRefrigerant implements InBombaRefrigerant, Serializable {
    private int id;
    private boolean activo;
    private boolean foraServei;
    private VariableUniforme varUniforme;

    /**
     * Constructor de la classe BombaRefrigerant.
     *
     * @param var Variable per determinar el comportament de la bomba.
     * @param identificador Identificador únic de la bomba.
     */
    public BombaRefrigerant(VariableUniforme var, int identificador) {
        varUniforme = var;
        id = identificador;
        activo = false;
        foraServei = false;
    }

    /**
     * Retorna l'identificador de la bomba.
     *
     * @return Identificador de la bomba.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Activa la bomba si no està fora de servei.
     *
     * @throws CentralUBException Si la bomba està fora de servei.
     */
    @Override
    public void activa() throws CentralUBException {
        if (foraServei) {
            throw new CentralUBException("Bomba en fora servei");
        }
        activo = true;
    }

    /**
     * Desactiva la bomba.
     */
    @Override
    public void desactiva() {
        activo = false;
    }

    /**
     * Indica si la bomba està activada.
     *
     * @return True si la bomba està activada, false en cas contrari.
     */
    @Override
    public boolean getActivat() {
        return activo;
    }

    /**
     * Revisa l'estat de la bomba i comprova si ha quedat fora de servei.
     *
     * @param p Pàgina d'incidències on es registrarà l'error si la bomba falla.
     * @throws CentralUBException Si la bomba presenta una fallada.
     */
    @Override
    public void revisa(PaginaIncidencies p) throws CentralUBException {
        VariableUniforme variableUniforme = new VariableUniforme(System.currentTimeMillis());

        int valor = variableUniforme.seguentValor();
        if (valor < 25) {
            p.afegeixIncidencia("La bomba refrigerant amb ID:" + getId() + " ha quedat fora de servei.");
            foraServei = true;
            desactiva();
        } else {
            foraServei = false;
        }
    }

    /**
     * Indica si la bomba està fora de servei.
     *
     * @return True si la bomba està fora de servei, false en cas contrari.
     */
    @Override
    public boolean getForaDeServei() {
        return foraServei;
    }

    /**
     * Retorna la capacitat operativa de la bomba.
     *
     * @return Capacitat de refrigeració si està activada, 0.0 si no ho està.
     */
    @Override
    public float getCapacitat() {
        return activo ? 250.0F : 0.0F;
    }

    /**
     * Retorna el cost operatiu de la bomba.
     *
     * @return Cost operatiu si està activada, 0.0 si no ho està.
     */
    @Override
    public float getCostOperatiu() {
        return activo ? 130.0F : 0.0F;
    }

    /**
     * Retorna una representació en text de l'estat de la bomba.
     *
     * @return String amb les dades de la bomba.
     */
    @Override
    public String toString() {
        return "Id=" + id + ", Activat=" + activo + ", Fora de servei=" + foraServei;
    }
}
