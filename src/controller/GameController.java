package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.GameModel;
import view.GameView;

public class GameController implements KeyListener {

	private final int UP = KeyEvent.VK_UP;
	private final int LEFT = KeyEvent.VK_LEFT;
	private final int DOWN = KeyEvent.VK_DOWN;
	private final int RIGHT = KeyEvent.VK_RIGHT;
	private final int SHOOT = KeyEvent.VK_X;

	private GameModel model;
	private GameView view;

	private boolean active = false;

	public GameController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!active)
			return;

		switch (e.getKeyCode()) {
		case LEFT:
			model.getPlayer().dx(-1);
			break;
		case RIGHT:
			model.getPlayer().dx(1);
			break;
		case UP:
			model.getPlayer().dy(-1);
			break;
		case DOWN:
			model.getPlayer().dy(1);
			break;
		case SHOOT:
			model.getPlayer().shoot();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// DO NOTHING
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case LEFT:
		case RIGHT:
			model.getPlayer().dx(0);
			break;
		case UP:
		case DOWN:
			model.getPlayer().dy(0);
			break;
		}
	}

	public void enable() {
		active = true;
	}

	public void disable() {
		active = false;
	}

}
