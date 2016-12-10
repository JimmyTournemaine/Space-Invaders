/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.bonus;

import java.awt.Point;

import model.Bonus;
import model.GameModel;
import model.PlayerShip;

public class MalusNoFire extends Bonus {
	private final int DURATION = 10000;
	private Thread inversing;

	public MalusNoFire(Point position, GameModel model) {
		super(position, "assets/bonus-pink.png", model);
		inversing = new Inversing();

	}

	@Override
	public void activate() {
		inversing.start();
	}

	private class Inversing extends Thread {

		public void run() {
			PlayerShip p = model.getPlayer();
			int nbmissiles = p.getNbMissiles();
			try {
				p.setNbMissiles(0);
				Thread.sleep(DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				p.setNbMissiles(nbmissiles);
			}
		}

	}
}
