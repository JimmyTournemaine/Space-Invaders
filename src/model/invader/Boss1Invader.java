/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.invader;

import java.awt.Point;
import java.util.Random;

import model.AliveObject;
import model.GameModel;
import model.bonus.Bonus;
import model.bonus.BonusGenerator;
import model.weapon.MissileFactory;

/**
 * The boss a the first boss level
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class Boss1Invader extends FightInvader {
	
	private int SPEED = 1;
	
	/**
	 * Create the boss
	 */
	public Boss1Invader() {
		super(new Point(10,10), "assets/boss1.png", 100f, 2.0f, 5);
		this.setSpeed(SPEED);
	}
	
	/**
	 * The boss will move in a shorter area because it is bigger
	 */
	public void move() {
		super.move();
		
		if(this.getBounds().getMinX() <= 10)
			direction.x = 1;
		else if(this.getBounds().getMaxX() >= GameModel.WIDTH-10)
			direction.x = -1;
	}

	/**
	 * The boss shoot multiple missiles at a time
	 */
	public void shoot() {
		for(int i=0; i<10; i++) {
			Random rn = new Random();
			int r = rn.nextInt(3);
			GameModel.missiles.add(MissileFactory.createBasicMissile(new Point(position.x+i*40, position.y), r));
		}
	}
	
	public void takeDamageFrom(AliveObject ao) {
		super.takeDamageFrom(ao);
		
		if(life % 20 == 0) {
			Bonus b = BonusGenerator.generate(this);

			System.out.println(b);
			if(b!=null) {
				GameModel.bonus.add(b);
			}
		}
	}

}
