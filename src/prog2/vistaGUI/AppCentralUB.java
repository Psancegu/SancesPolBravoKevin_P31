package prog2.vistaGUI;

import prog2.adaptador.Adaptador;
import prog2.vista.CentralUBException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCentralUB extends JFrame{
    private JPanel panelPrincipal;
    private JLabel lblCentral;
    private JButton btnGestioComponentsCentral;
    private JButton btnVisualitzarInformacio;
    private JButton btnGuardar;
    private JButton btnCarregar;
    private JButton btnFinalitzaDia;

    public AppCentralUB() throws CentralUBException {
        Adaptador adaptador = new Adaptador();
        setTitle("AppCentralUB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setContentPane(panelPrincipal);
        setLocationRelativeTo(null);
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCentralUB app = null;
            try {
                app = new AppCentralUB();
            } catch (CentralUBException e) {
                JOptionPane.showMessageDialog(null, "S'ha produit un error: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            app.setVisible(true);
        });
    }
}
