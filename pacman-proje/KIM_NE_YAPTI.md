# Pac-Man (BLP 203) – Kim Ne Yaptı?

Haftalık raporlardaki iş bölümüne göre:
- **Meriç & Egemen:** sınıfların kodlanması, hareket, duvar çarpışması
- **Arda & Kaan:** labirent tasarımı, yemler, skor ve testler

| Kişi | Dosya / Bölüm | Ne yaptı |
|---|---|---|
| **Meriç Kavuncuoğlu** | `GameObject.java` | Soyut ata sınıf (kalıtım yapısı) |
| | `Pacman.java` | Sınıf iskeleti, yön (`setDirection`), `draw()` |
| | `GamePanel.java` | Panel kurulumu, oyun döngüsü (`Timer`, `actionPerformed`), `paintComponent` |
| | `Main.java` | Swing penceresi (JFrame) |
| **Egemen Çavuş** | `Pacman.java` | `canMove()` + `move()` → duvardan geçme hatasının çözümü |
| | `GamePanel.java` | Klavye dinleyicisi (`setupKeyboard`), panele odak verme |
| **Arda Güner** | `Maze.java` | Labirentin 2D dizi olarak tasarımı, `isWall()`, duvar çizimi |
| | `ScoreManager.java` | `placeFoods()` → yemlerin labirente yerleşimi |
| | `GameTest.java` | Duvar / hareket testleri |
| **Kaan Avşar** | `Food.java` | Yem sınıfı, ekranda görünmesi / kaybolması |
| | `ScoreManager.java` | `checkFood()` + skor → yem yenmeme hatasının çözümü |
| | `GamePanel.java` | `drawScore()` – skorun ekrana yazılması |
| | `GameTest.java` | Yem / skor testleri |

Her dosyanın başında ve bölümlerinde `// ---------- İsim: ... ----------` yorumlarıyla kimin kısmı olduğu işaretli.

## Çalıştırma
```
javac -d out src/pacman/*.java
java -cp out pacman.Main       # oyun
java -cp out pacman.GameTest   # testler (4/4 geçiyor)
```

## 3. hafta (raporda planlanan, henüz yok)
`Ghost` sınıfı, hayalet hareketi, Pac-Man–hayalet çarpışması. Öneri: Meriç & Egemen `Ghost` sınıfı ve hareketi, Arda & Kaan çarpışma kontrolü ve testleri.
