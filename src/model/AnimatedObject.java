/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

import java.awt.Point;

/**
 * Represents a movable sprite
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public abstract class AnimatedObject extends Sprite {
	
	protected Point direction;
	protected int speed;
	
	public AnimatedObject(Point position, String imageName) {
		super(position);
		this.direction = new Point(0,0);
		this.speed = 1;
		this.loadImage(imageName);
	}
	
	/**
	 * Translate the position by the direction vector
	 */
	public void move() {
		position.translate(direction.x * speed, direction.y * speed);
	}
	
	/**
	 * Check if the object intersect an other object
	 * @param theOther The other object to test the collision
	 * @return boolean
	 */
	public boolean intersect(Sprite theOther) {
    	return this.getBounds().intersects(theOther.getBounds());
    }
}
