package Entities.Playable;

import Controller.Controller;
import Entities.GameObject;
import Entities.Position;
import Controller.Input;
import Controller.PlayerController;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Paddle extends GameObject {


    protected Controller controller;
    protected final int speed;
    protected Color color;

    public Paddle(Input input, int x, int y, int width, int height, int speed, Color color) {
        super(x, y, width, height);
        this.controller = new PlayerController(input);
        this.speed = speed;
        this.color = color;
    }

    public void update() { }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(color);
        graphics.fillRect(0, 0, size.getWidth(), size.getHeight());

        graphics.dispose();
        return image;
    }
}
