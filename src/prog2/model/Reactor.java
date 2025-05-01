package prog2.model;

import prog2.vista.CentralUBException;

public class Reactor implements InComponent{
    boolean active;
    float temperatura;
    public Reactor() {
        active = false;
    }
    public float getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
    @Override
    public void activa() throws CentralUBException {
        if(temperatura>1000.0F){
            throw new CentralUBException("No es pot activar:Temperatura > 1000.0");
        }else{
            active = true;
        }
    }

    @Override
    public void desactiva() {
        active = false;
    }

    @Override
    public boolean getActivat() {
        return active;
    }

    @Override
    public void revisa(PaginaIncidencies p) {

    }

    @Override
    public float getCostOperatiu() {
        if(!active){
            return 0.0F;
        }
        return 35.0F;
    }

    @Override
    public float calculaOutput(float input) {
        if(!active ){
            return temperatura;
        }else{
            return temperatura+(100-input)*10;
        }
    }
}
