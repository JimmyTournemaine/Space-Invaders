package model;

import java.util.List;

import model.invaders.Invader;

public class InvadersPos {

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
	
	public static Invader farButton(List<Invader> invaders){
		Invader min = invaders.get(0);
		for (int i = 1; i<invaders.size();i++){
			if (min.position.getY() > invaders.get(i).position.getX()) min = invaders.get(i);
		}
		return min;
	}
	
	public static boolean invadersMoveRightOk(List<Invader> invaders){
		if (InvadersPos.mostRight(invaders).moveRightOk()) return true;
		return false;
	}
	
	public static boolean invadersMoveLeftOk(List<Invader> invaders){
		if (InvadersPos.mostLeft(invaders).moveLeftOk()) return true;
		return false;
	}
	
	public static boolean invadersMoveDownOk(List<Invader> invaders){
		if (InvadersPos.farButton(invaders).moveDownOk()) return true;
		return false;
	}
	
	
}
