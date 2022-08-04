package Entities.Playable;

import Controller.Input;
import Entities.Position;

import java.awt.*;

public class RightPlayer extends Paddle {

    public RightPlayer(Input input, int x, int y, int width, int height, int speed, Color color) {
        super(input, x, y, width, height, speed, color);
    }

    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;

        if(controller.isRequestingUp()) deltaY -= speed;
        if(controller.isRequestingDown()) deltaY += speed;

        position = new Position(position.getX() + deltaX, position.getY() + deltaY);
    }


}
