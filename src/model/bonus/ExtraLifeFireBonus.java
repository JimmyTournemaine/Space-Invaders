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
public class ExtraLifeFireBonus extends Bonus {

	final private int LIFE = 1;
	final private int Fire = 30;

	public ExtraLifeFireBonus(Point position, GameModel model) {
		super(position, "assets/bonus-red.png", model);
	}

	@Override
	public void activate() {
		PlayerShip p = model.getPlayer();
		p.addLife(LIFE);
		p.addFire(Fire);
	}

}
