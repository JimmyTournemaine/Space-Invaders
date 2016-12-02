/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.bonus;

import java.awt.Point;
import java.util.Random;

import model.AnimatedObject;
import model.GameModel;

/**
 * Generate (or not) a random bonus
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class BonusGenerator {

	private static final int LUCK = 1;
	private static final Class<?>[] bonus = { 
			model.bonus.ExtraLifeFireBonus.class,
			model.bonus.StrongerPlayerBonus.class,
			model.bonus.BonusGunLaser.class,
			model.bonus.BonusMachineGun.class,};

	private static GameModel model;

	public static void setModel(GameModel m) {
		model = m;
	}

	/**
	 * Generate (or not) a bonus
	 * @param ao The object that drop the bonus
	 * @return The bonus or null
	 */
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
						.newInstance(ao.getPosition(), model);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return b;
	}
}
