/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

import java.awt.Point;
import java.io.File;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;

import model.bonus.Bonus;
import model.bonus.BonusGenerator;
import model.invader.Invader;
import model.weapon.Missile;

/**
 * Game Model is the main class of our model
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class GameModel extends Observable implements LineListener {

	public final static int GAME_RUNNING = 0;
	public final static int GAME_LEVEL_DONE = 1;
	public final static int GAME_OVER = 2;

	public final static int HEIGHT = 600;
	public final static int WIDTH = 1024;

	private int level;
	private int score;
	private PlayerShip player;
	private ArrayList<Invader> invaders;
	private Invader leftest;
	private Invader rightest;
	public static List<Missile> missiles;
	public static List<Bonus> bonus;
	private Clip clip;

	public GameModel() {
		try {
			clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("assets/music.wav"));
			clip.open(inputStream);
			clip.addLineListener(this);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		this.newGame();
		BonusGenerator.setModel(this);
	}

	private synchronized void playSound() {
		new Thread(new Runnable() {
			public void run() {
				clip.start();
			}
		}).start();
	}

	@Override
	public void update(LineEvent event) {
		if (event.getType() == Type.STOP) {
			clip.setMicrosecondPosition(0);
			clip.start();
		}
	}

	public void newGame() {
		player = new PlayerShip();
		missiles = new ArrayList<Missile>();
		bonus = new ArrayList<Bonus>();
		level = 1;
		score = 0;
		invaders = Level.create(1);
		this.extremaInvaders();
		this.playSound();
	}

	public void nextLevel() {
		level++;
		invaders = Level.create(level);
		this.extremaInvaders();
	}

	private void extremaInvaders() {
		minXInvader();
		maxXInvader();
	}

	/**
	 * Update the invader the most at right and at left
	 */
	private void minXInvader() {

		if (invaders.isEmpty()) {
			return;
		}

		leftest = invaders.get(0);

		for (int i = 1; i < invaders.size(); i++) {
			Invader iv = invaders.get(i);
			Point pos = iv.getPosition();
			if (pos.x < leftest.getPosition().x) {
				leftest = iv;
			}
		}

	}

	private void maxXInvader() {
		if (invaders.isEmpty()) {
			return;
		}

		rightest = invaders.get(0);

		for (int i = 1; i < invaders.size(); i++) {
			Invader iv = invaders.get(i);
			Point pos = iv.getPosition();
			if (pos.x > rightest.getPosition().x) {
				rightest = iv;
			}
		}
	}

	public int move() {

		player.move();

		/* Move missiles */
		Iterator<Missile> it = missiles.iterator();
		while (it.hasNext()) {
			Missile m = it.next();
			m.move();

			/* Missile is out */
			if (m.getBounds().getMaxY() <= 0 || m.getBounds().getMinY() >= GameModel.HEIGHT) {
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
						if (inv.isDead()) {
							it1.remove();
							if (inv == leftest)
								this.minXInvader();
							if (inv == rightest)
								this.maxXInvader();
							score += 10 * inv.getDamage();
						}
						if (m.isDead()) {
							it.remove();
							;
						}
						break;
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
			if(iv.getBounds().getMinY() <= 0)
				return GAME_OVER;
			if (iv.intersect(player))
				player.takeDamageFrom(iv);
		}

		/* Move and activate bonus */
		Iterator<Bonus> it3 = bonus.iterator();
		while (it3.hasNext()) {
			Bonus b = it3.next();
			b.move();
			if (b.intersect(player)) {
				b.activate();
				it3.remove();
			}
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
