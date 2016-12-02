/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.bonus;

import java.awt.Point;

import model.Bonus;
import model.GameModel;
import model.weapon.MissileFactory;

/**
 * Give a laser gun to a player
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class BonusGunLaser extends Bonus {
	private final int DURATION = 10000;
	private Thread lasering;
	public BonusGunLaser(Point position, GameModel model) {
		super(position, "assets/bonus-purple.png", model);
		lasering = new Lasering();
		
	}

	@Override
	public void activate() {
		lasering.start();
	}

private class Lasering extends Thread {
		
		public void run() {
			model.getPlayer().setWeapon(MissileFactory.LASER);
			try {
				Thread.sleep(DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				model.getPlayer().setWeapon(0);
			}
		}
		
	}
}
