package prog2.vistaGUI;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton introduirInsercióButton;
    private JLabel lblPercentatge;
    private JLabel lblReactor;
    private JLabel lblBombes;
    private Adaptador adaptador;

    public FrmGestioComponentsCentral(Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Gestió Components de la Central");
        setContentPane(contentPane);
        setModal(true);
        setSize(400,300);
        setLocationRelativeTo(null);

        btnAplicarModificacions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelarModificacions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
