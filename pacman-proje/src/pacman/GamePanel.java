package pacman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Oyun alanı: çizim, oyun döngüsü ve klavye.
 *
 * Sorumlular:
 *   Meriç Kavuncuoğlu -> panel kurulumu, oyun döngüsü (Timer), paintComponent
 *   Egemen Çavuş      -> klavye dinleyicisi (KeyAdapter), panele odak verme
 *   Kaan Avşar        -> skorun ekrana yazılması, oyun bitti mesajı
 */
public class GamePanel extends JPanel implements ActionListener {

    // 1. hafta: "labirent pencereye oturmuyor" sorunu -> hücre boyutu sabitlendi
    public static final int TILE_SIZE = 32;
    private static final int SCORE_BAR = 40;

    private final Maze maze;
    private final Pacman pacman;
    private final ScoreManager scoreManager;
    private final Timer timer;

    // ---------- Meriç: kurulum ----------
    public GamePanel() {
        maze = new Maze();
        pacman = new Pacman(7, 9); // haritadaki 2 olan kare
        scoreManager = new ScoreManager();
        scoreManager.placeFoods(maze);

        setPreferredSize(new Dimension(maze.getCols() * TILE_SIZE,
                                       maze.getRows() * TILE_SIZE + SCORE_BAR));
        setBackground(Color.BLACK);

        setupKeyboard();

        timer = new Timer(150, this); // her 150 ms'de bir oyun güncellenir
        timer.start();
    }

    // ---------- Egemen: klavye ----------
    private void setupKeyboard() {
        // 1. hafta: "tuşlar çalışmıyor" sorunu -> panele odak verildi
        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:    pacman.setDirection(-1, 0); break;
                    case KeyEvent.VK_DOWN:  pacman.setDirection(1, 0);  break;
                    case KeyEvent.VK_LEFT:  pacman.setDirection(0, -1); break;
                    case KeyEvent.VK_RIGHT: pacman.setDirection(0, 1);  break;
                    default: break;
                }
            }
        });
    }

    // ---------- Meriç: oyun döngüsü ----------
    @Override
    public void actionPerformed(ActionEvent e) {
        pacman.move(maze);                 // Meriç + Egemen
        scoreManager.checkFood(pacman);    // Kaan
        if (scoreManager.allFoodsEaten()) {
            timer.stop();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        maze.draw(g, TILE_SIZE);                       // Arda
        for (Food food : scoreManager.getFoods()) {    // Kaan
            food.draw(g, TILE_SIZE);
        }
        pacman.draw(g, TILE_SIZE);                     // Meriç
        drawScore(g);                                  // Kaan
    }

    // ---------- Kaan: skor ----------
    private void drawScore(Graphics g) {
        int y = maze.getRows() * TILE_SIZE + 27;
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Skor: " + scoreManager.getScore(), 10, y);

        if (scoreManager.allFoodsEaten()) {
            g.setColor(Color.YELLOW);
            g.drawString("Tebrikler, tüm yemler toplandı!", 180, y);
        }
    }
}
