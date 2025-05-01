package prog2.model;

import prog2.vista.CentralUBException;

public class BombaRefrigerant implements InBombaRefrigerant {
    int id;
    boolean activo;
    boolean foraServei;
    VariableUniforme varUniforme;
    BombaRefrigerant(int identificador,VariableUniforme var) {
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
    public void revisa(PaginaIncidencies p) {
        int prob = varUniforme.seguentValor();

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
        System.out.println("id=" + id+", Activitat="+activo+", Fora de servei="+foraServei);
        return null;
    }
}
