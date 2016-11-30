package model;

import java.awt.Point;

public abstract class AnimatedObject extends Sprite {
	
	protected Point direction;
	protected int speed;
	protected float life;
	protected float damage;
	
	public AnimatedObject(Point position, String imageName, float life, float damage) {
		super(position);
		this.direction = new Point(0,0);
		this.life = life;
		this.damage = damage;
		this.speed = 1;
		this.loadImage(imageName);
	}
	
	public void move() {
		position.translate(direction.x * speed, direction.y * speed);
	}

	public float getLife() {
		return life;
	}

	public void takeDamageFrom(AnimatedObject ao) {
		this.life = life - ao.damage;
	}

	public float getDamage() {
		return damage;
	}
	
	public boolean isDead() {
		return life <= 0;
	}
	
	public boolean intersect(Sprite theOther) {
    	return this.getBounds().intersects(theOther.getBounds());
    }
}
