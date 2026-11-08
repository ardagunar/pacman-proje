package pacman;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Labirent: 2 boyutlu dizi olarak tutulur.
 *   1 = duvar, 0 = yol (yem konulur), 2 = boş yol (yem yok, ör. Pac-Man başlangıcı)
 *
 * Sorumlu: Arda Günar (labirent tasarımı, 2D dizi, duvarların çizimi)
 */
public class Maze {

    public static final int WALL = 1;
    public static final int PATH = 0;
    public static final int EMPTY = 2;

    private final int[][] map = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0,1},
        {1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1},
        {1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1},
        {1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
        {1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,1},
        {1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1},
        {1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public int getRows() {
        return map.length;
    }

    public int getCols() {
        return map[0].length;
    }

    public int getCell(int row, int col) {
        return map[row][col];
    }

    /** Verilen kare duvar mı? Harita dışı da duvar sayılır (Pac-Man dışarı kaçmasın). */
    public boolean isWall(int row, int col) {
        if (row < 0 || row >= getRows() || col < 0 || col >= getCols()) {
            return true;
        }
        return map[row][col] == WALL;
    }

    /** Duvarları çizer. */
    public void draw(Graphics g, int tileSize) {
        g.setColor(new Color(33, 33, 222));
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                if (map[r][c] == WALL) {
                    g.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
                }
            }
        }
    }
}
