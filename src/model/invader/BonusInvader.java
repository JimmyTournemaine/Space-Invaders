/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.invader;

import java.awt.Point;

import model.AliveObject;
import model.GameModel;
import model.bonus.Bonus;
import model.bonus.BonusGenerator;

/**
 * An invader that can drop bonus
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class BonusInvader extends Invader {

	/**
	 * Create the invader
	 * @param pos The position of the invader
	 * @param imageName The image path for the sprite
	 * @param life Its life
	 * @param damage Its damages
	 * @param speed Its speed
	 */
	public BonusInvader(Point pos, String imageName, float life, float damage, int speed) {
		super(pos, imageName, life, damage, speed);
	}
	
	@Override
	public void takeDamageFrom(AliveObject ao) {
		super.takeDamageFrom(ao);
		
		if(isDead()) {
			Bonus b = BonusGenerator.generate(this);

			if(b!=null) {
				GameModel.bonus.add(b);
			}
		}
	}

}
