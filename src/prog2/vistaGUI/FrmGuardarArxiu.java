package prog2.vistaGUI;

import prog2.adaptador.Adaptador;
import prog2.vista.CentralUBException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrmGuardarArxiu extends JDialog {
    private JPanel contentPane;
    private JButton btnTornar;
    private JTextField txtRuta;
    private JButton btnGuardar;
    private JButton btnCarregar;
    private JButton btnSeleccionar;

    private Adaptador adaptador;

    public FrmGuardarArxiu(Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Visulització de la Informació");
        setContentPane(contentPane);
        setSize(400,300);
        setModal(true);
        setLocationRelativeTo(null);



        btnTornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FrmGuardarArxiu.this.adaptador.guardarDades(txtRuta.getText());
                } catch (CentralUBException ex) {
                    JOptionPane.showMessageDialog(null, "S'ha produit un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "S'ha guardat correctament!", "Informació", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FrmGuardarArxiu.this.adaptador.carregarDades(txtRuta.getText());
                } catch (CentralUBException ex) {
                    JOptionPane.showMessageDialog(null, "S'ha produit un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "S'ha carregat correctament!", "Informació", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fitxer;
                JFileChooser seleccio = new JFileChooser();
                int resultat = seleccio.showOpenDialog(FrmGuardarArxiu.this);
                if (resultat == JFileChooser.APPROVE_OPTION) {
                    fitxer=seleccio.getSelectedFile();
                    txtRuta.setText(fitxer.toString());
                }
            }
        });
    }
}
