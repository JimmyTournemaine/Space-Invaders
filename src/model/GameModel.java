package model;

import java.util.*;

import model.invaders.Invader;

public class GameModel extends Observable {
	public final static int CELL_WIDTH = 10;
    public final static int CELL_HEIGHT = 10;
    private boolean right;
    
    private int score;
	private Ship player;
	private List<Invader> invaders;
	
	public GameModel(int level){
		this.player = new PlayerShip(new Position(0,0));
		invaders = Level.create(level);
		right = false;
		score = 0;
	}

	public GameModel() {
		this(1);
	}
	
	public boolean moveInvaders() {
		if (right && this.invadersMoveRightOk()) {
			for (int i = 0; i<invaders.size();i++) invaders.get(i).moveRight();
		} else if (!right && this.invadersMoveLeftOk()) {
			for (int i = 0; i<invaders.size();i++) invaders.get(i).moveLeft();
		} else {
			for (int i = 0; i<invaders.size();i++) invaders.get(i).moveDown();
			right = !right;
			return false;
		}
		return true;
	}

	private boolean invadersMoveRightOk(){
		if (InvadersPos.mostRight(invaders).moveRightOk()) return true;
		return false;
	}
	
	private boolean invadersMoveLeftOk(){
		if (InvadersPos.mostLeft(invaders).moveLeftOk()) return true;
		return false; 
	}

	public Ship getPlayer() {
		return player;
	}

	public List<Invader> getInvaders() {
		return invaders;
	}
	
	public void setScore(int score) {
		this.score = score;
		setChanged();
	}
	
	public int getScore()
	{
		return score;
	}
	
}
