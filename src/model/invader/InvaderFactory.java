package model.invader;

import java.awt.Point;

public class InvaderFactory {

	public static Invader createBasicInvader(Point pos) {
		return new Invader(pos, "assets/invader1.png", 1.0f, 1.0f);
	}
	public static Invader createStrongInvader(Point pos) {
		return new Invader(pos, "assets/invader2.png", 3.0f, 1.5f);
	}
	public static Invader createBonusInvader(Point pos) {
		return new BonusInvader(pos, "assets/invader3.png", 1.0f, 1.0f);
	}
	public static Invader createShiedInvader(Point pos) {
		return new ShieldedInvader(pos, "assets/invader4.png", 1.0f, 1.0f);
	}
	public static Invader createFightInvader(Point pos) {
		return new FightInvader(pos, "assets/invader5.png", 1.0f, 1.0f);
	}
}
