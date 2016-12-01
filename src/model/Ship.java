package model;

import java.awt.Point;

public abstract class Ship extends AliveObject {
	
	protected int nbMissiles;
	
	public Ship (Point pos, String imageName, float life, float damage){
		super(pos, imageName, life, damage);
		this.nbMissiles = 0;
	}
	
	abstract public void shoot();
	
	public void dx(int dx) {
		this.direction.x = dx;
	}
	
	public void dy(int dy) {
		this.direction.y = dy;
	}
}
