package model.invaders;

import model.GameModel;
import model.Map;
import model.Position;
import model.Ship;

abstract public class Invader extends Ship {

	public Invader(Position pos) {
		super(pos);
	}

	public boolean moveLeftOk() {
		return position.getX() != 0;
	}

	public boolean moveRightOk() {
		return position.getX() != GameModel.CELL_WIDTH-1;
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
