package model;

public class InvincibleFrames extends Thread {
	

	private final static int INVINCIBLE_FRAME = 100;
	
	private PlayerShip player;
	
	public InvincibleFrames(PlayerShip player) {
		this.player = player;
		player.setInvincible(true);
	}
	
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
