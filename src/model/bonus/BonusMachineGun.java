/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.bonus;

import java.awt.Point;

import model.Bonus;
import model.GameModel;

/**
 * Give a machine gun to the player
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class BonusMachineGun extends Bonus {
	private final int DURATION = 10000;
	private Thread machine;

	public BonusMachineGun(Point position, GameModel model) {
		super(position, "assets/bonus-pink.png", model);
		machine = new Machine();
	}

	@Override
	public void activate() {
		machine.start();
	}

	private class Machine extends Thread {

		public void run() {
			model.getPlayer().weapon = 2;
			try {
				Thread.sleep(DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				model.getPlayer().weapon = 0;
			}
		}
	}

}
