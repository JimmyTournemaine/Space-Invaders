package model.invader;

import java.awt.Point;
import java.util.Random;

public class FightInvader extends Invader {

	public FightInvader(Point pos, String imageName, float life, float damage) {
		super(pos, imageName, life, damage);
		this.nbMissiles = 10;
	}
	
	@Override
	public void move()
	{
		super.move();
		
		Random rn = new Random();
		int r = rn.nextInt(100);
		if (r == 0) {
			this.shoot();
		}
	}
	
}
