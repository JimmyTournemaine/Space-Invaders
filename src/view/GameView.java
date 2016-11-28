package view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import controller.GameController;
import model.GameModel;
import model.Position;
import model.invaders.Invader;

public class GameView extends Canvas implements KeyListener {

	private static final long serialVersionUID = 9171658068315238226L;
	private GameModel model;
	private GameController controller;

	GameView(GameModel model) throws IOException {
		this.model = model;
		this.controller = new GameController(model, this);
	}

	public void paint(Graphics gr) {
		try {
			Graphics2D g = (Graphics2D) gr;
			int caseX = this.getWidth() / GameModel.CELL_WIDTH;
			int caseY = this.getHeight() / GameModel.CELL_HEIGHT;
			
			/* Ship */
			Position p = model.getPlayer().getPosition();
			Position pos = new Position(p.getX() * caseX, this.getHeight() - (p.getY()+1)*(caseY));
			g.drawImage(model.getPlayer().getSprite(), pos.getX(), pos.getY(), this.getWidth() / GameModel.CELL_WIDTH, this.getHeight() / GameModel.CELL_HEIGHT, null);
			
			/* Invaders */
			Iterator<Invader> itor = model.getInvaders().iterator();
			while (itor.hasNext()) {
				Invader inv = itor.next();
				Position p1 = inv.getPosition();
				Position pos1 = new Position(p1.getX() * caseX, this.getHeight() - (p1.getY()+1)*(caseY));
				g.drawImage(inv.getSprite(), pos1.getX(), pos1.getY(), null);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void paintShip(Graphics2D g) throws IOException {

	}

	public void paintInvaders(Graphics2D g, List<Invader> invaders) throws IOException {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// DO NOTHING
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_Q:
			controller.goLeft();
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			controller.goRight();
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_Z:
			controller.goUp();
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			controller.goDown();
			break;
		case KeyEvent.VK_SPACE:
		case KeyEvent.VK_X:
			controller.shoot();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// DO NOTHING
	}
}
