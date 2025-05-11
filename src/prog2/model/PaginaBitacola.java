package prog2.model;

import java.io.Serializable;

public class PaginaBitacola implements Serializable {
    private int dia;

    public PaginaBitacola() {
        this.dia = 0;
    }

    public PaginaBitacola(int dia) {
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

}
