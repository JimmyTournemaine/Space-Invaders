package model.bonus;

import java.awt.Point;

import model.GameModel;

public class ExtraLifeBonus extends Bonus {

	final private int LIFE = 1;
	
	public ExtraLifeBonus(Point position, GameModel model) {
		super(position, "assets/bonus-red.png", model);
	}
	
	@Override
	public void activate() {
		model.getPlayer().addLife(LIFE);
	}

}
