/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.weapon;

import java.awt.Point;

/**
 * A laser shoot
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class Laser extends Missile {

	protected static int SPEED = 50;
	
	/**
	 * Create a laser "missile"
	 * @param pt The position of the laser
	 * @param fileName The filepath for the sprite
	 * @param direction The direction of the missile
	 */
	public Laser(Point pt, String fileName, int direction) {
		super(pt, fileName, direction, Integer.MAX_VALUE, 1f);
		this.setSpeed(SPEED);
	}

}
