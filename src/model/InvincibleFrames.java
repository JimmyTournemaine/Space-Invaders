/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

/**
 * The player needs to be invincible during some frames before
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class InvincibleFrames extends Thread {
	

	private final static int INVINCIBLE_FRAME = 100;
	
	private PlayerShip player;
	
	public InvincibleFrames(PlayerShip player) {
		this.player = player;
		player.setInvincible(true);
	}
	
	@Override
	public void run() {
		for(int i=0 ; i<=10; i++) {
			player.setVisible(i%2 == 0);
			
			try {
				Thread.sleep(INVINCIBLE_FRAME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		player.setInvincible(false);
	}

}
