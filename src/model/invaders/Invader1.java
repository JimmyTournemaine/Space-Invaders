package model.invaders;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Map;
import model.Position;

public class Invader1 extends Invader {

	public Invader1(Map myMap, Position pos) {
		super(myMap, pos);
	}

	@Override
	public Image getSprite() throws IOException {
		return ImageIO.read(new File("assets/invader1.png"));
	}

}
