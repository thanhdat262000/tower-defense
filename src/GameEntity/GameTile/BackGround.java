package GameEntity.GameTile;

import javax.swing.*;
import java.awt.*;

public class BackGround implements Tile{
    private int x = 0;
    private int y = 0;
    private int w = 1024;
    private int h = 800;
    private int x1;
    private int y1;
    private Image predictTower;
    private Image image;
    private boolean isPredicted;
    public BackGround(){
        Init();
    }
    private void Init() {
        loadImage("Graphics/Tile/Ground.png");
        isPredicted = false;
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
        g2d.drawImage(this.image,x,y,w, h,null);
        Toolkit.getDefaultToolkit().sync();
    }
    public void drawPredict(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (this.isPredicted == true) {
            g2d.drawImage(this.predictTower,x1,y1,64,64,null);
        } else return;
    }
    public void IsPredicted(String name) {
        if (name.equals("NormalTower")) {
            ImageIcon icon = new ImageIcon("Graphics/Tower/PredictedNormalTower.png");
            predictTower = icon.getImage();
        }
        if (name.equals("MachineGunTower")) {
            ImageIcon icon = new ImageIcon("Graphics/Tower/PredictedMachineGunTower.png");
            predictTower = icon.getImage();
        }
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setPredicted(boolean predicted) {
        isPredicted = predicted;
    }
}
