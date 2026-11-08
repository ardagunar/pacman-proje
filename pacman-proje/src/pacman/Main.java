package pacman;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Programın giriş noktası: oyun penceresini açar.
 *
 * Sorumlu: Meriç Kavuncuoğlu (1. hafta - temel Swing penceresi)
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pac-Man - BLP 203");
            GamePanel panel = new GamePanel();
            frame.add(panel);
            frame.pack();                       // pencere panele tam oturur
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);  // ekranın ortası
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            panel.requestFocusInWindow();
        });
    }
}
