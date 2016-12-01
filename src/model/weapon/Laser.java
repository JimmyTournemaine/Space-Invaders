package model.weapon;

import java.awt.Point;

public class Laser extends Missile {

	protected static int SPEED = 50;
	
	public Laser(Point pt, String fileName, int direction) {
		super(pt, fileName, direction, Integer.MAX_VALUE, 1f);
		this.speed = SPEED;
	}

}
