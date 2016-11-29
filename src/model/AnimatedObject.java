package model;

import java.util.Observable;

public abstract class AnimatedObject extends Observable {
	protected Position position;
	protected float life;
	protected float damage;
	
	public abstract boolean moveDownOk();
	public abstract boolean moveUpOk();
	
	public AnimatedObject(Position position) {
		this.position = position;
		this.life = 1.0f;
		this.damage = 1.0f;
	}
	
	public void moveUp(){
		position.updateY(position.getY() + 1);
	}
	
	public float getLife() {
		return life;
	}
	public void setLife(float life) {
		this.life = life;
		setChanged();
	}
	public float getDamage() {
		return damage;
	}
	public void moveDown(){
		position.updateY(position.getY() - 1);
	}
	
	public Position getPosition() {
		return this.position;
	}
}
