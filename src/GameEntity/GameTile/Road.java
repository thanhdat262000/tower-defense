package GameEntity.GameTile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Road implements Tile{
    private int x;
    private int y;
    private int w = 32;
    private int h = 32;
    private Image image;
    public Road() {
        Init();
    }
    public void Init() {
        loadImage("Graphics/Tile/Road.png");
    }
    public void loadImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        image = icon.getImage();
    }
    public Image getImage() {
        return image;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, x, y, w, h, null);
        Toolkit.getDefaultToolkit().sync();
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
