package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {

	protected Point position;
    protected int width;
    protected int height;
    protected Image image;

    public Sprite(Point pt) {
        this.position = pt;
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Image getImage() {
        return image;
    }

    public Point getPosition() {
        return position;
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(position.x, position.y, width, height);
    }
    
    public void drawOn(Graphics g)
    {
    	g.drawImage(getImage(), position.x, position.y, null);
    }
}
