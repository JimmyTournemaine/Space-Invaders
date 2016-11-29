package model;

import java.awt.Image;
import java.io.IOException;
import java.util.Observable;

public abstract class Ship extends Observable {
	
	protected Position position;
	protected float damage;
	protected float life;
	
	public abstract boolean moveLeftOk();
	public abstract boolean moveRightOk();
	public abstract boolean moveUpOk();
	public abstract boolean moveDownOk();
	
	public Ship (Position pos){
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

	public void setLife(float life) {
		this.life = life;
	}
	
	public float getLife() {
		return life;
	}
}
