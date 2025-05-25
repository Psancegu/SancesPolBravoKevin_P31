/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import prog2.vista.CentralUBException;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Classe Dades que gestiona la informació de la central nuclear.
 * Conté els diversos components i la seva interacció en el sistema.
 *
 * @author Daniel Ortiz
 */
public class Dades implements InDades, Serializable {
    public final static long VAR_UNIF_SEED = 123;
    public final static float GUANYS_INICIALS = 0;
    public final static float PREU_UNITAT_POTENCIA = 1;
    public final static float PENALITZACIO_EXCES_POTENCIA = 250;

    // Atributs de la central nuclear
    private VariableUniforme variableUniforme;
    private float insercioBarres;
    private Reactor reactor;
    private SistemaRefrigeracio sistemaRefrigeracio;
    private GeneradorVapor generadorVapor;
    private Turbina turbina;
    private Bitacola bitacola;
    private int dia;
    private float guanysAcumulats;

    /**
     * Constructor de la classe Dades. Inicialitza els components de la central.
     *
     * @throws CentralUBException Si hi ha algun problema en la configuració inicial.
     */
    public Dades() throws CentralUBException {
        // Inicialitza atributs
        this.variableUniforme = new VariableUniforme(VAR_UNIF_SEED);
        this.insercioBarres = 100;
        this.reactor = new Reactor();
        this.reactor.desactiva();
        this.sistemaRefrigeracio = new SistemaRefrigeracio();
        this.generadorVapor = new GeneradorVapor();
        this.generadorVapor.activa();
        this.turbina = new Turbina();
        this.turbina.activa();
        this.bitacola = new Bitacola();
        this.dia = 1;
        this.guanysAcumulats = GUANYS_INICIALS;

        // Afegeix bombes refrigerants
        BombaRefrigerant b0 = new BombaRefrigerant(variableUniforme, 0);
        BombaRefrigerant b1 = new BombaRefrigerant(variableUniforme, 1);
        BombaRefrigerant b2 = new BombaRefrigerant(variableUniforme, 2);
        BombaRefrigerant b3 = new BombaRefrigerant(variableUniforme, 3);

        this.sistemaRefrigeracio.afegirBomba(b0);
        this.sistemaRefrigeracio.afegirBomba(b1);
        this.sistemaRefrigeracio.afegirBomba(b2);
        this.sistemaRefrigeracio.afegirBomba(b3);

        this.sistemaRefrigeracio.desactiva();
    }

    /**
     * Retorna el valor d'inserció de barres al reactor.
     *
     * @return Valor de les barres inserides.
     */
    @Override
    public float getInsercioBarres() {
        return insercioBarres;
    }

    /**
     * Estableix el valor d'inserció de barres al reactor.
     *
     * @param insercioBarres Nou valor d'inserció.
     * @throws CentralUBException Si hi ha un error en l'establiment.
     */
    @Override
    public void setInsercioBarres(float insercioBarres) throws CentralUBException {
        this.insercioBarres = insercioBarres;
    }

    /**
     * Activa el reactor de la central.
     *
     * @throws CentralUBException Si hi ha un error en l'activació.
     */
    @Override
    public void activaReactor() throws CentralUBException {
        this.reactor.activa();
    }

    /**
     * Desactiva el reactor de la central.
     */
    @Override
    public void desactivaReactor() {
        this.reactor.desactiva();
    }

    /**
     * Mostra l'estat actual del reactor.
     *
     * @return Objecte Reactor amb el seu estat.
     */
    @Override
    public Reactor mostraReactor() {
        return this.reactor;
    }

    /**
     * Activa una bomba específica dins el sistema de refrigeració.
     *
     * @param id Identificador de la bomba.
     * @throws CentralUBException Si hi ha un error en l'activació.
     */
    @Override
    public void activaBomba(int id) throws CentralUBException {
        Iterator<BombaRefrigerant> it = this.sistemaRefrigeracio.bombaRefrigerants.iterator();
        BombaRefrigerant b = it.next();
        while (it.hasNext() && b.getId() != id) {
            b = it.next();
        }
        b.activa();
    }

    /**
     * Desactiva una bomba específica dins el sistema de refrigeració.
     *
     * @param id Identificador de la bomba.
     */
    @Override
    public void desactivaBomba(int id) {
        Iterator<BombaRefrigerant> it = this.sistemaRefrigeracio.bombaRefrigerants.iterator();
        BombaRefrigerant b = it.next();
        while (it.hasNext() && b.getId() != id) {
            b = it.next();
        }
        b.desactiva();
    }

    /**
     * Activa totes les bombes del sistema de refrigeració.
     *
     * @throws CentralUBException Si hi ha un error en l'activació.
     */
    public void activarTotesBombes() throws CentralUBException {
        Iterator<BombaRefrigerant> it = this.sistemaRefrigeracio.bombaRefrigerants.iterator();
        BombaRefrigerant b = it.next();
        while (it.hasNext()) {
            b.activa();
            b = it.next();
        }
    }

    /**
     * Desactiva totes les bombes del sistema de refrigeració.
     *
     * @throws CentralUBException Si hi ha un error en la desactivació.
     */
    public void desactivarTotesBombes() throws CentralUBException {
        Iterator<BombaRefrigerant> it = this.sistemaRefrigeracio.bombaRefrigerants.iterator();
        BombaRefrigerant b = it.next();
        while (it.hasNext()) {
            b.desactiva();
            b = it.next();
        }
    }

    /**
     * Mostra l'estat actual del sistema de refrigeració.
     *
     * @return Objecte SistemaRefrigeracio amb l'estat actual.
     */
    @Override
    public SistemaRefrigeracio mostraSistemaRefrigeracio() {
        return this.sistemaRefrigeracio;
    }

    /**
     * Calcula la potència generada pel sistema.
     *
     * @return Valor de la potència produïda.
     */
    @Override
    public float calculaPotencia() {
        return turbina.calculaOutput(generadorVapor.calculaOutput(sistemaRefrigeracio.calculaOutput(reactor.calculaOutput(insercioBarres))));
    }

    /**
     * Retorna els guanys acumulats de la central.
     *
     * @return Valor dels guanys acumulats.
     */
    @Override
    public float getGuanysAcumulats() {
        return this.guanysAcumulats;
    }

    /**
     * Mostra l'estat actual de la central.
     *
     * @return Objecte PaginaEstat amb les dades actuals de la central.
     */
    @Override
    public PaginaEstat mostraEstat() {
        float outputReac = this.reactor.calculaOutput(this.insercioBarres);
        float outputSR = this.sistemaRefrigeracio.calculaOutput(outputReac);
        float outputGenVapor = this.generadorVapor.calculaOutput(outputSR);
        float outputTurbina = this.turbina.calculaOutput(outputGenVapor);
        return new PaginaEstat(dia, this.insercioBarres, outputReac, outputSR, outputGenVapor, outputTurbina);
    }

    /**
     * Mostra la bitàcola amb el registre històric del sistema.
     *
     * @return Objecte Bitacola amb el registre actual.
     */
    @Override
    public Bitacola mostraBitacola() {
        return this.bitacola;
    }

    /**
     * Retorna la llista d'incidències registrades a la bitàcola.
     *
     * @return Llista de PaginaIncidencies amb les incidències registrades.
     */
    @Override
    public List<PaginaIncidencies> mostraIncidencies() {
        return this.bitacola.getIncidencies();
    }

    /**
     * Calcula el percentatge de demanda satisfeta en funció de la potència requerida.
     *
     * @param demandaPotencia Quantitat de potència demanada.
     * @return Percentatge de demanda satisfeta.
     */
    public float getPercDemanda(float demandaPotencia) {
        return (calculaPotencia() / demandaPotencia) * 100;
    }

    /**
     * Actualitza l'economia de la central.
     * Genera una pàgina econòmica a partir de la demanda de potència actual, calculant beneficis, penalització per excés de potència, costos operatius i guanys acumulats.
     *
     * @param demandaPotencia Demanda de potència actual.
     * @return Objecte PaginaEconomica amb la informació econòmica del dia.
     */
    private PaginaEconomica actualitzaEconomia(float demandaPotencia) {
        float demandaSatisfeta = (calculaPotencia() / demandaPotencia) * 100;
        float beneficis;
        float penalitzacio = 0.0f;

        if (calculaPotencia() > demandaPotencia) {
            beneficis = demandaPotencia;
        } else {
            beneficis = calculaPotencia();
        }

        if (calculaPotencia() > demandaPotencia) {
            penalitzacio = PENALITZACIO_EXCES_POTENCIA;
        }

        float costOperatiu = this.reactor.getCostOperatiu() + this.sistemaRefrigeracio.getCostOperatiu() +
                this.turbina.getCostOperatiu() + this.generadorVapor.getCostOperatiu();
        float guanys = beneficis - penalitzacio - costOperatiu;

        guanysAcumulats += guanys;

        return new PaginaEconomica(dia, demandaPotencia, calculaPotencia(), demandaSatisfeta, beneficis, penalitzacio, costOperatiu, guanys);
    }

    /**
     * Estableix la nova temperatura del reactor després de la refrigeració.
     */
    private void refrigeraReactor(float outputReactor, float outputRefrigeracio) {
        float novaTemperatura = reactor.getTemperatura() + outputReactor - outputRefrigeracio;
        if (novaTemperatura < 25.0F) novaTemperatura = 25.0F;
        reactor.setTemperatura(novaTemperatura);
    }

    /**
     * Revisa els components de la central i registra incidències en la pàgina proporcionada.
     *
     * @param paginaIncidencies Pàgina d'incidències on s'afegiran els possibles errors.
     * @throws CentralUBException Si es detecten problemes en els components de la central.
     */
    private void revisaComponents(PaginaIncidencies paginaIncidencies) throws CentralUBException {
        this.reactor.revisa(paginaIncidencies);
        this.sistemaRefrigeracio.revisa(paginaIncidencies);
        this.generadorVapor.revisa(paginaIncidencies);
        this.turbina.revisa(paginaIncidencies);
    }

    /**
     * Finalitza el dia de funcionament de la central nuclear.
     * Actualitza l'estat dels components, genera informes i registra les dades del dia.
     *
     * @param demandaPotencia Quantitat de potència demanada.
     * @return Bitacola amb el registre del dia finalitzat.
     * @throws CentralUBException Si hi ha errors durant el procés.
     */
    public Bitacola finalitzaDia(float demandaPotencia) throws CentralUBException {
        // Actualitza economia
        PaginaEconomica paginaEconomica = actualitzaEconomia(demandaPotencia);

        // Genera pàgina d'estat amb la configuració escollida
        PaginaEstat paginaEstat = mostraEstat();

        // Refrigera el reactor
        float outputReactor = reactor.calculaOutput(insercioBarres);
        float outputRefrigeracio = sistemaRefrigeracio.calculaOutput(outputReactor);
        refrigeraReactor(outputReactor, outputRefrigeracio);

        // Revisa els components de la central i registra incidències
        PaginaIncidencies paginaIncidencies = new PaginaIncidencies(dia);
        revisaComponents(paginaIncidencies);

        // Incrementa el dia
        dia += 1;

        // Guarda pàgines a la bitàcola
        bitacola.afegeixPagina(paginaEconomica);
        bitacola.afegeixPagina(paginaEstat);
        bitacola.afegeixPagina(paginaIncidencies);

        // Retorna la bitàcola amb el registre del dia
        Bitacola bitacolaDia = new Bitacola();
        bitacolaDia.afegeixPagina(paginaEconomica);
        bitacolaDia.afegeixPagina(paginaEstat);
        bitacolaDia.afegeixPagina(paginaIncidencies);
        return bitacolaDia;
    }

    /** Mètodes auxilirs per la GUI*/

    public int getDia(){
        return this.dia;
    }

    public boolean getEstatReactor(){
        return this.reactor.getActivat();
    }

    public boolean getBomba(int id){
        return this.sistemaRefrigeracio.getBombaEstat(id);
    }
}

