package model;

import java.awt.Image;
import java.io.IOException;

public abstract class Ship extends AnimatedObject {
	
	public abstract boolean moveLeftOk();
	public abstract boolean moveRightOk();
	public abstract boolean moveUpOk();
	public abstract boolean moveDownOk();
	
	public Ship (Position pos){
		super(pos);
	}
	
	public void moveLeft(){
		position.updateX(position.getX() - 1);
	}
	
	public void moveRight(){
		position.updateX(position.getX() + 1);
	}
	
	public Position getPosition() {
		return position;
	}
	
	abstract public Image getSprite() throws IOException;
	
	abstract public Missile shoot();
}
