package GameEntity.GameTile.Tower;

import GameEntity.GameTile.Bullet.Bullet;
import GameEntity.GameTile.Bullet.NormalBullet;

import java.util.ArrayList;
import java.util.List;

public class NormalTower extends Tower {
    public NormalTower() {
        super();
        setX(32*3+16);
        setY(0);
        setRange(4*32);
        setSpeed(1000);
        setPrice(50);
        Init();
    }
    private void Init() {
        loadImage("Graphics/Tower/NormalTower.png");
    }

    @Override
    public void fire() {
        Bullet b =new NormalBullet();
        b.setX(getX()+getW()/2);
        b.setY(getY()+16);
        bulletList.add(b);
    }
}
