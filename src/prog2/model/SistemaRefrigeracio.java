package prog2.model;

import prog2.vista.CentralUBException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class SistemaRefrigeracio implements InComponent, Serializable {
    ArrayList<BombaRefrigerant> bombaRefrigerants;

    public void afegirBomba(BombaRefrigerant b){
        bombaRefrigerants.add(b);
    }
    @Override
    public void activa() throws CentralUBException {
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while(it.hasNext()){
            BombaRefrigerant b = it.next();
            b.activa();
        }
    }

    @Override
    public void desactiva() {
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while(it.hasNext()){
            BombaRefrigerant b = it.next();
            b.desactiva();
        }
    }

    @Override
    public boolean getActivat() {
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while(it.hasNext()){
            BombaRefrigerant b = it.next();
            if(b.getActivat()){
                return true;
            }
        }
        return false;

    }

    @Override
    public void revisa(PaginaIncidencies p) throws CentralUBException {
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while(it.hasNext()){
            BombaRefrigerant b = it.next();
            b.revisa(p);
        }
    }

    @Override
    public float getCostOperatiu() {
        float costOperatiu = 0.0F;
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while(it.hasNext()){
            BombaRefrigerant b = it.next();
            costOperatiu += b.getCostOperatiu();
        }
        return costOperatiu;
    }

    @Override
    public float calculaOutput(float input) {
        float outputBombes = 0.0F;
        Iterator<BombaRefrigerant> it = bombaRefrigerants.iterator();
        while(it.hasNext()){
            BombaRefrigerant b = it.next();
            if(b.getActivat()){
                outputBombes += b.getCapacitat();
            }
        }
        if(outputBombes < input){
            return outputBombes;
        }else {
            return input;
        }
    }
}