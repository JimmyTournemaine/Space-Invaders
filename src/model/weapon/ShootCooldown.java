/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model.weapon;

import model.PlayerShip;

/**
 * The cooldown when the player or a mob shoot
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class ShootCooldown extends Thread {

	private  int coolDown = 500;

	private PlayerShip player;

	public ShootCooldown(PlayerShip player, int coolDown) {
		this.player = player;
		player.setCanShoot(false);
		this.coolDown = coolDown;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(coolDown);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		player.setCanShoot(true);
	}

}
