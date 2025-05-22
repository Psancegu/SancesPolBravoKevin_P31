package prog2.vistaGUI;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.*;

public class FrmVisualitzarInformacio extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private Adaptador adaptador;

    public FrmVisualitzarInformacio(Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Visulització de la Informació");
        setContentPane(contentPane);
        setSize(400,300);
        setModal(true);
        setLocationRelativeTo(null);


    }
}
