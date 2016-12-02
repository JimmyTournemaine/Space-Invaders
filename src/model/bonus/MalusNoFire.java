package model.bonus;

import java.awt.Point;

import model.GameModel;

public class MalusNoFire extends Bonus {
	private final int DURATION = 10000;
	private Thread inversing;

	public MalusNoFire(Point position, GameModel model) {
		super(position, "assets/bonus-purple.png", model);
		inversing = new Inversing();

	}

	@Override
	public void activate() {
		inversing.start();
	}

	private class Inversing extends Thread {

		public void run() {
			int nbmissiles = model.getPlayer().getNbMissiles();
			try {
				model.getPlayer().setNbMissiles(0);
				Thread.sleep(DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				model.getPlayer().setNbMissiles(nbmissiles);
			}
		}

	}
}
