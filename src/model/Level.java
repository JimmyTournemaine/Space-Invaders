package model;

import java.awt.Point;
import java.util.*;

import exception.NoMoreLevelException;

public class Level {
	
	public static ArrayList<Invader> create(int l) {
		switch (l) {
		case 1: return level1();
		default: throw new NoMoreLevelException();
		}
	}

	private static ArrayList<Invader>  level1() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 1; i<5; i++){
			invaders.add(InvaderFactory.createBasicInvader(new Point(i*100, 10)));
		}
		return invaders;
	}
	
	
}
