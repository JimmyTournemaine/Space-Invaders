/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Represents a ship
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public abstract class Ship extends AliveObject {
	
	private int nbMissiles;
	protected boolean visible = true;
	
	/**
	 * Create the ship
	 * @param pos The position of ship
	 * @param imageName The image for the sprite
	 * @param life The life the ship
	 * @param damage Its damages
	 */
	public Ship (Point pos, String imageName, float life, float damage){
		super(pos, imageName, life, damage);
		this.setNbMissiles(0);
	}
	
	public void takeDamageFrom(AliveObject ao) {
		super.takeDamageFrom(ao);

		if (!isDead()) {
			(new VisibilityFrame(this)).start();
		}
	}
	
	abstract public void shoot();
	
	public void dx(int dx) {
		this.direction.x = dx;
	}
	
	public void dy(int dy) {
		this.direction.y = dy;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void drawOn(Graphics g) {
		if (visible)
			super.drawOn(g);
	}

	protected synchronized void playSound(String sound) {
		new Thread(new Runnable() {
			public void run() {
				try {
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(sound));
					Clip clip;
					clip = AudioSystem.getClip();
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public int getNbMissiles() {
		return nbMissiles;
	}

	public void setNbMissiles(int nbMissiles) {
		this.nbMissiles = nbMissiles;
	}
}
