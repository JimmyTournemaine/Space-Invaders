/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

public class VisibilityFrame extends Thread {
private final static int VISIBLE_FRAME = 100;
	
	private Ship ship;
	
	public VisibilityFrame(Ship sh) {
		this.ship = sh;
		ship.setVisible(true);
	}
	
	public void run() {
		for(int i=0 ; i<=10; i++) {
			ship.setVisible(i%2 == 0);
			
			try {
				Thread.sleep(VISIBLE_FRAME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ship.setVisible(true);
	}
}
