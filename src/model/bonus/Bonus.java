package model.bonus;

import java.awt.Point;

import model.AnimatedObject;
import model.GameModel;

public abstract class Bonus extends AnimatedObject {

	protected GameModel model;
	
	public Bonus(Point position, String imageName, GameModel model) {
		super(position, imageName);
		this.model = model;
		this.direction = new Point(0, 1);
	}
	
	abstract public void activate();
}
