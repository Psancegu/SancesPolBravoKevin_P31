package prog2.model;

import java.io.Serializable;

/**
 * Classe PaginaEconomica que representa una pàgina dins la bitàcola econòmica de la central.
 * Guarda informació sobre la potència generada, els beneficis, costos i penalitzacions.
 *
 * @author Pol i Kevin
 */
public class PaginaEconomica extends PaginaBitacola implements Serializable {
    private float demPotencia;
    private float potenciaGen;
    private float percentatge;
    private float beneficis;
    private float penalizacio;
    private float costOperatiu;
    private float guanys;

    /**
     * Constructor de la classe PaginaEconomica.
     *
     * @param dia Dia en què es registra la informació econòmica.
     * @param demPotencia Demanda de potència sol·licitada.
     * @param potenciaGen Potència generada pel sistema.
     * @param percentatge Percentatge de demanda de potència satisfeta.
     * @param beneficis Beneficis obtinguts en unitats econòmiques.
     * @param penalizacio Penalització per excés de potència generada.
     * @param costOperatiu Cost operatiu de la central.
     * @param guanys Guanys acumulats després dels càlculs econòmics.
     */
    public PaginaEconomica(int dia, float demPotencia, float potenciaGen, float percentatge, float beneficis, float penalizacio, float costOperatiu, float guanys) {
        super(dia);
        this.demPotencia = demPotencia;
        this.potenciaGen = potenciaGen;
        this.percentatge = percentatge;
        this.beneficis = beneficis;
        this.penalizacio = penalizacio;
        this.costOperatiu = costOperatiu;
        this.guanys = guanys;
    }

    /**
     * Retorna la demanda de potència registrada.
     *
     * @return Valor de la demanda de potència.
     */
    public float getDemPotencia() {
        return demPotencia;
    }

    /**
     * Retorna la potència generada pel sistema.
     *
     * @return Valor de la potència generada.
     */
    public float getPotenciaGen() {
        return potenciaGen;
    }

    /**
     * Retorna el percentatge de demanda de potència satisfeta.
     *
     * @return Percentatge de demanda satisfeta.
     */
    public float getPercentatge() {
        return percentatge;
    }

    /**
     * Retorna els beneficis econòmics obtinguts.
     *
     * @return Valor dels beneficis en unitats econòmiques.
     */
    public float getBeneficis() {
        return beneficis;
    }

    /**
     * Retorna la penalització aplicada per excés de potència generada.
     *
     * @return Valor de la penalització en unitats econòmiques.
     */
    public float getPenalizacio() {
        return penalizacio;
    }

    /**
     * Retorna el cost operatiu de la central.
     *
     * @return Valor del cost operatiu en unitats econòmiques.
     */
    public float getCostOperatiu() {
        return costOperatiu;
    }

    /**
     * Retorna els guanys acumulats.
     *
     * @return Valor dels guanys en unitats econòmiques.
     */
    public float getGuanys() {
        return guanys;
    }

    /**
     * Retorna una representació en text de la pàgina econòmica.
     *
     * @return Cadena amb la informació econòmica registrada.
     */
    @Override
    public String toString() {
        return "# Pàgina Econòmica\n" +
                "- Dia: " + getDia() + "\n" +
                "- Demanda de Potència: " + getDemPotencia() + "\n" +
                "- Potència Generada: " + getPotenciaGen() + "\n" +
                "- Demanda de Potència Satisfeta: " + getPercentatge() + " %\n" +
                "- Beneficis: " + getBeneficis() + " Unitats Econòmiques\n" +
                "- Penalització Excés Producció: " + getPenalizacio() + " Unitats Econòmiques\n" +
                "- Cost Operatiu: " + getCostOperatiu() + " Unitats Econòmiques\n" +
                "- Guanys acumulats: " + getGuanys() + " Unitats Econòmiques";
    }
}
