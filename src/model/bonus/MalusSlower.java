/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.bonus;

import java.awt.Point;

import model.Bonus;
import model.GameModel;

public class MalusSlower extends Bonus {
	private final int DURATION = 10000;
	private Thread slowing;
	public MalusSlower(Point position, GameModel model) {
		super(position, "assets/bonus-purple.png", model);
		slowing = new Slowing();
		
	}

	@Override
	public void activate() {
		slowing.start();
	}

private class Slowing extends Thread {
		
		public void run() {
			try {
				model.getPlayer().setSpeed(1);
				Thread.sleep(DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				model.getPlayer().setSpeed(5);
			}
		}
		
	}
}
