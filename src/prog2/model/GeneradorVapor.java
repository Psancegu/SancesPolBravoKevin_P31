package prog2.model;

import prog2.vista.CentralUBException;

import java.io.Serializable;

public class GeneradorVapor implements InComponent, Serializable {
    private boolean activa;


    public GeneradorVapor() {
        activa = true;
    }
    @Override
    public void activa() {
        activa = true;
    }

    @Override
    public void desactiva() {
        activa = false;
    }

    @Override
    public boolean getActivat() {
        return activa;
    }

    @Override
    public void revisa(PaginaIncidencies p) throws CentralUBException {
        if (!activa) {
            p.afegeixIncidencia("El generador de vapor està desactivat.");
        }
    }

    @Override
    public float getCostOperatiu() {
        if(!activa){
            return 0.0F;
        }
        return 25.0F;
    }

    @Override
    public float calculaOutput(float input) {
        if(!activa){
            return 25.0F;
        }else{
            return input*0.9F;
        }
    }
}
