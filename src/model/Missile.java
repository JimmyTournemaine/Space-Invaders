package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Missile extends AnimatedObject{
	private boolean direction; 
	
	final public static boolean NORTH = true;
	final public static boolean SOUTH = false;
	
	public Missile(Position position, boolean direction){
		super(position);
		this.direction = direction; 
	}
	
	public float shot(Ship ship) {
		ship.setLife(ship.getLife() - this.getDamage());
		return ship.getLife();
	}
	
	@Override
	public boolean moveDownOk() {
		return (position.getY() != 0);
	}
	
	@Override
	public boolean moveUpOk() {
		return (position.getY() != GameModel.CELL_HEIGHT-1);
	}
	
	public boolean direction(){
		return direction;
	}
	
	public Image getSprite() throws IOException {
		return ImageIO.read(new File("assets/missiles.jpg"));
	}	
}
