/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.bonus;

import java.awt.Point;

import model.Bonus;
import model.GameModel;

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
	final private int Fire = 20;
	
	public ExtraLifeFireBonus(Point position, GameModel model) {
		super(position, "assets/bonus-red.png", model);
	}
	
	@Override
	public void activate() {
		model.getPlayer().addLife(LIFE);
		model.getPlayer().addFire(Fire);
	}

}
