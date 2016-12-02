/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.GameModel;

/**
 * Catch user events to update the model
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class GameController implements KeyListener {

	private final int UP = KeyEvent.VK_W;
	private final int LEFT = KeyEvent.VK_A;
	private final int DOWN = KeyEvent.VK_S;
	private final int RIGHT = KeyEvent.VK_D;
	private final int SHOOT = KeyEvent.VK_X;

	private GameModel model;

	private boolean active = false;

	/**
	 * Create the controller
	 * @param model The game model
	 */
	public GameController(GameModel model) {
		this.model = model;
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

	/**
	 * Enable the catching of events
	 */
	public void enable() {
		active = true;
	}

	/**
	 * Disable the catching of events
	 */
	public void disable() {
		active = false;
	}

}
