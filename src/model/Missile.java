package model;

public class Missile extends AnimatedObject{
	private boolean direction; 
	
	final public static boolean NORTH = true;
	final public static boolean SOUTH = false;
	
	public Missile(Position position, boolean direction){
		super(position);
		this.direction = direction; 
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
	
}
