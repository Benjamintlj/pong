package Entities.NonePlayable;


import Display.Display;
import Entities.GameObject;
import Entities.Playable.Paddle;
import Entities.Position;
import Score.Score;
import javafx.util.Pair;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Ball extends GameObject implements BallInterface {

    private Color color;
    private float speedX;
    private float speedY;
    private int radius;

    private int originX;
    private int originY;

    private int maxSpeed;

    public Ball(int x, int y, int width, int height, Color color, int initialSpeed, int maxSpeed) {
        super(x, y, width, height);

        this.color = color;
        this.radius = width/2;
        this.originX = x;
        this.originY = y;

        this.maxSpeed = maxSpeed;

        do {
            this.speedX = initialSpeed * (int)Math.floor(Math.random()*(1-(-1)+1)+-1);
            System.out.println(speedX);
        } while (speedX == 0);

        do {
            this.speedY = initialSpeed * (int)Math.floor(Math.random()*(1-(-1)+1)+-1);
            System.out.println(speedX);
        } while (speedY == 0);
    }

    public void resetLocation() {
        position = new Position(originX, originY);
    }

    public void update(List<Paddle> playerObjects, Display display) {
        position = new Position(position.getX() - (int) speedX, position.getY() - (int) speedY);

        if (intersectionDetection(playerObjects)) speedX *= -1;
        intersectionOfWallDetection(display);

    }

    public void increaseSpeedX() {
        if (speedX < maxSpeed && speedX > -maxSpeed) {
            speedX *= 1.1;
        }
    }

    public void increaseSpeedY() {
        if (speedY < maxSpeed && speedY > -maxSpeed) {
            speedY *= 1.2;
        }
    }

    private boolean intersectionDetection(List<Paddle> playerObjects) {

        // need to get centers
        int centerX = position.getX();
        int centerY = position.getY();


        for (Paddle playerObject : playerObjects) {
            if (centerX + size.getWidth() > playerObject.getPosition().getX()) {
                if (centerX < (playerObject.getPosition().getX() + playerObject.getSize().getWidth())) {
                    if (centerY + size.getWidth() > playerObject.getPosition().getY()) {
                        if (centerY < playerObject.getPosition().getY() + playerObject.getSize().getHeight()) {
                            return true;
                        }
                    }
                }
            }
        };
        return false;
    }

    private void intersectionOfWallDetection(Display display) {
        if (position.getY() < 0 || position.getY() > display.getHeight() - 40) {
            speedY *= -1;
            increaseSpeedY();
        }

        if (position.getX() < 0) {
            Score.increasePlayer2Score();
            System.out.println(Score.getPlayer1Score() + " " + Score.getPlayer2Score());
            speedX *= -1;
            resetLocation();
            increaseSpeedX();
        }

        if (position.getX() > display.getWidth() - size.getWidth()) {
            Score.increasePlayer1Score();
            System.out.println(Score.getPlayer1Score() + " " + Score.getPlayer2Score());
            speedX *= -1;
            resetLocation();
            increaseSpeedX();
        }
    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(color);
        graphics.fillRoundRect(0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        //graphics.fillRect(0, 0, size.getWidth(), size.getHeight());

        graphics.dispose();
        return image;
    }
}
