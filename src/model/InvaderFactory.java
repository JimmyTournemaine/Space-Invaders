package model;

import java.awt.Point;

public class InvaderFactory {

	public static Invader createBasicInvader(Point pos) {
		return new Invader(pos, "assets/invader1.png", 1.0f, 1.0f, 0);
	}
}
