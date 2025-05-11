package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class PaginaIncidencies extends PaginaBitacola implements Serializable{
    private ArrayList<String> incidencies;

    public PaginaIncidencies(int dia) {
        super(dia);
        incidencies = new ArrayList<>();
    }

    public void afegeixIncidencia(String descIncidencia){
        incidencies.add(descIncidencia);
    }

    public String getIncidencies() {
        if(incidencies.isEmpty()) {
            return "- No hi ha cap incidència";
        }

        StringBuilder total = new StringBuilder();
        Iterator<String> it = incidencies.iterator();
        while(it.hasNext()){
            String aux = it.next();
            total.append("- Descripció Incidència: ").append(aux).append("\n");
        }
        return total.toString();
    }

    @Override
    public String toString() {
        return "# Pàgina Incidències \n" + "- Dia: " + getDia() + "\n" + getIncidencies();
    }
}
