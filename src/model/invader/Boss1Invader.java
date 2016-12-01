package model.invader;

import java.awt.Point;
import java.util.Random;

import model.AliveObject;
import model.GameModel;
import model.weapon.MissileFactory;

public class Boss1Invader extends FightInvader {

	private final int SPEED = 3;
	
	public Boss1Invader() {
		super(new Point(10,10), "assets/boss1.png", 100f, 2.0f);
		this.speed = SPEED;
	}
	
	public void move() {
		super.move();
		
		if(this.getBounds().getMinX() <= 10)
			direction.x = 1;
		else if(this.getBounds().getMaxX() >= GameModel.WIDTH-10)
			direction.x = -1;
	}
	
	public void shoot() {
		for(int i=0; i<10; i++) {
			GameModel.missiles.add(MissileFactory.createBasicMissile(new Point(position.x+i*40, position.y)));
		}
	}

}
