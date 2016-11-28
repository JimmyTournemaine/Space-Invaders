package model;

public class Map {
	public int height;
	public int width;
	public int limitWidth;
	public int limitHeight;
	int nbCases;
	
    public Map(int width, int height)
    {
    	this.height = height;
    	this.width = width;
    	this.limitWidth = width - 1;
    	this.limitHeight = height - 1;
    	this.nbCases = width*height;
    }
	
	

}
