/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

public class InvincibleFrames extends Thread {

	private final static int INVINCIBLE_FRAME = 1000;

	private PlayerShip player;

	public InvincibleFrames(PlayerShip player) {
		this.player = player;
		player.setInvincible(true);
	}

	public void run() {
		try {
			Thread.sleep(INVINCIBLE_FRAME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		player.setInvincible(false);
	}

}
