package GameEntity.Enemy;

import javax.swing.*;
import java.awt.*;

public class TinyEnemy extends Enemy {
    private int animation = 0;
    private final int ratio;
    public TinyEnemy() {
        super();
        setPosX(0);
        setPosY(32*4-16);
        setW(32+8);
        setH(32);
        setSpeed(1);
        setHp(1200);
        setArmor(40);
        setReward(20);
        setDam(10);
        ratio = hp/(w-16);
        Init();
    }
    private void Init() {
        loadImage("Graphics/Enemy/TinyEnemy/1_enemies_1_walk_00.png");
    }

    @Override
    public void move() {
        for (int i = 0; i < 20; i++) {
            String path = "Graphics/Enemy/TinyEnemy/1_enemies_1_walk_0" + i + ".png";
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
}
