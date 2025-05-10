package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bitacola implements InBitacola{
    private ArrayList<PaginaBitacola> paginesBitacola;

    public Bitacola() {
        this.paginesBitacola = new ArrayList<>();
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

    public String generateToString(){
        StringBuilder aux = new StringBuilder();
        Iterator<PaginaBitacola> it = paginesBitacola.iterator();
        while(it.hasNext()) {
            PaginaBitacola p = it.next();
            aux.append(p.toString()).append('\n');
        }
        return aux.toString();
    }

    @Override
    public String toString() {
        return generateToString();
    }
}
