package model;

import java.awt.Point;

public abstract class AnimatedObject extends Sprite {
	
	protected Point direction;
	protected int speed;
	
	public AnimatedObject(Point position, String imageName) {
		super(position);
		this.direction = new Point(0,0);
		this.speed = 1;
		this.loadImage(imageName);
	}
	
	public void move() {
		position.translate(direction.x * speed, direction.y * speed);
	}
	
	public boolean intersect(Sprite theOther) {
    	return this.getBounds().intersects(theOther.getBounds());
    }
}
