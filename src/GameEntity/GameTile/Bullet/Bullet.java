package GameEntity.GameTile.Bullet;

import GameEntity.GameTile.Tile;
import GameEntity.GameTile.Tower.Tower;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Bullet implements Tile {
    private Image image;
    private int speed = 2;
    private int w;
    private int h;
    private int x;
    private int y;
    private int damage;
    private Boolean isVisible;

    public Bullet() {
        isVisible = true;
    }

    @Override
    public void loadImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        image = icon.getImage();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public Image getImage() {
        return image;
    }

    public void move(int x, int y) {
       int dx = x - this.x;
        int dy = y - this.y;
        int k = Math.min(Math.abs(dx), Math.abs(dy));
        //double h = 0.03/(int) Math.sqrt(Math.pow(x-this.x,2)+Math.pow(y-this.y,2));
        if (k!= 0) {
            dx /= k;
            dy /= k;
            if (dx >3 || dy > 3) speed =1;
            this.x += speed * dx;
            this.y += speed * dy;

        } else {
            this.x+=(speed*dx)/(dx+dy);
            this.x+=(speed*dy)/(dx+dy);
        }
    }
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (isVisible == true) {
            g2d.drawImage(getImage(), getX(), getY(), getW(), getH(), null);
        }
    }
    public Rectangle getBounds() {
        return new Rectangle(x+w/4, y + h/4, w, h);
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }

    public Boolean getVisible() {
        return isVisible;
    }
}
