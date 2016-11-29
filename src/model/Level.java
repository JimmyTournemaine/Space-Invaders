package model;

import java.util.*;

import exception.NoMoreLevelException;
import model.invaders.*;

public class Level {
	
	public static ArrayList<Invader> create(int l) {
		switch (l) {
		case 1: return level1();
		case 2: return level2();
		case 3: return level3();
		default: throw new NoMoreLevelException();
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

	private static ArrayList<Invader>  level2() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 2; i < GameModel.CELL_HEIGHT-4; i++){
			Invader inv = new Invader1(new Position(i, GameModel.CELL_HEIGHT-2));
			invaders.add(inv);
		}
		for (int i = 2; i < GameModel.CELL_HEIGHT-4; i++){
			Invader inv = new Invader2(new Position(i, GameModel.CELL_HEIGHT-1));
			invaders.add(inv);
		}
		return invaders;
	}

	private static ArrayList<Invader>  level3() {
		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (int i = 2; i < GameModel.CELL_HEIGHT-4; i++){
			Invader inv = new Invader1(new Position(i, GameModel.CELL_HEIGHT-3));
			invaders.add(inv);
		}
		for (int i = 2; i < GameModel.CELL_HEIGHT-4; i++){
			Invader inv = new Invader2(new Position(i, GameModel.CELL_HEIGHT-2));
			invaders.add(inv);
		}
		for (int i = 1; i < GameModel.CELL_HEIGHT-3; i++){
			Invader inv = new Invader2(new Position(i, GameModel.CELL_HEIGHT-1));
			invaders.add(inv);
		}
		return invaders;
	}
	
	
}
