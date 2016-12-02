/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.invader;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.AliveObject;

/**
 * An invader that have a shield
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class ShieldedInvader extends Invader {

	private boolean shield = true;
	private Image shieldImage;
	
	/**
	 * Create a shielded invader
	 * @param pos The position of the invader
	 * @param imageName The image for the sprite
	 * @param life The life of the invader
	 * @param damage The damages
	 * @param speed The speed of the invader
	 */
	public ShieldedInvader(Point pos, String imageName, float life, float damage, int speed) {
		super(pos, imageName, life, damage,speed);
		ImageIcon ii = new ImageIcon("assets/shield.png");
		shieldImage = ii.getImage();
	}
	
	/**
	 * Loose its shield the first time, take damages from a missile next
	 *
	 */
	@Override
	public void takeDamageFrom(AliveObject ao)
	{
		if(shield) {
			shield = false;
		} else {
			super.takeDamageFrom(ao);
		}
	}
	
	@Override
	public void drawOn(Graphics g)
	{
		super.drawOn(g);
		if(shield)
			g.drawImage(shieldImage, position.x-8, position.y-15, null);
	}

	
	
}
