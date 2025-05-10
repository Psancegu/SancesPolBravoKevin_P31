package prog2.adaptador;

import prog2.model.Dades;
import prog2.vista.CentralUBException;

public class Adaptador {
    private Dades dades;

    public Adaptador() throws CentralUBException{
        this.dades = new Dades();
    }
}
