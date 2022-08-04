package Display;

import Game.Game;
import Score.Score;

import java.awt.*;

public class Renderer {

    public void render(Game game, Graphics graphics, Display display) {
        game.getPlayerObjects().forEach(playerObject -> graphics.drawImage(
                playerObject.getSprite(),
                playerObject.getPosition().getX(),
                playerObject.getPosition().getY(),
                null
        ));

        game.getNonPlayerObjects().forEach(nonPlayerObject -> graphics.drawImage(
                nonPlayerObject.getSprite(),
                nonPlayerObject.getPosition().getX(),
                nonPlayerObject.getPosition().getY(),
                null
        ));

        graphics.setColor(Color.WHITE);
        graphics.drawString(Score.getPlayer1Score(), 50, 50);
        graphics.drawString(Score.getPlayer2Score(), display.getWidth() - 125, 50);
    }
}
