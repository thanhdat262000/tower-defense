package GameEntity.GameTile.Tower;

import GameEntity.GameTile.Bullet.Bullet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Tower {
    private static int price;
    protected ArrayList<Bullet> bulletList = new ArrayList<>();
    private Image image;
    private int x;
    private int y;
    private int w = 32*2;
    private int h = 32*2;
    private int range;
    public static long speed;
    public void loadImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        image = icon.getImage();
    }
    public Image getImage() {
        return image;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getRange() {
        return range;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getPrice() {
        return price;
    }

    public int getH() {
        return h;
    }
    public void drawTower(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image,getX(),getY(),getW(),getH(),null);
    }

    public ArrayList<Bullet> getBulletList() {
        return bulletList;
    }
    public abstract void fire();
}
