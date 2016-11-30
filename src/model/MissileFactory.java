package model;

import java.awt.Point;

public class MissileFactory {

	public static Missile createPlayerMissile(Point pos) {
		return new Missile((Point) pos.clone(), Missile.NORTH);
	}
	
	public static Missile createBasicMissile(Point pos) {
		return new Missile((Point) pos.clone(), Missile.SOUTH);
	}
	
	
}
