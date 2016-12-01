package model.bonus;

import java.awt.Point;

import model.GameModel;
import model.Ship;

public class StrongerPlayerBonus extends Bonus {

	private final int DURATION = 2000;
	private Thread effect;
	
	public StrongerPlayerBonus(Point position, GameModel model) {
		super(position, "assets/bonus-extralife.png", model);
		effect = new Effect();
	}

	@Override
	public void activate() {
		effect.start();
	}
	
	private class Effect extends Thread {
		
		public void run() {
			Ship player = model.getPlayer();
			float damage = player.getDamage();
			
			player.setDamage(damage*2);
			try {
				Thread.sleep(DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				player.setDamage(damage);
			}
		}
		
	}

}
