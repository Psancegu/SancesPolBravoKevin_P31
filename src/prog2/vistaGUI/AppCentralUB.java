package prog2.vistaGUI;

import prog2.adaptador.Adaptador;
import prog2.vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCentralUB extends JFrame{
    private JPanel panelPrincipal;
    private JLabel lblCentral;
    private JButton btnGestioComponentsCentral;
    private JButton btnVisualitzarInformacio;
    private JButton btnGuardar;
    private JButton btnFinalitzaDia;
    private JLabel lblDia;
    private JLabel lblDemanda;
    private JLabel lblGuanys;
    private VariableNormal variableNormal = new VariableNormal(1000,800,123);
    private float demandaPotencia;
    private Adaptador adaptador = new Adaptador();

    public AppCentralUB() throws CentralUBException {
        setTitle("AppCentralUB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setContentPane(panelPrincipal);
        setLocationRelativeTo(null);
        actualitzaGui(adaptador);
        btnGestioComponentsCentral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioComponentsCentral gestio = new FrmGestioComponentsCentral(adaptador);
                gestio.setVisible(true);
            }
        });
        btnVisualitzarInformacio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVisualitzarInformacio visualitzar = new FrmVisualitzarInformacio(adaptador);
                visualitzar.setVisible(true);
            }
        });
        btnFinalitzaDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    finalitzaDia();
                } catch (CentralUBException ex) {
                    JOptionPane.showMessageDialog(null, "S'ha produit un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGuardarArxiu arxiu = new FrmGuardarArxiu(adaptador);
                arxiu.setVisible(true);
                try {
                    actualitzaGui(adaptador);
                } catch (CentralUBException ex) {
                    JOptionPane.showMessageDialog(null, "S'ha produit un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "S'ha produit un error amb look and feel: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        SwingUtilities.invokeLater(() -> {
            AppCentralUB app = null;
            try {
                app = new AppCentralUB();
            } catch (CentralUBException e) {
                JOptionPane.showMessageDialog(null, "S'ha produit un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            app.setVisible(true);
        });
    }

    public void actualitzaGui(Adaptador adaptador) throws CentralUBException {
        lblDia.setText(adaptador.getDiaGUI());
        lblDemanda.setText("Demanda: " + demandaPotencia + " Unitats de Potencia");
        lblGuanys.setText("Guanys: " + this.adaptador.getGuanys() + "€");
    }

    private float generaDemandaPotencia(){
        float valor = Math.round(variableNormal.seguentValor());
        if (valor > 1800)
            return 1800;
        else if (valor < 250)
            return 250;
        else
            return valor;
    }

    private void finalitzaDia() throws CentralUBException {
        String info = adaptador.finalitzaDia(demandaPotencia);
        actualitzaGui(adaptador);
        demandaPotencia = generaDemandaPotencia();

        JOptionPane.showMessageDialog(null, info, "Dia Finalitzat", JOptionPane.INFORMATION_MESSAGE);
    }
}
