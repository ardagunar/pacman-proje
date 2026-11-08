package pacman;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Pac-Man'in topladığı yem. GameObject'ten kalıtım alır.
 *
 * Sorumlu: Kaan Avşar (yem sınıfı, yemlerin ekranda görünmesi)
 */
public class Food extends GameObject {

    public static final int POINTS = 10;

    private boolean eaten = false;

    public Food(int row, int col) {
        super(row, col);
    }

    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    @Override
    public void draw(Graphics g, int tileSize) {
        if (eaten) {
            return; // toplanan yem ekrandan kaybolur
        }
        g.setColor(new Color(255, 184, 151));
        int dot = tileSize / 5;
        int x = col * tileSize + (tileSize - dot) / 2;
        int y = row * tileSize + (tileSize - dot) / 2;
        g.fillOval(x, y, dot, dot);
    }
}
