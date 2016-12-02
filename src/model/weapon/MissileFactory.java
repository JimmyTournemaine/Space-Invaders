/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.weapon;

import java.awt.Point;

/**
 * A factory for missiles
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class MissileFactory {

	public static int MISSILE = 0;
	public static int LASER = 1;
	public static int MACHINEGUN = 2;
	public static int[] weapons = { 500, 1000, 20};
	

	/**
	 * Create a missile for the player
	 * @param pos The position of the missile
	 * @param type The weapon type
	 * @return The newly created missile
	 */
	public static Missile createPlayerMissile(Point pos, int type) {
		switch(type){
		case 0 : return new Missile((Point) pos.clone(), "assets/missile.png", Missile.NORTH);
		case 1 : return new Laser((Point) pos.clone(), "assets/laser.png", Missile.NORTH);
		case 2 : return new MachineGun((Point) pos.clone(), "assets/missile.png", Missile.NORTH);
		default: throw new RuntimeException("This kind of missile does not exists");
		}
	}
	
	/**
	 * Create a basic missile
	 * @param pos The position of the missile
	 * @param type The type of missile to drop
	 * @return The newly created missile
	 */
	public static Missile createBasicMissile(Point pos, int type) {
		switch(type){
		case 0 :return new Missile((Point) pos.clone(), "assets/ms3.png", Missile.SOUTH);
		case 1 : return new Missile((Point) pos.clone(), "assets/ms1.png", Missile.SOUTH);
		case 2 : return new Missile((Point) pos.clone(), "assets/ms2.png", Missile.SOUTH);
		default: throw new RuntimeException("This kind of missile does not exists");
		}
		
	}
	
	
}
