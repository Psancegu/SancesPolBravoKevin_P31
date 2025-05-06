package prog2.model;

public class Turbina implements InComponent{
    boolean activa;
    Turbina(){
        activa = true;
    }
    @Override
    public void activa()  {
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
    public void revisa(PaginaIncidencies p) {

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
