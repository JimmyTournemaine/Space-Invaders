package model.bonus;

import java.awt.Point;

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
			int playerSpeed= model.getPlayer().getSpeed();
			try {
				model.getPlayer().setSpeed(1);
				Thread.sleep(DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				model.getPlayer().setSpeed(playerSpeed);;
			}
		}
		
	}
}
