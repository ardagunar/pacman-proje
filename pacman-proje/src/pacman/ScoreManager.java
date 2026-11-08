package pacman;

import java.util.ArrayList;
import java.util.List;

/**
 * Yemlerin yerleştirilmesi, toplanması ve skor sistemi.
 *
 * Sorumlular:
 *   Arda Günar -> placeFoods(): yemlerin labirente yerleşimi
 *   Kaan Avşar -> checkFood() ve skor: 2. haftadaki "yem yenmiyor, skor sabit" hatasının çözümü
 */
public class ScoreManager {

    private final List<Food> foods = new ArrayList<>();
    private int score = 0;

    // ---------- Arda: yem yerleşimi ----------
    /** Haritada yol (0) olan her kareye bir yem koyar. */
    public void placeFoods(Maze maze) {
        foods.clear();
        for (int r = 0; r < maze.getRows(); r++) {
            for (int c = 0; c < maze.getCols(); c++) {
                if (maze.getCell(r, c) == Maze.PATH) {
                    foods.add(new Food(r, c));
                }
            }
        }
    }

    // ---------- Kaan: yem toplama + skor ----------
    /**
     * Hatanın sebebi: Pac-Man'in konumu ile yemin konumu karşılaştırılmıyordu.
     * Çözüm: her hareketten sonra aynı karede yenmemiş yem var mı diye bakılır.
     */
    public void checkFood(Pacman pacman) {
        for (Food food : foods) {
            if (!food.isEaten() && pacman.isSamePlace(food)) {
                food.setEaten(true);
                score += Food.POINTS;
            }
        }
    }

    public boolean allFoodsEaten() {
        for (Food food : foods) {
            if (!food.isEaten()) {
                return false;
            }
        }
        return true;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public int getScore() {
        return score;
    }
}
