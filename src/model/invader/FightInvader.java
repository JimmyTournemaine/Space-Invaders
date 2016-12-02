/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.invader;

import java.awt.Point;
import java.util.Random;

/**
 * An invader that can fire
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class FightInvader extends Invader {

	/**
	 * Create a fighter invader
	 * @param pos The position of the invader
	 * @param imageName The image path for the sprite
	 * @param life Its life
	 * @param damage Its damages
	 * @param speed Its speed
	 */
	public FightInvader(Point pos, String imageName, float life, float damage,int speed) {
		super(pos, imageName, life, damage,speed);
		this.setNbMissiles(10);
	}
	
	/**
	 * Move
	 */
	@Override
	public void move()
	{
		super.move();
		
		Random rn = new Random();
		int r = rn.nextInt(100);
		if (r == 0) {
			this.shoot();
		}
	}
	
}
