package model.weapon;

import model.PlayerShip;

public class ShootCooldown extends Thread {

	private final static int COOLDOWN = 500;

	private PlayerShip player;

	public ShootCooldown(PlayerShip player) {
		this.player = player;
		player.setCanShoot(false);
	}

	public void run() {
		try {
			Thread.sleep(COOLDOWN);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		player.setCanShoot(true);
	}

}
