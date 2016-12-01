package model.bonus;

import java.awt.Point;

import model.GameModel;

public class ExtraLifeBonus extends Bonus {

	public ExtraLifeBonus(Point position, String imageName, GameModel model) {
		super(position, imageName, model);
	}

	final private int LIFE = 1;
	
	@Override
	public void activate() {
		model.getPlayer().addLife(LIFE);
	}

}
