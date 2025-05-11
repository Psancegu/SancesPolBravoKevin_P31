package prog2.model;

import prog2.vista.CentralUBException;

import java.io.Serializable;

public class BombaRefrigerant implements InBombaRefrigerant, Serializable {
    private int id;
    private boolean activo;
    private boolean foraServei;
    private VariableUniforme varUniforme;


    public BombaRefrigerant(VariableUniforme var,int identificador) {
        varUniforme = var;
        id = identificador;
        activo = false;
        foraServei = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void activa() throws CentralUBException {
        if (foraServei) {
            throw new CentralUBException("Bomba en fora servei");
        }
        activo = true;
    }

    @Override
    public void desactiva() {
        activo = false;
    }

    @Override
    public boolean getActivat() {
        return activo;
    }

    @Override
    public void revisa(PaginaIncidencies p) throws CentralUBException {
        VariableUniforme variableUniforme = new VariableUniforme(System.currentTimeMillis());

        int valor = variableUniforme.seguentValor();
        if (valor < 25) {
            p.afegeixIncidencia("La bomba refrigerant amb ID:" + getId() + "ha quedat fora de servei.");
            foraServei = true;
            desactiva();
        }
        else{
            activa();
        }
    }

    @Override
    public boolean getForaDeServei() {
        return foraServei;
    }

    @Override
    public float getCapacitat() {
        if(!activo){
            return 0.0F;
        }else{
            return 250.0F;
        }
    }

    @Override
    public float getCostOperatiu() {
        if(activo) {
            return 130.0F;
        }else{
            return 0.0F;
        }
    }

    public String toString(){
        return "Id=" + id+", Activat="+activo+", Fora de servei="+foraServei;
    }
}
