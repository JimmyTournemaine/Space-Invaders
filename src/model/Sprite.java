/*
 * Created on 28 nov. 2016 under the authority of Alain Plantec 
 * as part of academic project at the University of Western Brittany
 */
package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * A sprite
 * @author Jean Arthur Ousmane
 * @author Jimmy Tournemaine
 * @author Mohammad Hammoud
 * @author Tahar Mezouari
 */
public class Sprite {

	protected Point position;
    protected int width;
    protected int height;
    protected Image image;

    public Sprite(Point pt) {
        this.position = pt;
    }

    /**
     * Load the image
     * @param imageName The name of the image
     */
    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    /**
     * Get the image
     * @return The image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Get the position
     * @return The position
     */
    public Point getPosition() {
        return position;
    }
    
    /**
     * Get the bounds of the sprite
     * @return The bounds
     */
    public Rectangle getBounds() {
    	return new Rectangle(position.x, position.y, width, height);
    }
    
    /**
     * Draw itself on a view
     * @param g The graphics
     */
    public void drawOn(Graphics g)
    {
    	g.drawImage(getImage(), position.x, position.y, null);
    }
}
