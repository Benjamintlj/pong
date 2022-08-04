package Entities;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;

    public GameObject (int x, int y, int width, int height) {
        position = new Position(x, y);
        size = new Size(width, height);
    }

    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }

}
