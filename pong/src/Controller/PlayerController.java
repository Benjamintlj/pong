package Controller;

import Controller.Controller;

import java.awt.event.KeyEvent;

public class PlayerController implements Controller {

    private Input input;

    public PlayerController(Input input) {
        this.input = input;
    }

    @Override
    public boolean isRequestingUp() {
        return input.isPressed(KeyEvent.VK_UP);
    }

    @Override
    public boolean isRequestingDown() {
        return input.isPressed(KeyEvent.VK_DOWN);
    }

    @Override
    public boolean isRequestingW() {
        return input.isPressed(KeyEvent.VK_W);
    }

    @Override
    public boolean isRequestingS() {
        return input.isPressed(KeyEvent.VK_S);
    }
}
