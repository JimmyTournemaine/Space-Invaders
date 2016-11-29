package model.invaders;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Position;

public class Invader2 extends Invader {

	public Invader2(Position pos) {
		super(pos);
		this.life = 1.5f;
	}

	@Override
	public Image getSprite() throws IOException {
		return ImageIO.read(new File("assets/invader2.png"));
	}

}
