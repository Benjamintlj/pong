package Entities.Playable;

import Controller.Controller;
import Controller.Input;
import Controller.PlayerController;
import Entities.GameObject;
import Entities.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LeftPlayer extends Paddle {

    public LeftPlayer(Input input, int x, int y, int width, int height, int speed, Color color) {
        super(input, x, y, width, height, speed, color);
    }

    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;

        if(controller.isRequestingW()) deltaY -= speed;
        if(controller.isRequestingS()) deltaY += speed;

        position = new Position(position.getX() + deltaX, position.getY() + deltaY);
    }


}
