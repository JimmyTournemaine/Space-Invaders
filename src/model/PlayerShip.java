package model;

import java.awt.Graphics;
import java.awt.Point;

import model.weapon.MissileFactory;
import model.weapon.ShootCooldown;

public class PlayerShip extends Ship {

	private final static String IMAGE = "assets/playership.png";
	private final static float LIFE = 3.0f;
	private final static int SPEED = 5;
	private final static float DAMAGE = 1.0f;
	public final static int MAX_MISSILES = 150;

	private boolean invincible = false;
	private boolean visible = true;
	private boolean canShoot = true;
	private int weapon = 1;

	public PlayerShip() {
		super(new Point(100, GameModel.HEIGHT-100), IMAGE, LIFE, DAMAGE);
		this.speed = SPEED;
		this.nbMissiles = MAX_MISSILES;
	}

	@Override
	public void shoot() {
		if(nbMissiles <= 0 || !canShoot)
			return;
		
		GameModel.missiles.add(MissileFactory.createPlayerMissile(position, weapon));
		nbMissiles--;
		(new ShootCooldown(this)).start();
		
	}

	@Override
	public void move() {

		super.move();

		if (this.getBounds().getMinX() <= 0) {
			position.x = 0;
		} else if (this.getBounds().getMaxX() >= GameModel.WIDTH) {
			position.x = GameModel.WIDTH - width;
		}
		if (this.getBounds().getMinY() <= 0) {
			position.y = 0;
		} else if (this.getBounds().getMaxY() >= GameModel.HEIGHT) {
			position.y = GameModel.HEIGHT - height;
		}
	}

	public void takeDamageFrom(AliveObject ao) {
		if (!invincible) {
			super.takeDamageFrom(ao);

			if (!isDead()) {
				(new InvincibleFrames(this)).start();
			}
		}
	}

	public boolean isInvincible() {
		return invincible;
	}

	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void drawOn(Graphics g) {
		if (visible)
			super.drawOn(g);
	}
	
	public void addLife(float l) {
		life += l;
	}

	public int remainingMissiles() {
		return nbMissiles;
	}
	
	public void setCanShoot(boolean boo) {
		canShoot = boo;
	}
}
