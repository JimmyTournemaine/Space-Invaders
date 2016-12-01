package model.weapon;

import java.awt.Point;

import model.AliveObject;

public class Missile extends AliveObject {
	
	final protected static int SPEED = 2;
	final public static int NORTH = -1;
	final public static int SOUTH = 1;

	public Missile(Point pt, String fileName, int direction, float life, float damage){
		super(pt, fileName, life, damage);
		this.direction = new Point(0, direction);
		this.speed = SPEED;
	}
	
	public Missile(Point pt, String fileName, int direction){
		super(pt, fileName, 1.0f, 1.0f);
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
