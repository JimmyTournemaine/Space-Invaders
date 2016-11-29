package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerShip extends Ship {

	public PlayerShip(Position position) {
		super(position);
	}

	public boolean moveLeftOk(){
		if (position.getX() == 0)
			return false;
		return true;
	}
	
	public boolean moveRightOk(){
		if (position.getX() == GameModel.CELL_WIDTH-1)
			return false;
		return true;
	}
	
	public boolean moveUpOk(){
		if (position.getY() == 5)
			return false;
		return true;
	}
	
	public boolean moveDownOk(){
		if (position.getY()  == 0)
			return false;
		return true;
	}

	@Override
	public Image getSprite() throws IOException {
		return ImageIO.read(new File("assets/playership.png"));
	}
	
	public void setLife(float life) {
		super.setLife(life);
		setChanged();
	}
	
}
