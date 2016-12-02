package model.bonus;

import java.awt.Point;
import java.util.Random;

import model.AnimatedObject;
import model.GameModel;

public class BonusGenerator {

	private static final int LUCK = 2;
	private static final Class<?>[] bonus = { 
			model.bonus.ExtraLifeFireBonus.class,
			model.bonus.StrongerPlayerBonus.class,
			model.bonus.BonusGunLaser.class,
			model.bonus.BonusMachineGun.class,
			model.bonus.MalusNoFire.class,
			model.bonus.MalusSlower.class,};

	private static GameModel model;

	public static void setModel(GameModel m) {
		model = m;
	}

	public static Bonus generate(AnimatedObject ao) {
		if (model == null)
			throw new RuntimeException();

		Random rdm = new Random();
		Bonus b = null;
		if (rdm.nextInt() % LUCK == 0) {
			/* It drops a bonus */
			try {
				b = (Bonus) bonus[Math.abs(rdm.nextInt()) % bonus.length]
						.getConstructor(Point.class, GameModel.class)
						.newInstance(ao.getPosition().clone(), model);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return b;
	}
}
