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
		invaders.add(InvaderFactory.createBoss1Invader());
		return invaders;
	}
	
	
}
