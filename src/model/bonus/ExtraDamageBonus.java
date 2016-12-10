/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.bonus;

import java.awt.Point;

import model.Bonus;
import model.GameModel;
import model.PlayerShip;

/**
 * Give extra life(s) to the player
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class ExtraDamageBonus extends Bonus {

	final private float DAMAGE = 2.0f;
	private final int DURATION = 10000;
	private Thread damaging;

	public ExtraDamageBonus(Point position, GameModel model) {
		super(position, "assets/bonus-green.png", model);
		damaging = new Damaging();
	}

	@Override
	public void activate() {
		damaging.start();
	}

	private class Damaging extends Thread {
		public void run() {
			PlayerShip p = model.getPlayer();
			try {
				p.setDamage(DAMAGE);
				Thread.sleep(DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				p.setDamage(1.0f);
			}
		}

	}

}
