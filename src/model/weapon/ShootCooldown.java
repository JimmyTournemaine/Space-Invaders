package model.weapon;

import model.PlayerShip;

public class ShootCooldown extends Thread {

	private PlayerShip player;
	private int cooldown;

	public ShootCooldown(PlayerShip player, int millis) {
		this.player = player;
		this.cooldown = millis;
		player.setCanShoot(false);
	}

	public void run() {
		try {
			Thread.sleep(cooldown);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		player.setCanShoot(true);
	}

}
