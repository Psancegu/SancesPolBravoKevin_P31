package prog2.vistaGUI;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVisualitzarInformacio extends JDialog {
    private JPanel contentPane;
    private JButton btnTornar;
    private JComboBox cmboxOpcionsVisualitzar;
    private JButton btnVisualitzar;
    private JScrollPane paneMostrar;
    private JTextArea txtMostrar;
    private Adaptador adaptador;

    public FrmVisualitzarInformacio(Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Visulització de la Informació");
        setContentPane(contentPane);
        setSize(400,300);
        setModal(true);
        setLocationRelativeTo(null);
        txtMostrar.setEditable(false);
        txtMostrar.setLineWrap(true);
        txtMostrar.setWrapStyleWord(true);


        btnTornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnVisualitzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccio = cmboxOpcionsVisualitzar.getSelectedItem().toString();

                switch (seleccio) {
                    case "Estat de la Central":
                        txtMostrar.setText(FrmVisualitzarInformacio.this.adaptador.mostrarEstat());
                        break;
                    case "Quadern de Bitàcola":
                        txtMostrar.setText(FrmVisualitzarInformacio.this.adaptador.mostrarBitacola());
                        break;
                    case "Incidències":
                        txtMostrar.setText(FrmVisualitzarInformacio.this.adaptador.mostrarIncidencies());
                        break;
                }
                txtMostrar.setCaretPosition(0);
            }
        });
    }
}
