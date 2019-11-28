package GameEntity.Enemy;

import javax.swing.*;
import java.awt.*;

public class TankerEnemy extends Enemy {
    private int animation = 0;
    private final int ratio;
    public TankerEnemy() {
        super();
        setPosX(0);
        setPosY(32*4-28);
        setW(32*2);
        setH(32+16);
        setSpeed(1);
        setHp(2500);
        setArmor(60);
        setReward(60);
        setDam(50);
        ratio = hp/(w-16);
        Init();
    }
    private void Init() {
        loadImage("Graphics/Enemy/TankerEnemy/2_enemies_1_walk_00.png");
    }

    @Override
    public void move() {
        for (int i = 0; i < 20; i++) {
            String path = "Graphics/Enemy/TankerEnemy/2_enemies_1_walk_0" + i + ".png";
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
