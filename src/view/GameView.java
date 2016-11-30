package view;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import model.GameModel;
import model.Invader;
import model.Missile;

public class GameView extends JComponent {

	private static final long serialVersionUID = 9171658068315238226L;
	private GameModel model;

	GameView(GameModel model) {
		this.model = model;
	}

	public void paint(Graphics g) {

		/* Ship */
		model.getPlayer().drawOn(g);

		/* Invaders */
		for (Invader iv : model.getInvaders())
			iv.drawOn(g);

		/* Missiles */
		for (Missile m : model.getMissiles()) {
			m.drawOn(g);
		}
		
		if(App.DEBUG_MODE) {
			Rectangle rec = model.getPlayer().getBounds();
			g.drawRect(rec.x, rec.y, rec.width, rec.height);
			for (Invader iv : model.getInvaders()){
				rec = iv.getBounds();
				g.drawRect(rec.x, rec.y, rec.width, rec.height);
			}
			for (Missile m : model.getMissiles()) {
				rec = m.getBounds();
				g.drawRect(rec.x, rec.y, rec.width, rec.height);
			}
		}
	}

}
