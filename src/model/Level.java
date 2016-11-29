package model;

import java.util.*;

import model.invaders.*;

public class Level {
	
	public static ArrayList<Invader> create(int l) {
		switch (l) {
		case 1:
			return level1();
			default: throw new RuntimeException("the level doesn't exist");
		}
	}

	private static ArrayList<Invader>  level1() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 4; i < GameModel.CELL_HEIGHT-4; i++){
			Invader inv = new Invader1(new Position(i, GameModel.CELL_HEIGHT-1));
			invaders.add(inv);
		}
		return invaders;
	}
	
	
}
