package prog2.model;

public class GeneradorVapor implements InComponent {
    boolean activa;
    GeneradorVapor() {
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
    public void revisa(PaginaIncidencies p) {

    }

    @Override
    public float getCostOperatiu() {
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
