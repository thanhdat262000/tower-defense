package GameEntity.GameTile;

import javax.swing.*;
import java.awt.*;

public class GameFrame implements Tile {
    private int x = 0;
    private int y = 19*31+8;
    private int w = 32*17;
    private int h = 32*5+16;
    private Image image;
    public GameFrame() {
        Init();
    }
    private void Init() {
        loadImage("Graphics/Tile/Frame.png");
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
