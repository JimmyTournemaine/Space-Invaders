package model.invader;

import java.awt.Point;

import model.AliveObject;

public class ShieldedInvader extends Invader {

	private boolean shield = true;
	
	public ShieldedInvader(Point pos, String imageName, float life, float damage) {
		super(pos, imageName, life, damage);
	}
	
	public void takeDamageFrom(AliveObject ao)
	{
		if(shield) {
			shield = false;
		} else {
			super.takeDamageFrom(ao);
		}
	}

	
	
}
