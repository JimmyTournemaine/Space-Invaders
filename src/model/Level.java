package model;

import java.awt.Point;
import java.util.*;

import exception.NoMoreLevelException;
import model.invader.Invader;
import model.invader.InvaderFactory;

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
		for (int i = 1; i<5; i++){
			invaders.add(InvaderFactory.createStrongInvader(new Point(i*100, 110)));
		}
		for (int i = 1; i<5; i++){
			invaders.add(InvaderFactory.createBonusInvader(new Point(i*100, 210)));
		}
		return invaders;
	}
	
	
}
