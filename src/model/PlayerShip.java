/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

import java.awt.Point;

import model.weapon.MissileFactory;
import model.weapon.ShootCooldown;

/**
 * The ship of the player
 * 
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class PlayerShip extends Ship {

	private final static String IMAGE = "assets/pl6.png";
	private final static float LIFE = 3.0f;
	private final static int SPEED = 5;
	private final static float DAMAGE = 1.0f;
	public final static int MAX_MISSILES = 150;

	private boolean invincible = false;
	private boolean canShoot = true;
	public int weapon = 0;

	public PlayerShip() {
		super(new Point(100, GameModel.HEIGHT - 100), IMAGE, LIFE, DAMAGE);
		this.setSpeed(SPEED);
		this.setNbMissiles(MAX_MISSILES);
	}

	@Override
	public void shoot() {
		if (getNbMissiles() <= 0 || !canShoot)
			return;

		this.playSound(MissileFactory.sounds[weapon]);
		GameModel.missiles.add(MissileFactory.createPlayerMissile(position, weapon));
		setNbMissiles(getNbMissiles() - 1);
		(new ShootCooldown(this, MissileFactory.weapons[weapon])).start();

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

	/**
	 * Take damages from another object. Will have some invincibles frames.
	 */
	@Override
	public void takeDamageFrom(AliveObject ao) {
		if (!invincible) {
			super.takeDamageFrom(ao);

			if (!isDead()) {
				(new InvincibleFrames(this)).start();
			}
		}
	}

	/**
	 * Return if the player is invincible
	 * 
	 * @return If the user is invincible
	 */
	public boolean isInvincible() {
		return invincible;
	}

	/**
	 * Set the invincible state of the player
	 * 
	 * @param invincible
	 *            If the user will invincible
	 */
	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}

	/**
	 * Add lifes
	 * 
	 * @param l
	 *            The number of lifes to add
	 */
	public void addLife(float l) {
		life += l;
	}

	/**
	 * Get the number of remaining missiles
	 * 
	 * @return the number of remaining missiles
	 */
	public int remainingMissiles() {
		return getNbMissiles();
	}

	/**
	 * Set if the user can shoot (cooldown)
	 * 
	 * @param boo
	 *            If the user could shoot
	 */
	public void setCanShoot(boolean boo) {
		canShoot = boo;
	}

	/**
	 * Set the weapon of the player
	 * 
	 * @param weapon
	 *            The new weapon
	 */
	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	/**
	 * Gave ammo to the player
	 * 
	 * @param fire
	 *            The number of ammo to give to the user
	 */
	public void addFire(int fire) {
		this.setNbMissiles(this.getNbMissiles() + fire);
	}

	/**
	 * Set the damages of the player ship
	 * 
	 * @param float
	 *            The new damages
	 */
	public void setDamage(float damage) {
		super.setDamage(damage);
		this.damage = damage;
		if (this.damage > 1) {
			this.loadImage("assets/pl2.png");
		}
		if (this.damage == 1) {
			this.loadImage(IMAGE);
		}
	}
}
