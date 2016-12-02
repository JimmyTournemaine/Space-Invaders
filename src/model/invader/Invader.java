/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.invader;

import java.awt.Point;
import java.util.Random;

import model.GameModel;
import model.Ship;
import model.weapon.MissileFactory;

/**
 * Represents an ivader
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class Invader extends Ship {
	
	public Invader(Point pos, String imageName, float life, float damage, int speed) {
		super(pos, imageName, life, damage);
		this.direction = new Point(-1,0);
		this.speed = speed;
	}

	@Override
	public void shoot() {
		if(nbMissiles <= 0)
			return;
		Random rn = new Random();
		int r = rn.nextInt(3);
		
		GameModel.missiles.add(MissileFactory.createBasicMissile(position,r));
		nbMissiles--;
	}

	@Override
	public void move() {
		position.translate(direction.x*speed, direction.y*speed);
	}
	
	
}
