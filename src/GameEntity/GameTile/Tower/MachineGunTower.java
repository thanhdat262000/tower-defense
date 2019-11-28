package GameEntity.GameTile.Tower;

import GameEntity.GameTile.Bullet.Bullet;
import GameEntity.GameTile.Bullet.MachineBullet;
import GameEntity.GameTile.Bullet.NormalBullet;

public class MachineGunTower extends Tower {
    public MachineGunTower() {
        super();
        setX(32*3+16);
        setY(0);
        setRange(4*32);
        setSpeed(500);
        setPrice(120);
        Init();
    }
    private void Init() {
        loadImage("Graphics/Tower/MachineGunTower.png");
    }

    @Override
    public void fire() {
        Bullet b =new MachineBullet();
        b.setX(getX()+getW()/2);
        b.setY(getY()+16);
        bulletList.add(b);
    }
}
