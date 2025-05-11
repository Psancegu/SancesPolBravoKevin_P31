package prog2.adaptador;

import prog2.model.Dades;
import prog2.vista.CentralUBException;

import java.io.*;

public class Adaptador {
    private Dades dades;

    public Adaptador() throws CentralUBException {
        this.dades = new Dades();
    }

    public void guardarDades(String camiDesti) throws CentralUBException {
        try (FileOutputStream fout = new FileOutputStream(camiDesti);
             ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(this.dades);
        } catch (IOException e) {
            throw new CentralUBException("Error en guardar les dades: " + e.getMessage());
        }
    }

    public void carregarDades(String camiOrigen) throws CentralUBException {
        try (FileInputStream fin = new FileInputStream(camiOrigen);
             ObjectInputStream ois = new ObjectInputStream(fin)) {
            this.dades = (Dades) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new CentralUBException("Error en carregar les dades: " + e.getMessage());
        }
    }


    public String finalitzaDia(float demandaPotencia) throws CentralUBException {
        return dades.finalitzaDia(demandaPotencia).toString();
    }

    public String mostrarIncidencies() {
        return this.dades.mostraIncidencies().toString();
    }

    public String mostrarBitacola() {
        return this.dades.mostraBitacola().toString();
    }


    public String mostrarEstat() {
        return this.dades.mostraEstat().toString();
    }


    public String obtenirDemandaSatisfeta(float demandaPotencia) {
        return "Demanda Potencia: " + demandaPotencia + ", Potència amb la configuració actual: " + this.dades.calculaPotencia() + ", Percentatge de Demanda Satisfeta:  " + this.dades.getPercDemanda(demandaPotencia) + "\n";
    }

    public float obtenirInsercioBarres() {
        return this.dades.getInsercioBarres();
    }

    public void establirInsercioBarres(float insercio) throws CentralUBException {
        this.dades.setInsercioBarres(insercio);
    }

    public void activarReactor() throws CentralUBException {
        this.dades.activaReactor();
    }

    public void desactivarReactor() {
        this.dades.desactivaReactor();
    }


    public String mostrarEstatReactor() {
        return this.dades.mostraReactor().toString();
    }

    public void activarTotesBombes() throws CentralUBException {
        this.dades.activarTotesBombes();
    }

    public void desactivarTotesBombes() throws CentralUBException {
        this.dades.desactivarTotesBombes();
    }

    public void activarBomba(int id) throws CentralUBException {
        this.dades.activaBomba(id);
    }

    public void desactivarBomba(int id) {
        this.dades.desactivaBomba(id);
    }

    public String mostrarEstatRefrigeracio() {
        return this.dades.mostraSistemaRefrigeracio().toString();
    }
}