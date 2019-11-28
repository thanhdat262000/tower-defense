package GameEntity.GameTile.Tower.TowerButton;

import GameEntity.GameTile.Tower.MachineGunTower;

public class MachineGunTowerButton extends TowerButton {
    public  MachineGunTowerButton() {
        super();
        setPrice(120);
        setX1(10*32);
        setY1(20*32);
        Init();
    }
    private void Init() {
        loadImage("Graphics/Tower/MachineGunTower.png", "Graphics/Tower/Button.png");
    }
}
