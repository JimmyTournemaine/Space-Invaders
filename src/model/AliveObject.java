package model;

import java.awt.Point;

public class AliveObject extends AnimatedObject {

	protected float life;
	protected float damage;
	
	public AliveObject(Point position, String imageName, float life, float damage) {
		super(position, imageName);
		this.life = life;
		this.damage = damage;
	}
	
	public float getLife() {
		return life;
	}

	public void setLife(float life) {
		this.life = life;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public void takeDamageFrom(AliveObject ao) {
		this.life = life - ao.damage;
	}

	public float getDamage() {
		return damage;
	}
	
	public boolean isDead() {
		return life <= 0;
	}

}
