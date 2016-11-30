package model;

import java.awt.Point;

public class Invader extends Ship {

	public Invader(Point pos, String imageName, float life, float damage, int shield) {
		super(pos, imageName, life, damage, shield);
		this.direction = new Point(-1,0);
	}

	@Override
	public Missile shoot() {
		return MissileFactory.createBasicMissile(position);
	}

	@Override
	public void move() {
		position.translate(direction.x, direction.y);
	}
	
	
}
