package prog2.vistaGUI;

import prog2.adaptador.Adaptador;
import prog2.vista.CentralUBException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class FrmGestioComponentsCentral extends JDialog {
    private JPanel contentPane;
    private JButton btnAplicarModificacions;
    private JButton btnCancelarModificacions;
    private JSlider sldBarresControl;
    private JTextArea txtIntroduirInsercioBarresControl;
    private JCheckBox chkReactor;
    private JCheckBox chkBomba1;
    private JCheckBox chkBomba2;
    private JCheckBox chkBomba3;
    private JCheckBox chkBomba4;
    private JButton introduirInsercioButton;
    private JLabel lblPercentatge;
    private JLabel lblReactor;
    private JLabel lblBombes;
    private JList lstBombes;
    private JButton desactivarTotesButton;
    private JButton activarTotesButton;
    private Adaptador adaptador;

    public FrmGestioComponentsCentral(Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Gestió Components de la Central");
        setContentPane(contentPane);
        setModal(true);
        setSize(675,400);
        setLocationRelativeTo(null);
        actualitzaGUI();

        btnCancelarModificacions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        sldBarresControl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valorSlider = sldBarresControl.getValue();
                txtIntroduirInsercioBarresControl.setText(String.valueOf(valorSlider));
            }
        });

        txtIntroduirInsercioBarresControl.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = txtIntroduirInsercioBarresControl.getText().trim();

                if (text.matches("\\d+")) {
                    int valor = Integer.parseInt(text);
                    if (valor > 100) valor = 100;
                    if (valor < 0) valor = 0;

                    sldBarresControl.setValue(valor);
                }
            }
        });

        introduirInsercioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FrmGestioComponentsCentral.this.adaptador.establirInsercioBarres(sldBarresControl.getValue());
                } catch (CentralUBException ex) {
                    JOptionPane.showMessageDialog(null, "S'ha produit un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAplicarModificacions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    FrmGestioComponentsCentral.this.adaptador.establirInsercioBarres(sldBarresControl.getValue());

                    if (chkReactor.isSelected()) {
                        FrmGestioComponentsCentral.this.adaptador.activarReactor();
                    } else {
                        FrmGestioComponentsCentral.this.adaptador.desactivarReactor();
                    }

                    if (chkBomba1.isSelected()) {
                        FrmGestioComponentsCentral.this.adaptador.activarBomba(0);
                    } else {
                        FrmGestioComponentsCentral.this.adaptador.desactivarBomba(0);
                    }

                    if (chkBomba2.isSelected()) {
                        FrmGestioComponentsCentral.this.adaptador.activarBomba(1);
                    } else {
                        FrmGestioComponentsCentral.this.adaptador.desactivarBomba(1);
                    }

                    if (chkBomba3.isSelected()) {
                        FrmGestioComponentsCentral.this.adaptador.activarBomba(2);
                    } else {
                        FrmGestioComponentsCentral.this.adaptador.desactivarBomba(2);
                    }

                    if (chkBomba4.isSelected()) {
                        FrmGestioComponentsCentral.this.adaptador.activarBomba(3);
                    } else {
                        FrmGestioComponentsCentral.this.adaptador.desactivarBomba(3);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "S'ha produit un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        });
        activarTotesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chkBomba1.setSelected(true);
                chkBomba2.setSelected(true);
                chkBomba3.setSelected(true);
                chkBomba4.setSelected(true);
            }
        });
        desactivarTotesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chkBomba1.setSelected(false);
                chkBomba2.setSelected(false);
                chkBomba3.setSelected(false);
                chkBomba4.setSelected(false);
            }
        });
    }

    public void actualitzaGUI(){
        sldBarresControl.setValue((int) this.adaptador.obtenirInsercioBarres());
        txtIntroduirInsercioBarresControl.setText(String.valueOf(adaptador.obtenirInsercioBarres()));
        chkReactor.setSelected(this.adaptador.getEstatReactorGUI());
        chkBomba1.setSelected(this.adaptador.getBombaGUI(0));
        chkBomba2.setSelected(this.adaptador.getBombaGUI(1));
        chkBomba3.setSelected(this.adaptador.getBombaGUI(2));
        chkBomba4.setSelected(this.adaptador.getBombaGUI(3));

        String estat = this.adaptador.mostrarEstatRefrigeracio();
        String[] elements = estat.split("\n");
        DefaultListModel model = new DefaultListModel();
        model.clear();

        for (String elem : elements) {
            model.addElement(elem); // Agregar cada línea por separado
        }
        lstBombes.setModel(model);
    }
}
