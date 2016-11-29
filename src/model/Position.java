package model;

public class Position {
	private int posX;
	private int posY;

	public Position(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public int getX() {
		return this.posX;
	}

	public int getY() {
		return this.posY;
	}

	void updateX(int newX) {
		this.posX = newX;
	}

	void updateY(int newY) {
		this.posY = newY;
	}

	public boolean equals(Object o) {
		Position p = (Position) o;
		return ((p.getX() == this.posX) && (p.getY() == this.posY));
	}
}
