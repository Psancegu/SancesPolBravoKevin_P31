package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bitacola implements InBitacola, Serializable {
    private ArrayList<PaginaBitacola> paginesBitacola;

    public Bitacola() {

        this.paginesBitacola = new ArrayList<>();
        PaginaEstat dia0 = new PaginaEstat(0,0,0,0,0,0);
        this.paginesBitacola.add(dia0);
        PaginaEconomica dia0e = new PaginaEconomica(0,0,0,0,0,0,0,0);
        this.paginesBitacola.add(dia0e);
        PaginaIncidencies dia0i = new PaginaIncidencies(0);
        this.paginesBitacola.add(dia0i);
    }

    @Override
    public void afegeixPagina(PaginaBitacola p) {
        paginesBitacola.add(p);
    }

    @Override
    public List<PaginaIncidencies> getIncidencies() {
        List<PaginaIncidencies> aux = new ArrayList<PaginaIncidencies>();

        Iterator<PaginaBitacola> it = paginesBitacola.iterator();
        while(it.hasNext()) {
            PaginaBitacola p = it.next();
            if(p instanceof PaginaIncidencies) {
                aux.add((PaginaIncidencies) p);
            }
        }
        return aux;
    }

    public PaginaEstat getPaginaEstat() {
        Iterator<PaginaBitacola> it = paginesBitacola.iterator();
        PaginaEstat retornar = null;
        PaginaBitacola aux = it.next();
        while(it.hasNext()) {
            if(aux instanceof PaginaEstat) {
                retornar = (PaginaEstat) aux;
            }
            it.next();
        }
        return retornar;
    }

    public String generateToString(){
        StringBuilder aux = new StringBuilder();
        Iterator<PaginaBitacola> it = paginesBitacola.iterator();
        while(it.hasNext()) {
            PaginaBitacola p = it.next();
            aux.append(p.toString()).append("\n\n");
        }
        return aux.toString();
    }

    @Override
    public String toString() {
        return generateToString();
    }
}
