package GameEntity.GameTile.Bullet;

public class MachineBullet extends Bullet {
    public MachineBullet() {
        super();
        setW(12);
        setH(12);
        setSpeed(1);
        setDamage(200);
        Init();
    }
    private void Init() {
        loadImage("Graphics/Bullet/MachineBullet.png");
    }
}
