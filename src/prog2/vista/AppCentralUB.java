package prog2.vista;

import javax.swing.*;
import java.awt.*;

public class AppCentralUB extends JFrame {
    public AppCentralUB() {
        super("Central UB");

        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFitxer = new JMenu("Fitxer");
        JMenuItem sortirItem = new JMenuItem("Sortir");
        sortirItem.addActionListener(e -> System.exit(0));
        menuFitxer.add(sortirItem);
        menuBar.add(menuFitxer);
        setJMenuBar(menuBar);

        // Panells per a la disposició BorderLayout
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 20, 20));

        // Crear botons per obrir noves finestres
        JButton boto1 = new JButton("Pàgina 1");
        JButton boto2 = new JButton("Pàgina 2");
        JButton boto3 = new JButton("Pàgina 3");
        JButton boto4 = new JButton("Pàgina 4");

        boto1.addActionListener(e -> new PaginaNova("Pàgina 1"));
        boto2.addActionListener(e -> new PaginaNova("Pàgina 2"));
        boto3.addActionListener(e -> new PaginaNova("Pàgina 3"));
        boto4.addActionListener(e -> new PaginaNova("Pàgina 4"));

        centerPanel.add(boto1);
        centerPanel.add(boto2);
        centerPanel.add(boto3);
        centerPanel.add(boto4);

        // Assignar els panells a les regions
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    // Classe per crear finestres noves
    private static class PaginaNova extends JFrame {
        public PaginaNova(String titol) {
            super(titol);
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            add(new JLabel("Benvingut a " + titol, SwingConstants.CENTER), BorderLayout.CENTER);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCentralUB gui = new AppCentralUB();
            gui.setVisible(true);
        });
    }
}
