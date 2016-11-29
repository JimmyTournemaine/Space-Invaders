package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JComponent;

import controller.GameController;
import model.GameModel;
import model.Position;
import model.invaders.Invader;

public class GameView extends JComponent {

	private static final long serialVersionUID = 9171658068315238226L;
	private GameModel model;
	private GameController controller;

	GameView(GameModel model) throws IOException {
		this.model = model;
		this.controller = new GameController(model, this);
		this.addKeyListener(this.controller);
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

	
}
