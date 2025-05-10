/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import prog2.vista.CentralUBException;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Daniel Ortiz
 */
public class Dades implements InDades {
    public final static long  VAR_UNIF_SEED = 123;
    public final static float GUANYS_INICIALS = 0;
    public final static float PREU_UNITAT_POTENCIA = 1;
    public final static float PENALITZACIO_EXCES_POTENCIA = 250;

    // Afegir atributs:
    private VariableUniforme variableUniforme;
    private float insercioBarres;
    private Reactor reactor;
    private SistemaRefrigeracio sistemaRefrigeracio;
    private GeneradorVapor generadorVapor;
    private Turbina turbina;
    private Bitacola bitacola;
    private int dia;
    private float guanysAcumulats;

    public Dades() throws CentralUBException {
        // Inicialitza Atributs
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

    @Override
    public float getInsercioBarres() {
        return insercioBarres;
    }

    @Override
    public void setInsercioBarres(float insercioBarres) throws CentralUBException {
        this.insercioBarres = insercioBarres;
    }

    @Override
    public void activaReactor() throws CentralUBException {
        this.reactor.activa();
    }

    @Override
    public void desactivaReactor() {
        this.reactor.desactiva();
    }

    @Override
    public Reactor mostraReactor() {
        return this.reactor;
    }

    @Override
    public void activaBomba(int id) throws CentralUBException {
        Iterator<BombaRefrigerant> it = this.sistemaRefrigeracio.bombaRefrigerants.iterator();
        BombaRefrigerant b = it.next();
        while(it.hasNext() && b.getId() != id){
            b = it.next();
        }
        b.activa();
    }

    @Override
    public void desactivaBomba(int id) {
        Iterator<BombaRefrigerant> it = this.sistemaRefrigeracio.bombaRefrigerants.iterator();
        BombaRefrigerant b = it.next();
        while(it.hasNext() && b.getId() != id){
            b = it.next();
        }
        b.desactiva();
    }

    @Override
    public SistemaRefrigeracio mostraSistemaRefrigeracio() {
        return this.sistemaRefrigeracio;
    }

    @Override
    public float calculaPotencia() {
        return turbina.calculaOutput(generadorVapor.calculaOutput(sistemaRefrigeracio.calculaOutput(reactor.calculaOutput(insercioBarres))));
    }

    @Override
    public float getGuanysAcumulats() {
        return this.guanysAcumulats;
    }

    @Override
    public PaginaEstat mostraEstat() {
        return bitacola.getPaginaEstat();
    }

    @Override
    public Bitacola mostraBitacola() {
        return this.bitacola;
    }

    @Override
    public List<PaginaIncidencies> mostraIncidencies() {
        return this.bitacola.getIncidencies();
    }


    /**
     * Actualitza l'economia de la central. Genera una pàgina econòmica a 
     * partir de la demanda de potencia actual. Aquesta pàgina econòmica inclou 
     * beneficis, penalització per excès de potència, costos operatius y 
     * guanys acumulats.
     * @param demandaPotencia Demanda de potència actual.
     */
    private PaginaEconomica actualitzaEconomia(float demandaPotencia){
        float demandaSatisfeta = (calculaPotencia() / demandaPotencia)*100;

        float beneficis;
        float penalitzacio = 0.0f;
        if(calculaPotencia() > demandaPotencia){
            beneficis =  demandaPotencia;
        }
        else{
            beneficis = calculaPotencia();
        }

        if(calculaPotencia() > demandaPotencia){
            penalitzacio =  PENALITZACIO_EXCES_POTENCIA;
        }

        float costOperatiu = this.reactor.getCostOperatiu() + this.sistemaRefrigeracio.getCostOperatiu() + this.turbina.getCostOperatiu() + this.generadorVapor.getCostOperatiu();
        float guanys = beneficis -penalitzacio- costOperatiu;

        PaginaEconomica aux = new PaginaEconomica(dia, demandaPotencia, getGuanysAcumulats(), demandaSatisfeta, beneficis, penalitzacio, costOperatiu, guanys);
        return aux;
    }

    /**
     * Aquest mètode ha de establir la nova temperatura del reactor.
     */
    private void refrigeraReactor() {
        this.reactor.setTemperatura(Math.max(25,this.reactor.getTemperatura()-this.sistemaRefrigeracio.calculaOutput(this.reactor.calculaOutput(insercioBarres))));
    }

    /**
     * Aquest mètode ha de revisar els components de la central. Si
     * es troben incidències, s'han de registrar en la pàgina d'incidències
     * que es proporciona com a paràmetre d'entrada.
     * @param paginaIncidencies Pàgina d'incidències.
     */
    private void revisaComponents(PaginaIncidencies paginaIncidencies) throws CentralUBException {
          this.reactor.revisa(paginaIncidencies);
          this.sistemaRefrigeracio.revisa(paginaIncidencies);
          this.generadorVapor.revisa(paginaIncidencies);
          this.turbina.revisa(paginaIncidencies);
    }

    public Bitacola finalitzaDia(float demandaPotencia) throws CentralUBException {
        // Actualitza economia
        PaginaEconomica paginaEconomica = actualitzaEconomia(demandaPotencia);

        // Genera pàgina d'estat amb la configuració escollida (la nova pàgina
        // d'estat inclou la nova configuració escollida pel operador abans de
        // refrigerar el reactor)
        PaginaEstat paginaEstat = mostraEstat();

        // Actualitza estat de la central...

        // Refrigera el reactor
        refrigeraReactor();

        // Revisa els components de la central i registra incidències
        PaginaIncidencies paginaIncidencies = new PaginaIncidencies(dia);
        revisaComponents(paginaIncidencies);

        // Incrementa dia
        dia += 1;

        // Guarda pàgines de bitacola
        bitacola.afegeixPagina(paginaEconomica);
        bitacola.afegeixPagina(paginaEstat);
        bitacola.afegeixPagina(paginaIncidencies);

        // Retorna pàgines
        Bitacola bitacolaDia = new Bitacola();
        bitacolaDia.afegeixPagina(paginaEconomica);
        bitacolaDia.afegeixPagina(paginaEstat);
        bitacolaDia.afegeixPagina(paginaIncidencies);
        return bitacolaDia;
    }
}
