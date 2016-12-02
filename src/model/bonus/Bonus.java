/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.bonus;

import java.awt.Point;

import model.AnimatedObject;
import model.GameModel;

/**
 * A bonus
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public abstract class Bonus extends AnimatedObject {
	
	protected GameModel model;
	
	/**
	 * Create a bonus
	 * @param position The position of the bonus
	 * @param imageName The image for the sprite
	 * @param model The model
	 */
	public Bonus(Point position, String imageName, GameModel model) {
		super(position, imageName);
		this.model = model;
		this.direction = new Point(0, 1);
	}
	
	/**
	 * Active the bonus' effect
	 */
	abstract public void activate();
}
