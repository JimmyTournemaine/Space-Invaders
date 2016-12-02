/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

import java.awt.Point;

/**
 * Represents an alive object (moving, live and damages)
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class AliveObject extends AnimatedObject {

	protected float life;
	protected float damage;
	
	/**
	 * Create the object
	 * @param position The position
	 * @param imageName The file path for the sprite
	 * @param life Its life
	 * @param damage Its damages
	 */
	public AliveObject(Point position, String imageName, float life, float damage) {
		super(position, imageName);
		this.life = life;
		this.damage = damage;
	}
	
	/**
	 * Get the life of the object
	 * @return Its life
	 */
	public float getLife() {
		return life;
	}

	/**
	 * Set the life of the object
	 * @param life The new life's value
	 */
	public void setLife(float life) {
		this.life = life;
	}

	/**
	 * Update the damages
	 * @param damage The value of damages
	 */
	public void setDamage(float damage) {
		this.damage = damage;
	}

	/**
	 * Take damages from another object
	 * @param ao The other object
	 */
	public void takeDamageFrom(AliveObject ao) {
		this.life = life - ao.damage;
	}

	/**
	 * Get the damages
	 * @return Its damages
	 */
	public float getDamage() {
		return damage;
	}
	
	/**
	 * Return a boolean that represents if the object is died or not
	 * @return Died or alive ?
	 */
	public boolean isDead() {
		return life <= 0;
	}

}
