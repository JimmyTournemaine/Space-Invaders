package model;

import java.util.*;

import model.invaders.Invader;

public class GameModel extends Observable {

	public final static int GAME_RUNNING = 0;
	public final static int GAME_LEVEL_DONE = 1;
	public final static int GAME_OVER = 2;

	public final static int CELL_WIDTH = 10;
	public final static int CELL_HEIGHT = 10;

	private boolean right;
	private int level;
	private int score;
	private Ship player;
	private ArrayList<Invader> invaders;
	private List<Missile> missiles;

	public GameModel() {
		player = new PlayerShip(new Position(0, 0));
		missiles = new ArrayList<Missile>();
		this.newGame();
	}

	public void newGame() {
		right = false;
		level = 1;
		score = 0;
		invaders = Level.create(1);
	}

	public void nextLevel() {
		level++;
		invaders = Level.create(level);
	}

	private void checkMissiles() {
		Iterator<Missile> it = missiles.iterator();
		while(it.hasNext()){
			Missile m = it.next();
			Iterator<Invader> itor = invaders.iterator();
			while(itor.hasNext()) {
				Invader iv = itor.next();
				if(m.getPosition().equals(iv.getPosition())){
					it.remove();
					if(m.shot(iv) <= 0){ // Killed
						itor.remove();
						this.setScore((int) (score+10*(m.getLife()+m.getDamage())/2));
					}
				}
			}
		}
	}

	public int move() {
		/* Move missiles */
		Iterator<Missile> it = missiles.iterator();
		while (it.hasNext()) {
			Missile m = it.next();
			if (m.direction() == Missile.NORTH && m.moveUpOk()) {
				m.moveUp();
			} else if (m.direction() == Missile.SOUTH && m.moveDownOk()) {
				m.moveDown();
			} else {
				it.remove();
			}
		}

		/* Move invaders */
		
		if (right && this.invadersMoveRightOk()) {
			for (Invader inv : invaders)
				inv.moveRight();
		} else if (!right && this.invadersMoveLeftOk()) {
			for (Invader inv : invaders)
				inv.moveLeft();
		} else {
			if (InvadersPos.invadersMoveDownOk(invaders)) {
				for (Invader inv : invaders)
					inv.moveDown();
				right = !right;
			} else
				return GAME_OVER;
		}
		
		/* Collision */
		this.checkMissiles();
		
		Iterator<Invader> it2 = invaders.iterator();
		while(it2.hasNext()) {
			Invader iv = it2.next();
			//System.out.printf("(%d,%d) — (%d,%d)", player.getPosition().getX(), player.getPosition().getY(), iv.getPosition().getX());
			if(iv.getPosition().equals(player.getPosition())) {
				player.setLife(player.getLife() - iv.getDamage());
				if(player.getLife() <= 0)
					return GameModel.GAME_OVER;
			}
		}

		if (invaders.isEmpty())
			return GAME_LEVEL_DONE;

		return GAME_RUNNING;
	}

	public void playerShoot() {
		missiles.add(player.shoot());
	}

	private boolean invadersMoveRightOk() {
		if (InvadersPos.mostRight(invaders).moveRightOk())
			return true;
		return false;
	}

	private boolean invadersMoveLeftOk() {
		if (InvadersPos.mostLeft(invaders).moveLeftOk())
			return true;
		return false;
	}

	public Ship getPlayer() {
		return player;
	}

	public ArrayList<Invader> getInvaders() {
		return invaders;
	}

	public void setScore(int score) {
		this.score = score;
		setChanged();
	}

	public int getScore() {
		return score;
	}

	public List<Missile> getMissiles() {
		return missiles;
	}

}
