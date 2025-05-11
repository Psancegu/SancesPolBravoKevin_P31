package prog2.model;

import java.io.Serializable;

public class PaginaEstat extends PaginaBitacola implements Serializable {
    private float insBarres;
    private float outReactor;
    private float outSistemaRefri;
    private float outGenVapor;
    private float outTurbina;


    public PaginaEstat(int dia, float insBarres, float outReactor, float outSistemaRefri, float outGenVapor, float outTurbina) {
        super(dia);
        this.insBarres = insBarres;
        this.outReactor = outReactor;
        this.outSistemaRefri = outSistemaRefri;
        this.outGenVapor = outGenVapor;
        this.outTurbina = outTurbina;
    }

    public float getInsBarres() {
        return insBarres;
    }

    public float getOutReactor() {
        return outReactor;
    }

    public float getOutSistemaRefri() {
        return outSistemaRefri;
    }

    public float getOutGenVapor() {
        return outGenVapor;
    }

    public float getOutTurbina() {
        return outTurbina;
    }

    @Override
    public String toString() {
        return "# Pàgina Estat\n" + "- Dia: " + getDia() + "\n" + "- Inserció Barres: " + insBarres + " %\n" + "- Output Reactor: " + outReactor + " Graus\n" +
                "- Output Sistema de Refrigeració: " + outSistemaRefri + " Graus\n" +  "- Output Generador de Vapor: " + outGenVapor + " Graus\n" +
                "- Output Turbina: " + outTurbina + " Unitats de Potència";
    }

}
