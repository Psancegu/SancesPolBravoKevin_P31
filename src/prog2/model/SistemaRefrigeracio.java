package prog2.model;

import prog2.vista.CentralUBException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe SistemaRefrigeracio que representa el sistema de refrigeració de la central.
 * Gestiona les bombes refrigerants i el control de la refrigeració del reactor.
 *
 * @author Pol i Kevin
 */
public class SistemaRefrigeracio implements InComponent, Serializable {
    ArrayList<BombaRefrigerant> bombaRefrigerants;

    /**
     * Constructor de la classe SistemaRefrigeracio.
     * Inicialitza la llista de bombes refrigerants.
     */
    public SistemaRefrigeracio() {
        this.bombaRefrigerants = new ArrayList<>();
    }

    /**
     * Afegeix una nova bomba refrigerant al sistema.
     *
     * @param b Bomba refrigerant a afegir.
     */
    public void afegirBomba(BombaRefrigerant b) {
        bombaRefrigerants.add(b);
    }

    /**
     * Activa totes les bombes refrigerants del sistema.
     *
     * @throws CentralUBException Si hi ha un error en l'activació d'alguna bomba.
     */
    @Override
    public void activa() throws CentralUBException {
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while (it.hasNext()) {
            BombaRefrigerant b = it.next();
            b.activa();
        }
    }

    /**
     * Desactiva totes les bombes refrigerants del sistema.
     */
    @Override
    public void desactiva() {
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while (it.hasNext()) {
            BombaRefrigerant b = it.next();
            b.desactiva();
        }
    }

    /**
     * Comprova si almenys una bomba refrigerant està activada.
     *
     * @return True si alguna bomba està activada, false en cas contrari.
     */
    @Override
    public boolean getActivat() {
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while (it.hasNext()) {
            BombaRefrigerant b = it.next();
            if (b.getActivat()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Revisa l'estat de les bombes refrigerants i registra incidències si cal.
     *
     * @param p Pàgina d'incidències on es registraran possibles errors.
     * @throws CentralUBException Si es detecta una fallada en alguna bomba.
     */
    @Override
    public void revisa(PaginaIncidencies p) throws CentralUBException {
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while (it.hasNext()) {
            BombaRefrigerant b = it.next();
            b.revisa(p);
        }
    }

    /**
     * Calcula el cost operatiu total de les bombes refrigerants activades.
     *
     * @return Cost operatiu total del sistema de refrigeració.
     */
    @Override
    public float getCostOperatiu() {
        float costOperatiu = 0.0F;
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while (it.hasNext()) {
            BombaRefrigerant b = it.next();
            costOperatiu += b.getCostOperatiu();
        }
        return costOperatiu;
    }

    /**
     * Calcula el output del sistema de refrigeració basat en la capacitat de les bombes activades.
     *
     * @param input Quantitat de calor que ha de ser refrigerada.
     * @return Output del sistema de refrigeració.
     */
    @Override
    public float calculaOutput(float input) {
        float outputBombes = 0.0F;
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while (it.hasNext()) {
            BombaRefrigerant b = it.next();
            if (b.getActivat()) {
                outputBombes += b.getCapacitat();
            }
        }
        if (outputBombes < input) {
            return outputBombes;
        } else {
            return input;
        }
    }

    /**
     * Retorna una representació en text de l'estat del sistema de refrigeració.
     *
     * @return Cadena amb la informació de les bombes refrigerants.
     */
    @Override
    public String toString() {
        StringBuilder retornar = new StringBuilder("Sistema Refrigeració\n");
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while (it.hasNext()) {
            BombaRefrigerant b = it.next();
            retornar.append(b.toString()).append("\n");
        }
        return retornar.toString();
    }

    public boolean getBombaEstat(int id) {
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while (it.hasNext()) {
            BombaRefrigerant b = it.next();
            if (b.getId() == id) {
                return b.getActivat();
            }
        }
        return false;
    }
}
