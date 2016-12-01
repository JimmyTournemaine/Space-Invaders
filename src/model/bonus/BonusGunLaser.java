package model.bonus;

import java.awt.Point;

import model.GameModel;
import model.bonus.Bonus;
import model.weapon.MissileFactory;

public class BonusGunLaser extends Bonus {
	private final int DURATION = 3000;
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
