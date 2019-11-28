package GameEntity.GameTile.Tower.TowerButton;

import GameEntity.GameTile.Tower.NormalTower;
import GameEntity.GameTile.Tower.Tower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class NormalTowerButton extends TowerButton{
    public  NormalTowerButton() {
        super();
        setPrice(50);
        setX1(13*32);
        setY1(20*32);
        Init();
    }
    private void Init() {
        loadImage("Graphics/Tower/NormalTower.png", "Graphics/Tower/Button.png");
    }
}
