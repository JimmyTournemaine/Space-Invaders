package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Iterator;

import model.invaders.Invader;

public class InvadersPos {

	public static Invader mostRight(ArrayList<Invader> invaders){
		Iterator<Invader> itr = invaders.iterator();
		Invader max = itr.next();
		while(itr.hasNext()){
			Invader inv = itr.next();
			if (max.position.getX() < inv.position.getX()) max = inv;
		}
		return max;
	}
	
	public static Invader mostLeft(ArrayList<Invader> invaders){
		Iterator<Invader> itr = invaders.iterator();
		Invader min = itr.next();
		while(itr.hasNext()){
			Invader inv = itr.next();
			if (min.position.getX() > inv.position.getX()) min = inv;
		}
		return min;
	}
	
	public static Invader farButton(ArrayList<Invader> invaders){
		Iterator<Invader> itr = invaders.iterator();
		Invader min = itr.next();
		while(itr.hasNext()){
			Invader inv = itr.next();
			if (min.position.getY() > inv.position.getY()) min = inv;
		}
		return min;
	}
	
	public static boolean invadersMoveRightOk(ArrayList<Invader> invaders){
		if (InvadersPos.mostRight(invaders).moveRightOk()) return true;
		return false;
	}
	
	public static boolean invadersMoveLeftOk(ArrayList<Invader> invaders){
		if (InvadersPos.mostLeft(invaders).moveLeftOk()) return true;
		return false;
	}
	
	public static boolean invadersMoveDownOk(ArrayList<Invader> invaders){
		if (InvadersPos.farButton(invaders).moveDownOk()) return true;
		return false;
	}
	
	
}
