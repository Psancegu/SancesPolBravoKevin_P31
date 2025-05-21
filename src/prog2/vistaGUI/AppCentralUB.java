package prog2.vistaGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCentralUB extends JFrame {
    private JPanel inicio;
    private JButton GestioComponents;
    private JButton VisualitzarInfo;
    private JButton FinalitzarDia;
    private JButton guardaCarregaDades;

    public AppCentralUB() {
        GestioComponents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppCentralUB gui = new AppCentralUB();
                gui.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
