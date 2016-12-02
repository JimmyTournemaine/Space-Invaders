/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.weapon;

import java.awt.Point;

import model.AliveObject;

/**
 * A missile
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class Missile extends AliveObject {
	
	final protected static int SPEED = 2;
	final public static int NORTH = -1;
	final public static int SOUTH = 1;

	/**
	 * Create a missile
	 * @param pt The position of the missile
	 * @param fileName The image for the sprite
	 * @param direction The direction of the missile (up or down)
	 * @param life The life of a missile
	 * @param damage The missile's damages
	 */
	public Missile(Point pt, String fileName, int direction, float life, float damage){
		super(pt, fileName, life, damage);
		this.direction = new Point(0, direction);
		this.speed = SPEED;
	}
	
	/**
	 * Create a missile
	 * @param pt The position of the missile
	 * @param fileName The image path for the sprite
	 * @param direction The direction of the missile (up or down)
	 */
	public Missile(Point pt, String fileName, int direction){
		super(pt, fileName, 1.0f, 1.0f);
		this.direction = new Point(0, direction);
		this.speed = SPEED;
	}
	
	/**
	 * Get the direction on the y-axis
	 * @return The direction on the y-axis
	 */
	public int dy() {
		return direction.y;
	}

	/**
	 * Looses life on impact
	 */
	public void takeDamage() {
		life -= 1;
	}
}
