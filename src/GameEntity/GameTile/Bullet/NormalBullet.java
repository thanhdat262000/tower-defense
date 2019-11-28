package GameEntity.GameTile.Bullet;

import GameEntity.GameTile.Tile;

import javax.swing.*;
import java.awt.*;

public class NormalBullet extends Bullet{
    public NormalBullet() {
        super();
        setW(12);
        setH(12);
        setSpeed(1);
        setDamage(300);
        Init();
    }
    private void Init() {
        loadImage("Graphics/Bullet/NormalBullet.png");
    }
}
