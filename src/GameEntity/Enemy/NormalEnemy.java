package GameEntity.Enemy;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class NormalEnemy extends Enemy{
    private int animation = 0;
    private final int ratio;
    public NormalEnemy() {
        super();
        setPosX(0);
        setPosY(32*4-24);
        setW(32+24);
        setH(32+16);
        setSpeed(1);
        setHp(1500);
        setArmor(50);
        setReward(30);
        setDam(20);
        ratio = hp/(w-16);
        Init();
    }
    private void Init() {
        loadImage("Graphics/Enemy/NormalEnemy/7_enemies_1_walk_00.png");
    }

    @Override
    public void move() {
            for (int i = 0; i < 20; i++) {
                String path = "Graphics/Enemy/NormalEnemy/7_enemies_1_walk_0" + i + ".png";
                ImageIcon icon = new ImageIcon(path);
                Image image1 = icon.getImage();
                if (image1 != this.image && i > animation) {
                    this.image = image1;
                    animation++;
                    break;
                }
            }
            if (animation == 19) animation = 0;
            super.move();
    }

    @Override
    public void drawEnemy(Graphics g) {
        super.drawEnemy(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fillRect(posX,posY,hp/ratio,6);
    }
    /*@Override
     public void die() {
        for (int i=0;i<20;i++) {
            String path = "Graphics/Enemy/NormalEnemy/7_enemies_1_die_0"+i+".png";
            ImageIcon icon = new ImageIcon(path);
            Image image1 = icon.getImage();
            if (image1 != this.image && i  > animation) {
                this.image = image1;
                animation++;
            }
        }
    } */
}

