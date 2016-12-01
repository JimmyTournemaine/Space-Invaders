package model;

import java.awt.Point;
import java.util.*;

import model.bonus.Bonus;
import model.bonus.BonusGenerator;
import model.invader.Invader;

public class GameModel extends Observable {

	public final static int GAME_RUNNING = 0;
	public final static int GAME_LEVEL_DONE = 1;
	public final static int GAME_OVER = 2;

	public final static int HEIGHT = 600;
	public final static int WIDTH = 800;

	private int level;
	private int score;
	private PlayerShip player;
	private ArrayList<Invader> invaders;
	private Invader leftest;
	private Invader rightest;
	public static List<Missile> missiles;
	public static List<Bonus> bonus;

	public GameModel() {
		this.newGame();
		BonusGenerator.setModel(this);
	}

	public void newGame() {
		player = new PlayerShip();
		missiles = new ArrayList<Missile>();
		bonus = new ArrayList<Bonus>();
		level = 1;
		score = 0;
		invaders = Level.create(1);
		this.extremaInvaders();
	}

	public void nextLevel() {
		level++;
		invaders = Level.create(level);
		this.extremaInvaders();
	}

	/**
	 * Update the invader the most at right and at left
	 */
	private void extremaInvaders() {
		if (invaders.isEmpty()) {
			return;
		}

		if (leftest == null)
			leftest = invaders.get(0);
		if (rightest == null)
			rightest = invaders.get(0);

		if (!invaders.isEmpty()) {
			for (Invader iv : invaders) {
				Point pos = iv.getPosition();
				if (pos.x < leftest.getPosition().x) {
					leftest = iv;
				}
				if (pos.x > rightest.getPosition().x) {
					rightest = iv;
				}
			}
		}
	}

	public int move() {

		/* Move player */
		player.move();

		/* Move missiles */
		Iterator<Missile> it = missiles.iterator();
		while (it.hasNext()) {
			Missile m = it.next();
			m.move();

			/* Missile is out */
			if (m.getBounds().getMinY() <= 0 || m.getBounds().getMaxY() >= GameModel.HEIGHT) {
				it.remove();
				continue;
			}

			/* Missile collision */
			if (m.dy() > 0) { // Invader missile
				if (m.intersect(player)) {
					player.takeDamageFrom(m);
				}
			} else { // Player missile
				Iterator<Invader> it1 = invaders.iterator();
				while (it1.hasNext()) {
					Invader inv = it1.next();
					if (inv.intersect(m)) {
						inv.takeDamageFrom(m);
						m.takeDamage();
						if (inv.isDead())
							it1.remove();
						if (m.isDead()) {
							it.remove();
							this.extremaInvaders();
						}
					}
				}
			}
		}

		/* Move invaders */
		if (leftest.getBounds().getMinX() <= 0) {
			for (Invader iv : invaders) {
				iv.getPosition().translate(0, iv.getBounds().height);
				iv.dx(1);
			}
		} else if (rightest.getBounds().getMaxX() >= GameModel.WIDTH) {
			for (Invader iv : invaders) {
				iv.getPosition().translate(0, iv.getBounds().height);
				iv.dx(-1);
			}
		}
		Iterator<Invader> it2 = invaders.iterator();
		while (it2.hasNext()) {
			Invader iv = it2.next();
			iv.move();
			if (iv.intersect(player))
				player.takeDamageFrom(iv);
		}

		/* Check model state */
		if (invaders.isEmpty())
			return GAME_LEVEL_DONE;
		if (player.isDead())
			return GAME_OVER;
		return GAME_RUNNING;
	}

	public PlayerShip getPlayer() {
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
