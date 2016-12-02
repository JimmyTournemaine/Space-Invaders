/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import model.Bonus;
import model.GameModel;
import model.invader.Invader;
import model.weapon.Missile;

/**
 * The game's view
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class GameView extends JComponent {

	private Image img;
	private static final long serialVersionUID = 9171658068315238226L;
	private GameModel model;

	/**
	 * Create the view based on the given model
	 * 
	 * @param model
	 *            The model
	 */
	GameView(GameModel model) {
		this.model = model;
		ImageIcon ii = new ImageIcon("assets/fond1.jpeg");
		img = ii.getImage();
	}

	/**
	 * Draw the model on the component
	 */
	public void paint(Graphics g) {

		/* Ship */
		g.drawImage(img, 0, 0, GameModel.WIDTH, GameModel.HEIGHT, null);
		model.getPlayer().drawOn(g);

		/* Invaders */
		for (Invader iv : model.getInvaders())
			iv.drawOn(g);

		/* Missiles */
		for (Missile m : model.getMissiles()) {
			m.drawOn(g);
		}

		/* Bonus */
		for (Bonus b : GameModel.bonus) {
			b.drawOn(g);
		}

		/* Display hit boxes */
		if (App.DEBUG_MODE) {
			Rectangle rec = model.getPlayer().getBounds();
			g.drawRect(rec.x, rec.y, rec.width, rec.height);
			for (Invader iv : model.getInvaders()) {
				rec = iv.getBounds();
				g.drawRect(rec.x, rec.y, rec.width, rec.height);
			}
			for (Missile m : model.getMissiles()) {
				rec = m.getBounds();
				g.drawRect(rec.x, rec.y, rec.width, rec.height);
			}
			for (Bonus b : GameModel.bonus) {
				rec = b.getBounds();
				b.drawOn(g);
			}
		}
	}
}
