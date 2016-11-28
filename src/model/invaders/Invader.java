package model.invaders;

import model.Map;
import model.Position;
import model.Ship;

abstract public class Invader extends Ship {

	public Invader(Map myMap, Position pos) {
		super(myMap, pos);
	}

	public boolean moveLeftOk() {
		return position.getX() != 0;
	}

	public boolean moveRightOk() {
		return position.getX() != myMap.limitWidth;
	}

	public boolean moveUpOk() {
		return false;
	}

	public boolean moveDownOk() {
		if (position.getY() == 0)
			return false;
		return true;
	}
}
