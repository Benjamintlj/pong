package Entities.NonePlayable;

import Display.Display;
import Entities.GameObject;
import Entities.Playable.Paddle;

import java.util.List;

public interface BallInterface {

    public void update(List<Paddle> nonePlayerObject, Display display);

}
