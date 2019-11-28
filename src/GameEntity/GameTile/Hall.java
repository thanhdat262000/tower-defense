package GameEntity.GameTile;

import javax.swing.*;
import java.awt.*;

public class Hall implements Tile{
    private int x = 28*32;
    private int y = 18*32;
    private int w = 32*4;
    private int h = 32*4;
    private Image image;
    public Hall() {
        Init();
    }
    private void Init() {
        loadImage("Graphics/Tile/Hall.png");
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
