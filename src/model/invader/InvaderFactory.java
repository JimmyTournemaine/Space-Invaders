/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.invader;

import java.awt.Point;

/**
 * The factory for invaders
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class InvaderFactory {

	public static Invader createBasicInvader(Point pos, int speed) {
		return new Invader(pos, "assets/invader1.png", 1.0f, 1.0f,speed);
	}
	public static Invader createStrongInvader(Point pos, int speed) {
		return new Invader(pos, "assets/invader2.png", 3.0f, 1.5f, speed);
	}
	public static Invader createBonusInvader(Point pos, int speed) {
		return new BonusInvader(pos, "assets/invader3.png", 1.0f, 1.0f, speed);
	}
	public static Invader createShiedInvader(Point pos, int speed) {
		return new ShieldedInvader(pos, "assets/invader4.png", 1.0f, 1.0f, speed);
	}
	public static Invader createFightInvader(Point pos, int speed) {
		return new FightInvader(pos, "assets/invader5.png", 1.0f, 1.0f, speed);
	}
	public static Invader createBoss1Invader() {
		return new Boss1Invader();
	}
}
