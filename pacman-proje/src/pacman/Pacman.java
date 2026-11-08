package pacman;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Oyuncunun kontrol ettiği karakter. GameObject'ten kalıtım alır.
 *
 * Sorumlular:
 *   Meriç Kavuncuoğlu  -> sınıf iskeleti, yön (direction) yapısı, draw()
 *   Egemen Çavuş       -> move() içindeki duvar çarpışma kontrolü (canMove)
 */
public class Pacman extends GameObject {

    // ---------- Meriç: yön yapısı ----------
    // dRow / dCol: basılan tuşa göre bir sonraki karenin farkı
    private int dRow = 0;
    private int dCol = 0;

    public Pacman(int row, int col) {
        super(row, col);
    }

    /** Basılan tuşa göre yönü ayarlar (GamePanel çağırır). */
    public void setDirection(int dRow, int dCol) {
        this.dRow = dRow;
        this.dCol = dCol;
    }

    // ---------- Egemen: duvar çarpışması ----------
    /**
     * 1. haftadaki "Pac-Man duvarın içinden geçiyor" hatasının çözümü:
     * Hareket etmeden ÖNCE gidilecek kareye bakılır, duvarsa hareket edilmez.
     */
    public boolean canMove(Maze maze, int nextRow, int nextCol) {
        return !maze.isWall(nextRow, nextCol);
    }

    public void move(Maze maze) {
        int nextRow = row + dRow;
        int nextCol = col + dCol;
        if (canMove(maze, nextRow, nextCol)) {
            row = nextRow;
            col = nextCol;
        }
        // Duvarsa olduğu yerde kalır.
    }

    // ---------- Meriç: çizim ----------
    @Override
    public void draw(Graphics g, int tileSize) {
        g.setColor(Color.YELLOW);
        int x = col * tileSize + 2;
        int y = row * tileSize + 2;
        int size = tileSize - 4;

        // Ağzın baktığı yön
        int startAngle = 30;
        if (dCol == -1) startAngle = 210;      // sol
        else if (dRow == -1) startAngle = 120; // yukarı
        else if (dRow == 1) startAngle = 300;  // aşağı

        g.fillArc(x, y, size, size, startAngle, 300);
    }
}
