package GameEntity.GameTile;

import javax.swing.*;
import java.awt.*;

public class Mountain implements Tile {
    private int x;
    private int y;
    private int w = 32*2;
    private int h = 32*2;
    private Image image;
    public Mountain() {
        Init();
    }
    private void Init() {
        loadImage("Graphics/Tile/Tree.png");
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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
