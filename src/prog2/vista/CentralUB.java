/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

import prog2.adaptador.Adaptador;

import java.util.Scanner;

/**
 *
 * @author Daniel Ortiz
 */
public class CentralUB {
    /** Enums per Menús **/
    public enum OpcionsMenuCentralUB {
        GESTIO_BARRES, GESTIO_REACTOR, GESTIO_REFRIGERACIO,
        MOSTRAR_ESTAT_CENTRAL, MOSTRAR_BITACOLA, MOSTRAR_INCIDENCIES,
        OBTENIR_DEMANDA_SATISFETA, FINALITZAR_DIA,
        GUARDAR_DADES, CARREGA_DADES, SORTIR
    }

    public enum OpcionsSubmenuBarres {
        OBTENIR_INSERCIO, ESTABLIR_INSERCIO, SORTIR
    }

    public enum OpcionsSubmenuReactor {
        ACTIVAR, DESACTIVAR, MOSTRAR_ESTAT, SORTIR
    }

    public enum OpcionsSubmenuRefrigeracio {
        ACTIVAR_TOTES, DESACTIVAR_TOTES, ACTIVAR_BOMBA, DESACTIVAR_BOMBA,
        MOSTRAR_ESTAT, SORTIR
    }



    public final static float DEMANDA_MAX = 1800;
    public final static float DEMANDA_MIN = 250;
    public final static float VAR_NORM_MEAN = 1000;
    public final static float VAR_NORM_STD = 800;
    public final static long VAR_NORM_SEED = 123;
    
    /** Generador aleatori de la demanda de potència **/
    private VariableNormal variableNormal;
    
    /** Demanda de potència del dia actual **/
    private float demandaPotencia;

    private Adaptador adaptador;
    
    /* Constructor*/
    public CentralUB() throws CentralUBException {
        variableNormal = new VariableNormal(VAR_NORM_MEAN, VAR_NORM_STD, VAR_NORM_SEED);
        demandaPotencia = generaDemandaPotencia();
        this.adaptador = new Adaptador();
        
        // Afegir codi adicional si fos necessari:

    }

    public void gestioCentralUB() {
        Scanner sc = new Scanner(System.in);
        Menu<OpcionsMenuCentralUB> menu = new Menu<>("Menú Principal", OpcionsMenuCentralUB.values());

        System.out.println("Benvingut a la planta PWR de la UB");
        System.out.println("La demanda de potència elèctrica avui és de " + demandaPotencia + " unitats");

        OpcionsMenuCentralUB opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case GESTIO_BARRES:
                    gestioBarres(sc);
                    break;
                case GESTIO_REACTOR:
                    gestioReactor(sc);
                    break;
                case GESTIO_REFRIGERACIO:
                    gestioRefrigeracio(sc);
                    break;
                case MOSTRAR_ESTAT_CENTRAL:
                    System.out.println(adaptador.mostrarEstat());
                    break;
                case MOSTRAR_BITACOLA:
                    System.out.println(adaptador.mostrarBitacola());
                    break;
                case MOSTRAR_INCIDENCIES:
                    System.out.println(adaptador.mostrarIncidencies());
                    break;
                case OBTENIR_DEMANDA_SATISFETA:
                    System.out.println(adaptador.obtenirDemandaSatisfeta(demandaPotencia));
                    break;
                case FINALITZAR_DIA:
                    try {
                        finalitzaDia();
                    } catch (CentralUBException e) {
                        System.err.println("Error en finalitzar dia: " + e.getMessage());
                    }
                    break;
                case GUARDAR_DADES:
                    adaptador.guardarDades();
                    break;
                case CARREGA_DADES:
                    adaptador.carregarDades();
                    break;
                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while (opcio != OpcionsMenuCentralUB.SORTIR);
    }

    // Submenú 1: Gestió Barres
    private void gestioBarres(Scanner sc) {
        Menu<OpcionsSubmenuBarres> submenu = new Menu<>("Gestió Barres de Control", OpcionsSubmenuBarres.values());
        OpcionsSubmenuBarres opcio;
        do {
            submenu.mostrarMenu();
            opcio = submenu.getOpcio(sc);

            switch (opcio) {
                case OBTENIR_INSERCIO:
                    System.out.println("Inserció actual de les barres: " + adaptador.obtenirInsercioBarres() + "%");
                    break;
                case ESTABLIR_INSERCIO:
                    System.out.print("Entra el grau d'inserció (0-100): ");
                    float insercio = sc.nextFloat();
                    sc.nextLine(); // neteja buffer
                    adaptador.establirInsercioBarres(insercio);
                    break;
                case SORTIR:
                    System.out.println("Tornant al menú principal...");
                    break;
            }
        } while (opcio != OpcionsSubmenuBarres.SORTIR);
    }

    // Submenú 2: Gestió Reactor
    private void gestioReactor(Scanner sc) {
        Menu<OpcionsSubmenuReactor> submenu = new Menu<>("Gestió del Reactor", OpcionsSubmenuReactor.values());
        OpcionsSubmenuReactor opcio;
        do {
            submenu.mostrarMenu();
            opcio = submenu.getOpcio(sc);

            switch (opcio) {
                case ACTIVAR:
                    adaptador.activarReactor();
                    break;
                case DESACTIVAR:
                    adaptador.desactivarReactor();
                    break;
                case MOSTRAR_ESTAT:
                    System.out.println(adaptador.mostrarEstatReactor());
                    break;
                case SORTIR:
                    System.out.println("Tornant al menú principal...");
                    break;
            }
        } while (opcio != OpcionsSubmenuReactor.SORTIR);
    }

    // Submenú 3: Gestió Sistema de Refrigeració
    private void gestioRefrigeracio(Scanner sc) {
        Menu<OpcionsSubmenuRefrigeracio> submenu = new Menu<>("Gestió Sistema de Refrigeració", OpcionsSubmenuRefrigeracio.values());
        OpcionsSubmenuRefrigeracio opcio;
        do {
            submenu.mostrarMenu();
            opcio = submenu.getOpcio(sc);

            switch (opcio) {
                case ACTIVAR_TOTES:
                    adaptador.activarTotesBombes();
                    break;
                case DESACTIVAR_TOTES:
                    adaptador.desactivarTotesBombes();
                    break;
                case ACTIVAR_BOMBA:
                    System.out.print("ID de la bomba (0-3): ");
                    int idAct = sc.nextInt();
                    sc.nextLine();
                    adaptador.activarBomba(idAct);
                    break;
                case DESACTIVAR_BOMBA:
                    System.out.print("ID de la bomba (0-3): ");
                    int idDes = sc.nextInt();
                    sc.nextLine();
                    adaptador.desactivarBomba(idDes);
                    break;
                case MOSTRAR_ESTAT:
                    System.out.println(adaptador.mostrarEstatRefrigeracio());
                    break;
                case SORTIR:
                    System.out.println("Tornant al menú principal...");
                    break;
            }
        } while (opcio != OpcionsSubmenuRefrigeracio.SORTIR);
    }

    private float generaDemandaPotencia(){
        float valor = Math.round(variableNormal.seguentValor());
        if (valor > DEMANDA_MAX)
            return DEMANDA_MAX;
        else
            if (valor < DEMANDA_MIN)
                return DEMANDA_MIN;
            else
                return valor;
    }
    
    private void finalitzaDia() throws CentralUBException {
        // Finalitzar dia i imprimir informacio de la central
        String info = new String();
        info = adaptador.finalitzaDia(demandaPotencia);
        System.out.println(info);
        System.out.println("Dia finalitzat\n");
        
        // Generar i mostrar nova demanda de potencia
        demandaPotencia = generaDemandaPotencia();
        System.out.println("La demanda de potència elèctrica avui es de " + demandaPotencia + " unitats");
    }
}
