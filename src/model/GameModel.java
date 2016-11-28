package model;

import java.util.*;

import model.invaders.Invader;

public class GameModel {
	public final static int CELL_WIDTH = 10;
    public final static int CELL_HEIGHT = 10;
    public boolean right;
    
	Map map;
	Ship player;
	List<Invader> invaders;
	
	public GameModel(int level){
		this.map = new Map(CELL_WIDTH,CELL_HEIGHT);
		this.player = new PlayerShip(this.map, new Position(0,0));
		invaders = Actions.create(level, map);
		right = false;
		
	}

	public GameModel() {
		this(1);
	}
	
	public void moveInvaders() {
		if (right && this.invadersMoveRightOk()) {
			this.invadersMoveRight();
		} else if (!right && this.invadersMoveLeftOk()) {
			this.invadersMoveLeft();
		} else {
			this.invadersMoveDown();
			right = !right;
		}
	}

	private boolean invadersMoveRightOk(){
		if (Actions.mostRight(invaders).moveRightOk()) return true;
		return false;
	}
	
	private boolean invadersMoveLeftOk(){
		if (Actions.mostLeft(invaders).moveLeftOk()) return true;
		return false;
	}
	
	private void invadersMoveRight(){
		for (int i = 0; i<invaders.size();i++) invaders.get(i).moveRight();		
	}
	
	private void invadersMoveLeft(){
		for (int i = 0; i<invaders.size();i++) invaders.get(i).moveLeft();		
	}
	
	private void invadersMoveDown(){
		for (int i = 0; i<invaders.size();i++) invaders.get(i).moveDown();		
	}
	
	public boolean playerMoveRightOk(){
		return player.moveRightOk();
	}
	
	public boolean playerMoveLeftOk(){
		return player.moveLeftOk();
	}
	
	public void playerMoveLeft(){
		player.moveLeft();		
	}
	
	public void playerMoveRight(){
		player.moveRight();		
	}

	public Ship getPlayer() {
		return player;
	}

	public List<Invader> getInvaders() {
		return invaders;
	}
	
	
}
