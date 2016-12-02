/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.bonus;

import java.awt.Point;

import model.Bonus;
import model.GameModel;
import model.Ship;

/**
 * A bonus that increase the player missiles damages
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class StrongerPlayerBonus extends Bonus {

	private final int DURATION = 2000;
	private Thread effect;
	
	/**
	 * Create the bonus
	 * @param position The position of the bonus when it is drop
	 * @param model The model of the game
	 */
	public StrongerPlayerBonus(Point position, GameModel model) {
		super(position, "assets/bonus-extralife.png", model);
		effect = new Effect();
	}

	@Override
	public void activate() {
		effect.start();
	}
	
	/**
	 * The effect of the bonus
	 */
	private class Effect extends Thread {
		
		@Override
		public void run() {
			Ship player = model.getPlayer();
			float damage = player.getDamage();
			
			player.setDamage(damage*2);
			try {
				Thread.sleep(DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				player.setDamage(damage);
			}
		}
	}
}
