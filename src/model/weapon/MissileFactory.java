package model.weapon;

import java.awt.Point;

public class MissileFactory {

	public static int[] weapons = { 500, 1000, 20 };
	public static int MISSILE = 0;
	public static int LASER = 1;
	public static int MACHINEGUN = 2;

	/* Player missile */
	public static Missile createPlayerMissile(Point pos, int type) {
		switch(type){
		case 0 : return new Missile((Point) pos.clone(), "assets/missile.png", Missile.NORTH);
		case 1 : return new Laser((Point) pos.clone(), "assets/laser.png", Missile.NORTH);
		default: throw new RuntimeException("This kind of missile does not exists");
		}
	}
	
	/* Invader Missile */
	public static Missile createBasicMissile(Point pos) {
		return new Missile((Point) pos.clone(), "assets/missile2.png", Missile.SOUTH);
	}
	
	
}
