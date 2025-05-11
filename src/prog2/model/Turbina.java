package prog2.model;

import prog2.vista.CentralUBException;

import java.io.Serializable;

/**
 * Classe Turbina que representa la turbina de la central nuclear.
 * Gestiona el seu estat, el cost operatiu i el processament de l'entrada per generar potència.
 *
 * @author Pol i Kevin
 */
public class Turbina implements InComponent, Serializable {
    private boolean activa;

    /**
     * Constructor de la classe Turbina.
     * Inicialitza la turbina com activada per defecte.
     */
    public Turbina(){
        activa = true;
    }

    /**
     * Activa la turbina.
     *
     * @throws CentralUBException Si hi ha algun error en el procés d'activació.
     */
    @Override
    public void activa()throws CentralUBException  {
        activa = true;
    }

    /**
     * Desactiva la turbina.
     */
    @Override
    public void desactiva()  {
        activa = false;
    }

    /**
     * Retorna si la turbina està activada.
     *
     * @return True si està activada, false en cas contrari.
     */
    @Override
    public boolean getActivat() {
        return activa;
    }

    /**
     * Revisa l'estat de la turbina i registra una incidència si està desactivada.
     *
     * @param p Pàgina d'incidències on es registrarà el problema si la turbina està desactivada.
     * @throws CentralUBException Si es detecta una anomalia.
     */
    @Override
    public void revisa(PaginaIncidencies p) throws CentralUBException {
        if (!activa) {
            p.afegeixIncidencia("El generador de vapor està desactivat durant la revisió.");
        }
    }

    /**
     * Retorna el cost operatiu de la turbina.
     *
     * @return Cost operatiu si està activada, 0.0 si està desactivada.
     */
    @Override
    public float getCostOperatiu() {
        if(!activa){
            return 0.0F;
        }
        return 20.0F;
    }

    /**
     * Calcula la sortida de potència de la turbina en funció de l'entrada rebuda.
     *
     * @param input Quantitat de potència entrada a la turbina.
     * @return Quantitat de potència generada per la turbina.
     */
    @Override
    public float calculaOutput(float input) {
        if(!activa || input < 100.0F){
            return 0.0F;
        }else{
            return input*2;
        }
    }
}
