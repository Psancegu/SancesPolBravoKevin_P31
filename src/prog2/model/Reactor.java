package prog2.model;

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

    }

    @Override
    public void desactiva() {

    }

    @Override
    public boolean getActivat() {
        return false;
    }

    @Override
    public void revisa(PaginaIncidencies p) {

    }

    @Override
    public float getCostOperatiu() {
        return 0;
    }

    @Override
    public float calculaOutput(float input) {
        return 0;
    }
}
