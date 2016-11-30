package model;

import java.awt.Point;

public abstract class Ship extends AnimatedObject {
	
	protected float shield;
	
	public Ship (Point pos, String imageName, float life, float damage, float shield){
		super(pos, imageName, life, damage);
		this.shield = shield;
	}
	
	abstract public Missile shoot();
	
	public void dx(int dx) {
		this.direction.x = dx;
	}
	
	public void dy(int dy) {
		this.direction.y = dy;
	}
}
