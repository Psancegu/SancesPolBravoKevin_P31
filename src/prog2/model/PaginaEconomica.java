package prog2.model;

import java.io.Serializable;

public class PaginaEconomica extends PaginaBitacola implements Serializable {
    private float demPotencia;
    private float potenciaGen;
    private float percentatge;
    private float beneficis;
    private float penalizacio;
    private float costOperatiu;
    private float guanys;

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

    public float getDemPotencia() {
        return demPotencia;
    }

    public float getPotenciaGen() {
        return potenciaGen;
    }

    public float getPercentatge() {
        return percentatge;
    }

    public float getBeneficis() {
        return beneficis;
    }

    public float getPenalizacio() {
        return penalizacio;
    }

    public float getCostOperatiu() {
        return costOperatiu;
    }

    public float getGuanys() {
        return guanys;
    }

    @Override
    public String toString() {
        return "# Pàgina Econòmica\n" + "- Dia: " + getDia() + "\n" + "- Demanda de Potència: " + getDemPotencia() + "\n" + "- Potència Generada: " + getPotenciaGen() + "\n" +
                "- Demanda de Potència Satisfeta: " + getPercentatge() + " %\n" + "- Beneficis: " + getBeneficis() + " Unitats Econòmiques\n" + "- Penalització Excés Producció: " +
                getPenalizacio() + " Unitats Econòmiques\n" + "- Cost Operatiu: " + getCostOperatiu() + " Unitats Econòmiques\n" + "- Guanys acumulats: " + getGuanys() + " Unitats Econòmiques";
    }

}
