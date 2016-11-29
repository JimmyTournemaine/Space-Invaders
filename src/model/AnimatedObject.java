package model;

import java.util.Observable;

public abstract class AnimatedObject extends Observable {
	protected Position position;
	protected float damage;
	
	public abstract boolean moveDownOk();
	public abstract boolean moveUpOk();
	
	public AnimatedObject(Position position) {
		this.position = position;
	}
	
	public void moveUp(){
		position.updateY(position.getY() + 1);
	}
	
	public void moveDown(){
		position.updateY(position.getY() - 1);
	}
	
	public Position getPosition() {
		return this.position;
	}
}
