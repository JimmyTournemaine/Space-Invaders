package model;

import java.awt.Graphics;
import java.awt.Point;

public class PlayerShip extends Ship {

	private final static String IMAGE = "assets/playership.png";
	private final static float LIFE = 3.0f;
	private final static int SPEED = 5;
	private final static float DAMAGE = 1.0f;
	private final static float SHIELD = 0.0f;

	private boolean invincible = false;
	private boolean visible = true;

	public PlayerShip() {
		super(new Point(100, GameModel.HEIGHT-100), IMAGE, LIFE, DAMAGE, SHIELD);
		this.speed = SPEED;
	}

	@Override
	public Missile shoot() {
		return MissileFactory.createPlayerMissile(position);
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

	public void takeDamageFrom(AnimatedObject ao) {
		if (!invincible) {
			super.takeDamageFrom(ao);

			if (!isDead()) {
				Thread invincible = new InvincibleFrames(this);
				invincible.start();
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
}
