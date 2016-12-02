/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

import java.awt.Point;

/**
 * Represents a ship
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public abstract class Ship extends AliveObject {
	
	protected int nbMissiles;
	
	/**
	 * Create the ship
	 * @param pos The position of ship
	 * @param imageName The image for the sprite
	 * @param life The life the ship
	 * @param damage Its damages
	 */
	public Ship (Point pos, String imageName, float life, float damage){
		super(pos, imageName, life, damage);
		this.nbMissiles = 0;
	}
	
	/**
	 * Shoot a missile
	 */
	abstract public void shoot();
	
	/**
	 * Set the direction
	 * @param dx The x direction
	 */
	public void dx(int dx) {
		this.direction.x = dx;
	}
	
	/**
	 * Set the direction
	 * @param dy The y direction
	 */
	public void dy(int dy) {
		this.direction.y = dy;
	}
}
