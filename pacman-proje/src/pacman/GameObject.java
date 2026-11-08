package pacman;

import java.awt.Graphics;

/**
 * Oyundaki tüm nesnelerin (Pacman, Ghost, Food) ortak atası.
 * Soyut sınıf: tek başına nesnesi oluşturulamaz, alt sınıflar draw() metodunu yazmak zorunda.
 *
 * Sorumlu: Meriç Kavuncuoğlu (1. hafta - soyut sınıf taslağı)
 */
public abstract class GameObject {

    // Nesnenin labirentteki konumu (satır, sütun)
    protected int row;
    protected int col;

    public GameObject(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    /** Başka bir nesneyle aynı karede mi? (yem toplama ve hayalet çarpışması için) */
    public boolean isSamePlace(GameObject other) {
        return this.row == other.row && this.col == other.col;
    }

    /** Her alt sınıf kendini farklı çizer (polimorfizm). */
    public abstract void draw(Graphics g, int tileSize);
}
