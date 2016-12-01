package model.bonus;

import java.awt.Point;

import model.AliveObject;
import model.GameModel;
import model.invader.Invader;

public class BonusInvader extends Invader {

	public BonusInvader(Point pos, String imageName, float life, float damage) {
		super(pos, imageName, life, damage);
	}
	
	public void takeDamageFrom(AliveObject ao) {
		super.takeDamageFrom(ao);
		
		if(isDead()) {
			Bonus b = BonusGenerator.generate(this);

			System.out.println(b);
			if(b!=null) {
				GameModel.bonus.add(b);
			}
		}
	}

}
