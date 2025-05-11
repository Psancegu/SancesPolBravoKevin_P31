/**
 * Classe Adaptador que gestiona la persistència de les dades i proporciona accés als mètodes de la classe Dades.
 * S'encarrega de guardar i carregar informació, així com interactuar amb el sistema per modificar el seu estat.
 *
 * @author Pol i Kevin
 */
package prog2.adaptador;

import prog2.model.Dades;
import prog2.vista.CentralUBException;

import java.io.*;

public class Adaptador {
    private Dades dades;

    /**
     * Constructor de la classe Adaptador.
     * Inicialitza les dades.
     *
     * @throws CentralUBException Si hi ha algun problema en la inicialització.
     */
    public Adaptador() throws CentralUBException {
        this.dades = new Dades();
    }

    /**
     * Guarda les dades en un fitxer.
     *
     * @param camiDesti Ruta del fitxer on es guardaran les dades.
     * @throws CentralUBException Si hi ha un error en el procés de guardat.
     */
    public void guardarDades(String camiDesti) throws CentralUBException {
        try (FileOutputStream fout = new FileOutputStream(camiDesti);
             ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(this.dades);
        } catch (IOException e) {
            throw new CentralUBException("Error en guardar les dades: " + e.getMessage());
        }
    }

    /**
     * Carrega les dades des d'un fitxer.
     *
     * @param camiOrigen Ruta del fitxer des d'on es carregaran les dades.
     * @throws CentralUBException Si hi ha un error en el procés de càrrega.
     */
    public void carregarDades(String camiOrigen) throws CentralUBException {
        try (FileInputStream fin = new FileInputStream(camiOrigen);
             ObjectInputStream ois = new ObjectInputStream(fin)) {
            this.dades = (Dades) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new CentralUBException("Error en carregar les dades: " + e.getMessage());
        }
    }

    /**
     * Finalitza el dia i retorna el resultat.
     *
     * @param demandaPotencia Quantitat de potència demanada.
     * @return Estat després de finalitzar el dia.
     * @throws CentralUBException Si hi ha un problema en el càlcul.
     */
    public String finalitzaDia(float demandaPotencia) throws CentralUBException {
        return dades.finalitzaDia(demandaPotencia).toString();
    }

    /**
     * Mostra les incidències registrades.
     *
     * @return String amb la informació de les incidències.
     */
    public String mostrarIncidencies() {
        return this.dades.mostraIncidencies().toString();
    }

    /**
     * Mostra la bitàcola del sistema.
     *
     * @return String amb la informació de la bitàcola.
     */
    public String mostrarBitacola() {
        return this.dades.mostraBitacola().toString();
    }

    /**
     * Mostra l'estat actual del sistema.
     *
     * @return String amb l'estat actual.
     */
    public String mostrarEstat() {
        return this.dades.mostraEstat().toString();
    }

    /**
     * Obté la demanda satisfeta basada en la potència sol·licitada.
     *
     * @param demandaPotencia Quantitat de potència demanada.
     * @return String amb la informació de la demanda satisfeta.
     */
    public String obtenirDemandaSatisfeta(float demandaPotencia) {
        return "Demanda Potencia: " + demandaPotencia + ", Potència amb la configuració actual: " + this.dades.calculaPotencia() + ", Percentatge de Demanda Satisfeta:  " + this.dades.getPercDemanda(demandaPotencia) + "\n";
    }

    /**
     * Obté el valor d'inserció de barres.
     *
     * @return Valor d'inserció de barres.
     */
    public float obtenirInsercioBarres() {
        return this.dades.getInsercioBarres();
    }

    /**
     * Estableix el valor d'inserció de barres.
     *
     * @param insercio Nou valor d'inserció.
     * @throws CentralUBException Si hi ha un error en el procés.
     */
    public void establirInsercioBarres(float insercio) throws CentralUBException {
        this.dades.setInsercioBarres(insercio);
    }

    /**
     * Activa el reactor.
     *
     * @throws CentralUBException Si hi ha un error en l'activació.
     */
    public void activarReactor() throws CentralUBException {
        this.dades.activaReactor();
    }

    /**
     * Desactiva el reactor.
     */
    public void desactivarReactor() {
        this.dades.desactivaReactor();
    }

    /**
     * Mostra l'estat actual del reactor.
     *
     * @return String amb l'estat del reactor.
     */
    public String mostrarEstatReactor() {
        return this.dades.mostraReactor().toString();
    }

    /**
     * Activa totes les bombes del sistema.
     *
     * @throws CentralUBException Si hi ha un error en l'activació.
     */
    public void activarTotesBombes() throws CentralUBException {
        this.dades.activarTotesBombes();
    }

    /**
     * Desactiva totes les bombes del sistema.
     *
     * @throws CentralUBException Si hi ha un error en la desactivació.
     */
    public void desactivarTotesBombes() throws CentralUBException {
        this.dades.desactivarTotesBombes();
    }

    /**
     * Activa una bomba específica.
     *
     * @param id Identificador de la bomba.
     * @throws CentralUBException Si hi ha un error en l'activació.
     */
    public void activarBomba(int id) throws CentralUBException {
        this.dades.activaBomba(id);
    }

    /**
     * Desactiva una bomba específica.
     *
     * @param id Identificador de la bomba.
     */
    public void desactivarBomba(int id) {
        this.dades.desactivaBomba(id);
    }

    /**
     * Mostra l'estat del sistema de refrigeració.
     *
     * @return String amb l'estat del sistema de refrigeració.
     */
    public String mostrarEstatRefrigeracio() {
        return this.dades.mostraSistemaRefrigeracio().toString();
    }
}
