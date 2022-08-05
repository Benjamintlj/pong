package Game;

import Controller.Input;
import Display.Display;
import Entities.GameObject;
import Entities.NonePlayable.Ball;
import Entities.Playable.LeftPlayer;
import Entities.Playable.Paddle;
import Entities.Playable.RightPlayer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Display display;
    private List<Paddle> playerObjects;
    private List<Ball> nonPlayerObjects;
    private Input input;

    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);

        playerObjects = new ArrayList<>();
        nonPlayerObjects = new ArrayList<>();

        playerObjects.add(new LeftPlayer(input, 0, 0, 6, 50, 2, Color.white));
        playerObjects.add(new RightPlayer(input, display.getWidth() - 6, 0, 6, 50, 2, Color.white));
        nonPlayerObjects.add(new Ball(display.getWidth()/2, display.getHeight()/2, 10, 10, Color.white, 3, 3));
    }

    public void update() {
        playerObjects.forEach(playerObject -> playerObject.update());
        nonPlayerObjects.forEach(nonePlayerObject -> nonePlayerObject.update(playerObjects, display));
    }

    public void render(GameLoop gameLoop) {
        display.render(gameLoop.getGame());
    }

    public List<Paddle> getPlayerObjects() {
        return playerObjects;
    }

    public List<Ball> getNonPlayerObjects() { return nonPlayerObjects; }
}
