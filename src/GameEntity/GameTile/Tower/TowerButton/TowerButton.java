package GameEntity.GameTile.Tower.TowerButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TowerButton {
    private boolean isGetClicked;
    private int price;
    private int x;
    private int y;
    private int x1;
    private int y1;
    private int w = 64;
    private  int h = 64;
    private Image image;
    private Image button;
    public  TowerButton() {
        isGetClicked = false;
        x=x1;
        y=y1;
    }
    public void loadImage(String path1, String path2) {
        ImageIcon icon= new ImageIcon(path1);
        image = icon.getImage();
        ImageIcon icon1 = new ImageIcon(path2);
        button = icon1.getImage();
    }
    public Image getImage() {
        return image;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, x,y, w,h,null);
        Toolkit.getDefaultToolkit().sync();
    }
    public void MouseMoved(MouseEvent event) {
        x = event.getX()- w/2;
        y = event.getY()-h/2;
    }

    public boolean isGetClicked() {
        return isGetClicked;
    }

    public void setGetClicked(boolean getClicked) {
        isGetClicked = getClicked;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void drawButton(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.button, x1-16, y1-16,32*3,32*3,null);
        g2d.drawImage(this.image, x1,y1, w,h,null);
        g2d.setFont(new Font("Courier New", Font.BOLD, 25));
        g2d.setColor(new Color(255,255,255));
        g2d.drawString(String.valueOf(price), x1+16, y1+32*2+24);
        Toolkit.getDefaultToolkit().sync();
    }
}
