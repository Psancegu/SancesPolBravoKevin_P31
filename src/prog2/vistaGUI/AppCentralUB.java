package prog2.vistaGUI;

import javax.swing.*;

public class AppCentralUB extends JFrame{
    private JPanel panelPrincipal;
    private JLabel lblCentral;

    public AppCentralUB(){
        setTitle("AppCentralUB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setContentPane(panelPrincipal);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCentralUB app = new AppCentralUB();
            app.setVisible(true);
        });
    }
}
