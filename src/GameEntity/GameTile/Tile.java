package GameEntity.GameTile;

import javax.swing.*;
import java.awt.*;

public interface Tile {
    public abstract void loadImage(String path);
    public abstract Image getImage();
    public abstract void draw(Graphics g);
}
