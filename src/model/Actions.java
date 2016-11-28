package model;

import java.util.*;

import model.invaders.*;

public class Actions {
	
	public static ArrayList<Invader> create(int l, Map m) {
		switch (l) {
		case 1:
			return level1(m);
			default: throw new RuntimeException("the level doesn't exist");
		}
	}

	private static ArrayList<Invader> level1(Map m) {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 4; i < 11; i++)
			invaders.add(new Invader1(m, new Position(i, m.limitHeight)));
		return invaders;
	}
	
	public static Invader mostRight(List<Invader> invaders){
		Invader max = invaders.get(0);
		for (int i = 1; i<invaders.size();i++){
			if (max.position.getX() < invaders.get(i).position.getX()) max = invaders.get(i);
		}
		return max;
	}
	
	public static Invader mostLeft(List<Invader> invaders){
		Invader min = invaders.get(0);
		for (int i = 1; i<invaders.size();i++){
			if (min.position.getX() > invaders.get(i).position.getX()) min = invaders.get(i);
		}
		return min;
	}
	
}
