import GameEntity.GameTile.Tile;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GameConfig {
    private Image money ;
    private Image hall;
    private int gold  ;
    private int health;
    public GameConfig() {
        gold = 100;
        health = 100;
        Init();
    }
    private void Init() {
        ImageIcon icon = new ImageIcon("Graphics/Tile/Money.png");
        money = icon.getImage();
        ImageIcon icon1 = new ImageIcon("Graphics/Tile/Hall.png");
        hall = icon1.getImage();
    }

    public void setGold(int gold) {
        this.gold += gold;
    }

    public int getGold() {
        return gold;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.money, 3*32,20*32, 32,32,null);
        g2d.drawImage(this.hall, 3*32,21*32, 32, 32,null);
        g2d.setFont(new Font("Courier New", Font.BOLD, 25));
        g2d.setColor(new Color(255,255,255));
        g2d.drawString(" " + this.gold, 4*32, 20*32+24);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(4*32+16,21*32+8, health, 16);
    }
    public void BuyTower(int n) {
        this.gold -= n;
    }
    public void Attacked(int n) {
        health -= n;
    }
}
