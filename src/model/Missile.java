package model;

import java.awt.Point;

public class Missile extends AliveObject {
	
	final public static int SPEED = 2;
	final public static int NORTH = -1;
	final public static int SOUTH = 1;
	
	public Missile(Point pt, int direction){
		super(pt, "assets/missile.png", 1.0f, 1.0f);
		this.direction = new Point(0, direction);
		this.speed = SPEED;
	}
	
	public int dy() {
		return direction.y;
	}

	public void takeDamage() {
		life -= 1;
	}
}
