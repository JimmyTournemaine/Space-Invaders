package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.GameModel;
import view.GameView;

public class GameController implements KeyListener {

	private GameModel model;
	private GameView view;
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_Q:
			this.goLeft();
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			this.goRight();
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_Z:
			this.goUp();
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			this.goDown();
			break;
		case KeyEvent.VK_SPACE:
		case KeyEvent.VK_X:
			this.shoot();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// DO NOTHING
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// DO NOTHING
	}

	public GameController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
	}

	public void goLeft() {
		if(model.getPlayer().moveLeftOk()) {
			model.getPlayer().moveLeft();
			view.repaint();
		}
	}

	public void goRight() {
		if(model.getPlayer().moveRightOk()) {
			model.getPlayer().moveRight();
			view.repaint();
		}
	}

	public void goUp() {
		if(model.getPlayer().moveUpOk()) {
			model.getPlayer().moveUp();
			view.repaint();
		}
	}

	public void goDown() {
		if(model.getPlayer().moveDownOk()) {
			model.getPlayer().moveDown();
			view.repaint();
		}
	}

	public void shoot() {

	}

}
