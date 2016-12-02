package model;

import java.awt.Point;
import java.util.*;

import exception.NoMoreLevelException;
import model.invader.Invader;
import model.invader.InvaderFactory;

public class Level {
	static private final int lowestSpeed = 1;
	static private final int veryLowSpeed = 2;
	static private final int lowSpeed = 3;
	static private final int mediumSpeed = 4;
	static private final int fastSpeed = 5;
	

	public static ArrayList<Invader> create(int l) {
		switch (l) {
		case 1: return level1();
		case 2: return level2();
		case 3: return level3();
		case 4: return level4();
		case 5: return level5();
		case 6: return level6();
		default: throw new NoMoreLevelException();
		}
	}

	private static ArrayList<Invader>  level1() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 1; i<3; i++){
			invaders.add(InvaderFactory.createBonusInvader(new Point(i*100, 10), lowestSpeed ));
		}
		{
			invaders.add(InvaderFactory.createStrongInvader(new Point(150, 60), lowestSpeed));
		}
		for (int i = 1; i<3; i++){
			invaders.add(InvaderFactory.createBonusInvader(new Point(i*100, 110), lowestSpeed));
		}
		return invaders;
	}
	
	private static ArrayList<Invader>  level2() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 1; i<4; i++){
			invaders.add(InvaderFactory.createFightInvader(new Point(i*100, 10),veryLowSpeed));
		}
		for (int i = 1; i<5; i++){
			if (i % 2 == 0) invaders.add(InvaderFactory.createStrongInvader(new Point(i*100, 60),veryLowSpeed));
			else invaders.add(InvaderFactory.createBonusInvader(new Point(i*100, 60),veryLowSpeed));
		}
		for (int i = 1; i<4; i++){
			invaders.add(InvaderFactory.createBonusInvader(new Point(i*100, 110),veryLowSpeed));
		}
		return invaders;
	}
	
	private static ArrayList<Invader>  level3() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 1; i<5; i++){
			invaders.add(InvaderFactory.createFightInvader(new Point(i*100, 10),lowSpeed));
		}
		for (int i = 1; i<5; i++){
			invaders.add(InvaderFactory.createStrongInvader(new Point(i*100, 60),lowSpeed));
		}
		for (int i = 1; i<5; i++){
			invaders.add(InvaderFactory.createBonusInvader(new Point(i*100, 110),lowSpeed));
		}
		return invaders;
	}
	
	private static ArrayList<Invader>  level4() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 1; i<5; i++){
			invaders.add(InvaderFactory.createFightInvader(new Point(i*100, 10),mediumSpeed));
		}
		for (int i = 1; i<5; i++){
			invaders.add(InvaderFactory.createFightInvader(new Point(i*100, 60),mediumSpeed));
		}
		for (int i = 1; i<5; i++){
			invaders.add(InvaderFactory.createBonusInvader(new Point(i*100, 110),mediumSpeed));
		}
		return invaders;
	}
	
	private static ArrayList<Invader>  level5() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 1; i<7; i++){
			invaders.add(InvaderFactory.createBasicInvader(new Point(i*100, 10),fastSpeed));
		}
		for (int i = 1; i<7; i++){
			invaders.add(InvaderFactory.createStrongInvader(new Point(i*100, 60),fastSpeed));
		}
		for (int i = 1; i<8; i++){
			invaders.add(InvaderFactory.createBonusInvader(new Point(i*100, 110),fastSpeed));
		}
		return invaders;
	}

	private static ArrayList<Invader>  level6() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		invaders.add(InvaderFactory.createBoss1Invader());
		
		return invaders;
	}
		
}
