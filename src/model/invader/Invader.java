package model.invader;

import java.awt.Point;

import model.GameModel;
import model.MissileFactory;
import model.Ship;

public class Invader extends Ship {

	public Invader(Point pos, String imageName, float life, float damage) {
		super(pos, imageName, life, damage);
		this.direction = new Point(-1,0);
	}

	@Override
	public void shoot() {
		if(nbMissiles <= 0)
			return;
		
		GameModel.missiles.add(MissileFactory.createBasicMissile(position));
	}

	@Override
	public void move() {
		position.translate(direction.x, direction.y);
	}
	
	
}
