package prog2.model;

import java.io.Serializable;

/**
 * Classe PaginaEstat que representa una pàgina d'estat dins la bitàcola de la central.
 * Guarda informació sobre la inserció de barres i els outputs dels diferents components.
 *
 * @author Pol i Kevin
 */
public class PaginaEstat extends PaginaBitacola implements Serializable {
    private float insBarres;
    private float outReactor;
    private float outSistemaRefri;
    private float outGenVapor;
    private float outTurbina;

    /**
     * Constructor de la classe PaginaEstat.
     *
     * @param dia Dia en què es registra la informació d'estat.
     * @param insBarres Percentatge d'inserció de barres.
     * @param outReactor Output del reactor en graus.
     * @param outSistemaRefri Output del sistema de refrigeració en graus.
     * @param outGenVapor Output del generador de vapor en graus.
     * @param outTurbina Output de la turbina en unitats de potència.
     */
    public PaginaEstat(int dia, float insBarres, float outReactor, float outSistemaRefri, float outGenVapor, float outTurbina) {
        super(dia);
        this.insBarres = insBarres;
        this.outReactor = outReactor;
        this.outSistemaRefri = outSistemaRefri;
        this.outGenVapor = outGenVapor;
        this.outTurbina = outTurbina;
    }

    /**
     * Retorna el percentatge d'inserció de barres.
     *
     * @return Percentatge d'inserció de barres.
     */
    public float getInsBarres() {
        return insBarres;
    }

    /**
     * Retorna el valor de sortida del reactor en graus.
     *
     * @return Output del reactor.
     */
    public float getOutReactor() {
        return outReactor;
    }

    /**
     * Retorna el valor de sortida del sistema de refrigeració en graus.
     *
     * @return Output del sistema de refrigeració.
     */
    public float getOutSistemaRefri() {
        return outSistemaRefri;
    }

    /**
     * Retorna el valor de sortida del generador de vapor en graus.
     *
     * @return Output del generador de vapor.
     */
    public float getOutGenVapor() {
        return outGenVapor;
    }

    /**
     * Retorna el valor de sortida de la turbina en unitats de potència.
     *
     * @return Output de la turbina.
     */
    public float getOutTurbina() {
        return outTurbina;
    }

    /**
     * Retorna una representació en text de la pàgina d'estat.
     *
     * @return Cadena amb la informació d'estat registrada.
     */
    @Override
    public String toString() {
        return "# Pàgina Estat\n" +
                "- Dia: " + getDia() + "\n" +
                "- Inserció Barres: " + insBarres + " %\n" +
                "- Output Reactor: " + outReactor + " Graus\n" +
                "- Output Sistema de Refrigeració: " + outSistemaRefri + " Graus\n" +
                "- Output Generador de Vapor: " + outGenVapor + " Graus\n" +
                "- Output Turbina: " + outTurbina + " Unitats de Potència";
    }
}
