package GameEntity.Enemy;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    protected Image image;
    private int dam;
    protected int posX ;
    protected int posY;
    protected int w;
    protected int h;
    protected int hp  ;
    protected int armor;
    public static int reward;
    protected int speed;
    protected boolean isKilled;
    private boolean attack;
    public Enemy() {
        isKilled = false;
        attack = false;
    }
    protected void loadImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        image = icon.getImage();
    }
    public void move() {
        int Y = posY+ h/2;
        int X = posX + w/3;
        if (X < 32*5 && Y == 32*4) posX+=speed;
        else if (X == 32*5 && Y < 32*15+24) posY+=speed;
        else if (Y == 32*15 +24&& X <32*13) posX+=speed;
        else if (X == 32*13&&Y >32*3) posY-=speed;
        else if (Y==32*3&&X< 32*22) posX+=speed;
        else if (X==32*22 && Y < 16*32+24) posY+=speed;
        else if (Y == 16*32+24 && X <24*33) posX+=speed;
        else if (X == 24*33 && Y <20*33) posY+=speed;
        else if (Y == 20*33 && X <29*32) posX+=speed;
        else if (X >= 29*32) {
            isKilled = true;
            attack = true;
        }
        if (hp <=0) {
            isKilled = true;
        }
    }
    public void drawEnemy(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.getImage(),this.getPosX(),this.getPosY(),this.getW(),this.getH(),null);
        Toolkit.getDefaultToolkit().sync();
    }
    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public Image getImage() {
        return image;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getReward() {
        return reward;
    }

    public int getArmor() {
        return armor;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }
    public Rectangle getBounds() {
        return new Rectangle(posX+w/4,posY+h/3,w/4,h/2);
    }
    public void getShot(int dam) {
        hp= hp-dam +armor;
    }
    public boolean isRanged(int x, int y, int range) {
        int dis = (int) Math.sqrt(Math.pow(x-this.posX,2)+Math.pow(y-this.posY,2));
        if (range >= dis) return true;
        else return false;
    }

    public boolean isAttack() {
        return attack;
    }

    public int getDam() {
        return dam;
    }

    public void setDam(int dam) {
        this.dam = dam;
    }
    // public void die() {};
}
