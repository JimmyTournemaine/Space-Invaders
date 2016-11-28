package model;

import java.awt.Image;
import java.io.IOException;

public abstract class Ship {
	protected Position position;
	protected float damage;
	protected float life;
	protected Map myMap;
	
	public abstract boolean moveLeftOk();
	public abstract boolean moveRightOk();
	public abstract boolean moveUpOk();
	public abstract boolean moveDownOk();
	
	public Ship (Map myMap){
		this.myMap = myMap;
	}
	
	public Ship (Map myMap, Position pos){
		this.myMap = myMap;
		this.position = pos;
	}
	
	public void moveUp(){
		position.updateY(position.getY() + 1);
	}
	
	public void moveDown(){
		position.updateY(position.getY() - 1);
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

}
