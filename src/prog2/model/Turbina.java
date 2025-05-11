package prog2.model;

import prog2.vista.CentralUBException;

public class Turbina implements InComponent{
    private boolean activa;


    Turbina(){
        activa = true;
    }
    @Override
    public void activa()throws CentralUBException  {
        activa = true;
    }

    @Override
    public void desactiva()  {
        activa = false;
    }

    @Override
    public boolean getActivat() {
        return activa;
    }

    @Override
    public void revisa(PaginaIncidencies p) throws CentralUBException {
        if (!activa) {
            p.afegeixIncidencia("El generador de vapor està desactivat durant la revisió.");
        }
    }

    @Override
    public float getCostOperatiu() {
        if(!activa){
            return 0.0F;
        }
        return 20.0F;
    }

    @Override
    public float calculaOutput(float input) {
        if(!activa || input < 100.0F){
            return 0.0F;
        }else{
            return input*2;
        }
    }
}
