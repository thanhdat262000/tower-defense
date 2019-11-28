package GameEntity.GameTile;

import javax.swing.*;
import java.awt.*;

public class GamePlay implements Tile {
    private int x = 9*32+16;
    private int y = 8*32;
    private int w = 32*12;
    private int h = 32*8;
    private Image image;
    public GamePlay() {
        Init();
    }
    private void Init() {
        loadImage("Graphics/Tile/GameOver.png");
    }

    @Override
    public void loadImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        image = icon.getImage();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, x, y, w, h, null);
        Toolkit.getDefaultToolkit().sync();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
}
