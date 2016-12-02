/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.weapon;

import java.awt.Point;

/**
 * A machine gun shoot
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class MachineGun extends Missile{
	protected static int SPEED = 10;
	
	/**
	 * Create a machine gun missile
	 * @param pt The position of the missile
	 * @param fileName The file path
	 * @param direction The direction of the missile
	 */
	public MachineGun(Point pt, String fileName, int direction) {
		super(pt, fileName, direction, Integer.MAX_VALUE, 1f);
		this.speed = SPEED;
	}
}
